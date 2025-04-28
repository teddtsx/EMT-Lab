package ukim.finki.mk.lab1.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.lab1.dto.*;
import ukim.finki.mk.lab1.model.exeptions.InvalidArgumentsException;
import ukim.finki.mk.lab1.model.exeptions.InvalidUserCredentialsException;
import ukim.finki.mk.lab1.model.exeptions.PasswordDoNotMatchExeption;
import ukim.finki.mk.lab1.service.application.UserApplicationService;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User API", description = "Endpoints for user authentication and registration")

public class AuthenticationController {

    private final UserApplicationService userApplicationService;
    public AuthenticationController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @Operation(summary = "Register a new user", description = "Creates a new user account")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User registered successfully"
            ), @ApiResponse(
                    responseCode = "400", description = "Invalid input or passwords do not match"
            )}
    )
    @PostMapping("/register")
    public ResponseEntity<DisplayUserDto> register(@RequestBody CreateUserDto createUserDto) {
        try {
            return userApplicationService.register(createUserDto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (InvalidArgumentsException | PasswordDoNotMatchExeption exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "User login", description = "Authenticates a user and starts a session")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User authenticated successfully"
            ), @ApiResponse(responseCode = "404", description = "Invalid username or password")}
    )
//    @PostMapping("/login")
//    public ResponseEntity<UserDisplayDto> login(HttpServletRequest request) {
//        try {
//            UserDisplayDto displayUserDto = userApplicationService.login(
//                    new LoginDto(request.getParameter("username"), request.getParameter("password"))
//            ).orElseThrow(InvalidUserCredentialsException::new);
//
//            request.getSession().setAttribute("user", displayUserDto.toUser());
//            return ResponseEntity.ok(displayUserDto);
//        } catch (InvalidUserCredentialsException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @PostMapping("/login")
//    public ResponseEntity<UserDisplayDto> login(HttpServletRequest request,
//                                                @RequestParam String username,
//                                                @RequestParam String password) {
//        try {
//            // Authenticate user (validate credentials)
//            UserDisplayDto displayUserDto = userApplicationService.login(
//                    new LoginDto(username, password)
//            ).orElseThrow(InvalidUserCredentialsException::new);
//
//            // Generate JWT token
//            String token = jwtUtil.generateToken(username);
//
//            // Optionally, you can set the token in the session or send it as a response
//            return ResponseEntity.ok()
//                    .header("Authorization", "Bearer " + token)  // Send token as Authorization header
//                    .body(displayUserDto);  // Send user details as part of response
//
//        } catch (InvalidUserCredentialsException e) {
//            return ResponseEntity.status(401).body(null);  // Unauthorized
//        }
//    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginUserDto loginDto) {
        try {
            return userApplicationService.login(loginDto)
                            .map(displayUserDto -> ResponseEntity.ok(new LoginResponseDTO(displayUserDto)))
                            .orElseThrow(InvalidUserCredentialsException::new);
        } catch (InvalidUserCredentialsException e) {
            return ResponseEntity.notFound().build();
        }
    }



    @Operation(summary = "User logout", description = "Ends the user's session")
    @ApiResponse(responseCode = "200", description = "User logged out successfully")
    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }

}
