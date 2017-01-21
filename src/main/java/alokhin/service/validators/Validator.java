package alokhin.service.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validator {

    private StringBuilder state; // String message for error state

    public Validator() {
        state = new StringBuilder();
    }

    public StringBuilder getState() {
        return state;
    }

    public boolean matchString(String expression, String string) {
        Pattern p = Pattern.compile(expression);
        Matcher m = p.matcher(string);

        return m.find();
    }

    abstract public boolean validate(String value); // Validation method
}
