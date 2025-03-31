package ukim.finki.mk.lab1.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    LIBRERIAN,
    USER;


    @Override
    public String getAuthority() {
        return "";
    }
}
