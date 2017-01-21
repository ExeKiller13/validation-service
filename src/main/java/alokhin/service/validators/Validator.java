package alokhin.service.validators;

public abstract class Validator {

    private StringBuilder state; // String message for error state

    public Validator() {
        state = new StringBuilder();
    }

    public StringBuilder getState() {
        return state;
    }


    abstract public boolean validate(String value); // Validation method
}
