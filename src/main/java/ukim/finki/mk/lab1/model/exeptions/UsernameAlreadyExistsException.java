package ukim.finki.mk.lab1.model.exeptions;


public class UsernameAlreadyExistsException extends RuntimeException {

    public UsernameAlreadyExistsException(String username) {
        super(String.format("User with username: %s already exists", username));
    }
}
