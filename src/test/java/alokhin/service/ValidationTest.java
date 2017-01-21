package alokhin.service;

import alokhin.service.validators.EmailValidator;
import alokhin.service.validators.PasswordValidator;
import alokhin.service.validators.Validator;
import org.junit.Test;
import static junit.framework.Assert.*;

public class ValidationTest {
    @Test
    public void testValidation() throws Exception {
        Validator passwordValidator = new PasswordValidator();

        boolean val1 = passwordValidator.validate("asdASF23");
        assertEquals(val1, true);

        boolean val2 = passwordValidator.validate("asd3");
        assertEquals(val2, false);

        boolean val3 = passwordValidator.validate("❤asdAFSD23☀"); // Unicode characters
        assertEquals(val3, false);

        boolean val4 = passwordValidator.validate("aaaa");
        assertEquals(val4, false);

        boolean val5 = passwordValidator.validate("weAS52twyeeeqw");
        assertEquals(val5, true);

        boolean val6 = passwordValidator.validate("qweASDtw534sdyyyyerr");
        assertEquals(val6, false);

        Validator emailValidator = new EmailValidator();

        boolean val8 = emailValidator.validate("exesd@gmail.com");
        assertEquals(val8, true);

        boolean val9 = emailValidator.validate("wqwegmail.ru");
        assertEquals(val9, false);
    }
}
