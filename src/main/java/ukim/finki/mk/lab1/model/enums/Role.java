package ukim.finki.mk.lab1.model.enums;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.GrantedAuthority;

public enum Role  implements GrantedAuthority {
    ROLE_LIBRARIAN,
    ROLE_USER,
    ;

    @Override
    public String getAuthority() {
        return name();
    }
}
