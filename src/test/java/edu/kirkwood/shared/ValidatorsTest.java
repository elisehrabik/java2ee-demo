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

    @Test
    void isValidEmail() {
        assertTrue(Validators.isValidEmail("elise.hrabik@gmail.com"));
        assertTrue(Validators.isValidEmail("elise-2@student.edu"));
        assertTrue(Validators.isValidEmail("elise_@hotmail.com"));
        assertTrue(Validators.isValidEmail("elise@yahoo.org"));
        assertFalse(Validators.isValidEmail("elise.hrabik.com"));
        assertFalse(Validators.isValidEmail("elise.hrabik.edu"));
        assertFalse(Validators.isValidEmail("elise hrabik@gmail.com"));
        assertFalse(Validators.isValidEmail("e"));
        assertFalse(Validators.isValidEmail("e@h"));
        assertFalse(Validators.isValidEmail(""));
    }

    @Test
    void isValidImage(){
        assertTrue(Validators.isValidImage("image.png"));
        assertTrue(Validators.isValidImage("images/image.png"));
        assertTrue(Validators.isValidImage("./folder/subfolder/image.gif"));
        assertFalse(Validators.isValidImage("image.txt"));
        assertFalse(Validators.isValidImage("images/image"));
        assertFalse(Validators.isValidImage("C://Windows\\\\image.svg"));
    }
}
