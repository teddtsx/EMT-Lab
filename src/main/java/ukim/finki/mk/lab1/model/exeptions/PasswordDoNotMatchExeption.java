package ukim.finki.mk.lab1.model.exeptions;

public class PasswordDoNotMatchExeption extends RuntimeException {

    public PasswordDoNotMatchExeption() {
        super("Passwords do not match exception.");
    }

}
