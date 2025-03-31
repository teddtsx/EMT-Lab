package ukim.finki.mk.lab1.service.domain;

import org.springframework.security.core.userdetails.UserDetailsService;
import ukim.finki.mk.lab1.model.domain.User;
import ukim.finki.mk.lab1.model.enums.Role;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);
}
