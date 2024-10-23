package edu.kirkwood.shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpersTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void round() {
        assertEquals("12.35", Helpers.round(12.34567, 2));
        assertEquals("12.3", Helpers.round(12.34567, 1));
        assertEquals("12", Helpers.round(12.34567, 0));
        assertEquals("-12", Helpers.round(-12.34567, 0));
        assertEquals("0", Helpers.round(0, 0));
    }
}
