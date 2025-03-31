package ukim.finki.mk.lab1.dto;

import ukim.finki.mk.lab1.model.domain.User;
import ukim.finki.mk.lab1.model.enums.Role;

public record DisplayUserDto(String username, String name, String surname, Role role) {

    public static DisplayUserDto from(User user) {
        return new DisplayUserDto(
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getRole()
        );
    }

    public User toUser() {
        return new User(username, name, surname, role.name());
    }
}
