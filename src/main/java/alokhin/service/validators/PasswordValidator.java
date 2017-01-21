package alokhin.service.validators;

public class PasswordValidator extends Validator {

    public PasswordValidator() {
        super();
    }

    private static final String PASSWORD_PATTERN_A = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
    private static final String PASSWORD_PATTERN_B = "^[\u0000-\u007F]*$";
    private static final String PASSWORD_PATTERN_C = "(?:abcd|dcba|bcde|edcb|cdef|fedc|defg|gfed|efgh|hgfe|fghi|ihgf|ghij|jihg|hijk|kjih|ijkl|lkji|jklm|mlkj|klmn|nmlk|lmno|onml|mnop|ponm|nopq|qpon|opqr|rqpo|pqrs|srqp|qrst|tsrq|rstu|utsr|stuv|vuts|tuvw|wvut|uvwx|xwvu|vwxy|yxwv|wxyz|zyxw|ABCD|DCBA|BCDE|EDCB|CDEF|FEDC|DEFG|GFED|EFGH|HGFE|FGHI|IHGF|GHIJ|JIHG|HIJK|KJIH|IJKL|LKJI|JKLM|MLKJ|KLMN|NMLK|LMNO|ONML|MNOP|PONM|NOPQ|QPON|OPQR|RQPO|PQRS|SRQP|QRST|TSRQ|RSTU|UTSR|STUV|VUTS|TUVW|WVUT|UVWX|XWVU|VWXY|YXWV|WXYZ|ZYXW|0123|3210|1234|4321|2345|5432|3456|6543|4567|7654|5678|8765|6789|9876)";
    private static final String PASSWORD_PATTERN_D = "(\\w+)\\1{3,}";

    @Override
    public boolean validate(String value) {

        boolean firstCondition = value.matches(PASSWORD_PATTERN_A); // Regular Expression showing the password satisfies the condition A
        if (!firstCondition) {
            getState().append("Failed password! Password must include numbers, letters, uppercase and lowercase letters!\n");
            return false;
        }

        boolean secondCondition = value.matches(PASSWORD_PATTERN_B); // Regular Expression showing the password satisfies the condition B
        if (!secondCondition) {
            getState().append("Failed password! Password can only be visible symbols of ASCII!\n");
            return false;
        }

        boolean thirdCondition = !matchString(PASSWORD_PATTERN_C,
                value); // Regular Expression showing the password satisfies the condition C
        if (!thirdCondition) {
            getState().append("Failed password! The number of letters and numbers in a row must be smaller than 4!\n");
            return false;
        }

        boolean fourthCondition = !matchString(PASSWORD_PATTERN_D,
                value); // Regular Expression showing the password satisfies the condition D
        if (!fourthCondition) {
            getState().append("Failed password! The number of same characters are no more than 3!\n");
            return false;
        }

        return true; // Validate successfully
    }
}
