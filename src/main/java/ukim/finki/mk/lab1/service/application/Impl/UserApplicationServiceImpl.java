package ukim.finki.mk.lab1.service.application.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.lab1.dto.CreateUserDto;
import ukim.finki.mk.lab1.dto.DisplayUserDto;
import ukim.finki.mk.lab1.dto.LoginUserDto;
import ukim.finki.mk.lab1.model.domain.User;
import ukim.finki.mk.lab1.service.application.UserApplicationService;
import ukim.finki.mk.lab1.service.domain.UserService;

import java.util.Optional;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserService userService;

    public UserApplicationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
        User user = userService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.repeatPassword(),
                createUserDto.name(),
                createUserDto.surname(),
                createUserDto.role()
        );
        return Optional.of(DisplayUserDto.from(user));
    }

    @Override
    public Optional<DisplayUserDto> login(LoginUserDto loginUserDto) {
        return Optional.of(DisplayUserDto.from(userService.login(
                loginUserDto.username(),
                loginUserDto.password()
        )));
    }

    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userService.findByUsername(username)));
    }
}

