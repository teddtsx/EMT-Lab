package ukim.finki.mk.lab1.service.application;


import ukim.finki.mk.lab1.dto.CreateUserDto;
import ukim.finki.mk.lab1.dto.DisplayUserDto;
import ukim.finki.mk.lab1.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {

    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
}
