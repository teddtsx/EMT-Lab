package ukim.finki.mk.lab1.model.exeptions;


public class InvalidUserCredentialsException extends RuntimeException {

    public InvalidUserCredentialsException() {
        super("Invalid user credentials exception");
    }
}
