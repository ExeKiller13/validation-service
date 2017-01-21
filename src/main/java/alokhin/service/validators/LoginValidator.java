package alokhin.service.validators;

public class LoginValidator extends Validator {

    public LoginValidator() {
        super();
    }

    @Override
    public boolean validate(String value) {
        if (value == null || value.length() == 0) {
            getState().append("Login is empty!\n");
            return false;
        }

        return true;
    }
}
