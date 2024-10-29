package edu.kirkwood.shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpersTest {

    @Test
    void round() {
        assertEquals("1.23", Helpers.round(1.23456, 2));
        assertEquals("1.24", Helpers.round(1.23556, 2));
        assertEquals("3.5", Helpers.round(3.54,1));
        assertEquals("3.6", Helpers.round(3.55,1));
        assertEquals("1.5", Helpers.round(1.54,1));
        assertEquals("1.6", Helpers.round(1.55,1));
    }
}