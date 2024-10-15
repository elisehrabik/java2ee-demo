package edu.kirkwood.java2eedemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/volume")
public class VolumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get parameters from the form
        String radiusStr = request.getParameter("radius");
        String heightStr = request.getParameter("height");

        try {
            // Validate if parameters are null or empty
            if (radiusStr == null || radiusStr.trim().isEmpty() || heightStr == null || heightStr.trim().isEmpty()) {
                throw new IllegalArgumentException("Both radius and height must be provided.");
            }

            // Parse the inputs
            double radius = Double.parseDouble(radiusStr.trim());
            double height = Double.parseDouble(heightStr.trim());

            // Create a Cylinder object
            Cylinder cylinder = new Cylinder(radius, height);

            // Set the result attribute to display the volume
            request.setAttribute("result", cylinder.toString());

        } catch (NumberFormatException e) {
            // Set error message for invalid number format
            request.setAttribute("error", "Please enter valid numbers for radius and height.");
        } catch (IllegalArgumentException e) {
            // Set error message for missing or invalid input
            request.setAttribute("error", e.getMessage());
        }

        // Forward the request back to volume.jsp for output display
        request.getRequestDispatcher("volume.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the form in volume.jsp
        request.getRequestDispatcher("volume.jsp").forward(request, response);
    }
}

