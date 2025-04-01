package ukim.finki.mk.lab1.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.lab1.dto.CreateUserDto;
import ukim.finki.mk.lab1.dto.DisplayUserDto;
import ukim.finki.mk.lab1.dto.LoginUserDto;
import ukim.finki.mk.lab1.dto.WishlistDto;
import ukim.finki.mk.lab1.model.exeptions.InvalidArgumentsException;
import ukim.finki.mk.lab1.model.exeptions.InvalidUserCredentialsException;
import ukim.finki.mk.lab1.model.exeptions.PasswordDoNotMatchExeption;
import ukim.finki.mk.lab1.service.application.UserApplicationService;
import ukim.finki.mk.lab1.service.application.WishlistService;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User API", description = "Endpoints for user authentication and registration") // Swagger tag
public class UserController {

    private final UserApplicationService userApplicationService;
    private final WishlistService wishlistService;

    public UserController(UserApplicationService userApplicationService, WishlistService wishlistService) {
        this.userApplicationService = userApplicationService;
        this.wishlistService = wishlistService;
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
    @PostMapping("/login")
    public ResponseEntity<DisplayUserDto> login(HttpServletRequest request) {
        try {
            DisplayUserDto displayUserDto = userApplicationService.login(
                    new LoginUserDto(request.getParameter("username"), request.getParameter("password"))
            ).orElseThrow(InvalidUserCredentialsException::new);

            request.getSession().setAttribute("user", displayUserDto.toUser());
            return ResponseEntity.ok(displayUserDto);
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

    @PostMapping("/{username}/wishlist/{bookId}")
    public ResponseEntity<Void> addBookToWishlist(@PathVariable String username, @PathVariable Long bookId) {
        try {
            wishlistService.addBookToWishlist(username, bookId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{username}/wishlist")
    public ResponseEntity<WishlistDto> getWishlist(@PathVariable String username) {
        return ResponseEntity.ok(wishlistService.getWishlist(username));
    }

    @PostMapping("/{username}/wishlist/rent")
    public ResponseEntity<Void> rentBooksFromWishlist(@PathVariable String username) {
        try {
            wishlistService.rentBooksFromWishlist(username);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
