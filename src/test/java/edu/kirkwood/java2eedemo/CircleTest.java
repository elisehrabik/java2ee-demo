package edu.kirkwood.java2eedemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

    private Circle circle;

    @BeforeEach
    public void setUp() {
        circle = new Circle();
    }

    @Test
    public void GetRadius() {
        assertEquals(0, circle.getRadius());
        circle.setRadius(5.2);
        assertEquals(5.2, circle.getRadius());
    }

    @Test
    public void SetRadius() {
        circle.setRadius(3);
        assertEquals(3, circle.getRadius());

        assertThrows(IllegalArgumentException.class, () -> {
            circle.setRadius(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            circle.setRadius(-5.2);
        });
    }

    @Test
    public void GetArea() {
        circle.setRadius(2.2);
        double expectedArea = Math.PI * 2.2 * 2.2;
        assertEquals(expectedArea, circle.getArea());

        circle.setRadius(5.555);
        expectedArea = Math.PI * 5.555 * 5.555;
        assertEquals(expectedArea, circle.getArea());

        circle.setRadius(1);
        expectedArea = Math.PI * 1 * 1;
        assertEquals(expectedArea, circle.getArea());
    }
}
