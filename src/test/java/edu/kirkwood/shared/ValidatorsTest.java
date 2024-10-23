package edu.kirkwood.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorsTest {

    @Test
    void isANumber() {
        assertTrue(Validators.isANumber("12"));
        assertTrue(Validators.isANumber("-12"));
        assertTrue(Validators.isANumber("0"));
        assertTrue(Validators.isANumber("12.45"));
        assertFalse(Validators.isANumber("abc"));
        assertFalse(Validators.isANumber("12a3"));
        assertFalse(Validators.isANumber(""));
        assertFalse(Validators.isANumber(" "));
    }
}
