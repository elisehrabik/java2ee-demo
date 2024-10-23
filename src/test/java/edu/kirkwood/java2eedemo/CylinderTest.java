package edu.kirkwood.java2eedemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    private Cylinder cylinder;

    @BeforeEach
    void setUp() {
        cylinder = new Cylinder(1, 1);
    }

    @Test
    void getHeight() {
        assertEquals(1, cylinder.getHeight());
        cylinder.setHeight(5.2);
        assertEquals(5.2, cylinder.getHeight());
    }

    @Test
    void setHeight() {
        cylinder.setHeight(3);
        assertEquals(3, cylinder.getHeight());

        assertThrows(IllegalArgumentException.class, () -> {
            cylinder.setHeight(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            cylinder.setHeight(-5.2);
        });
    }

    @Test
    void getVolume() {
        cylinder.setHeight(2.2);

        double expectedVolume = Math.PI * 1 * 1 * 2.2;
        assertEquals(expectedVolume, cylinder.getVolume(), 0.0001);

        cylinder.setHeight(5.555);
        expectedVolume = Math.PI * 1 * 1 * 5.555;
        assertEquals(expectedVolume, cylinder.getVolume(), 0.0001);

        cylinder.setHeight(1);
        expectedVolume = Math.PI * 1 * 1 * 1;
        assertEquals(expectedVolume, cylinder.getVolume(), 0.0001);
    }

    @Test
    void testToString() {
        cylinder.setHeight(2);
        String expectedString = String.format("%.2f * π * %.2f = %.1f", 2.0, 1.0, Math.PI * 1 * 1 * 2); // π * r² * h
        assertEquals(expectedString, cylinder.toString());
    }
}
