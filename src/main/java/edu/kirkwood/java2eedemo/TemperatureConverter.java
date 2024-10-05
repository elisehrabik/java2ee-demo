package edu.kirkwood.java2eedemo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import static edu.kirkwood.shared.Helpers.round;
import static edu.kirkwood.shared.Validators.isANumber;

@WebServlet(name = "TemperatureConverter", value = "/temp-converter")
public class TemperatureConverter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/temp-converter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fahrenheit = req.getParameter("fahrenheit");
        req.setAttribute("fahrenheit", fahrenheit);

        // Set errorFound default to false
        boolean errorFound = false;

        // Trim off extra whitespace
        if (fahrenheit != null) {
            fahrenheit = fahrenheit.trim();
        }

        // Check if the input is a number
        if (!isANumber(fahrenheit)) {
            req.setAttribute("fahrenheitError", "Invalid temperature. Please enter a valid number.");
            errorFound = true;
        } else {
            // Parse the string into a double
            double fahrenheitValue = Double.parseDouble(fahrenheit);
            // Check if the temperature is below -459.67
            if (fahrenheitValue < -459.67) {
                // Print range error
                req.setAttribute("fahrenheitError", "Temperature must be -459.67°F or higher.");
                errorFound = true;
            } else {
                // Calculate and print Celsius result
                double celsius = getCelsius(fahrenheitValue);
                req.setAttribute("result", String.format("(%.1f°F - 32) × 5/9 = %.1f°C", fahrenheitValue, celsius));
            }
        }

        // Send error to jsp
        if (errorFound) {
            req.getRequestDispatcher("/temp-converter.jsp").forward(req, resp);
            return;
        }
        // Send result to jsp
        req.getRequestDispatcher("/temp-converter.jsp").forward(req, resp);
    }

    // Convert Fahrenheit to Celsius
    private static double getCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
