package alokhin.service.validators;

public class EmailValidator extends Validator {

    public EmailValidator() {
        super();
    }

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean validate(String value) {
        if (value == null || value.length() == 0) {
            getState().append("Email is empty!\n");
            return false;
        }

        boolean emailValidation = matchString(EMAIL_PATTERN, value);
        if(!emailValidation) {
            getState().append("Incorrect Email!\n");
            return false;
        }

        return true;
    }
}
