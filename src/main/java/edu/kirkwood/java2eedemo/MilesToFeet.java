package edu.kirkwood.java2eedemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static edu.kirkwood.shared.Helpers.round;
import static edu.kirkwood.shared.Validators.isANumber;

@WebServlet(name="milesToFeet", value="/miles-to-feet")
public class MilesToFeet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("miles-to-feet.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String miles = req.getParameter("miles");
        req.setAttribute("miles", miles);

        boolean errorFound = false;
        if(!isANumber(miles)) {
            req.setAttribute("milesError", "Miles is not valid");
            errorFound = true;
        }
        if(errorFound) {
            req.getRequestDispatcher("miles-to-feet.jsp").forward(req, resp);
            return;
        }

        double feet = getFeet(miles);
        req.setAttribute("feet", String.format("%s miles * 5280 = %s feet", miles, round(feet, 10)));
        req.getRequestDispatcher("miles-to-feet.jsp").forward(req, resp);
    }

    private static double getFeet(String miles) {
        double n1 = Double.parseDouble(miles);
        return n1 * 5280;
    }
}
