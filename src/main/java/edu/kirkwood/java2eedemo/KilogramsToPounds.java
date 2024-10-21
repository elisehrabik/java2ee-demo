package edu.kirkwood.java2eedemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static edu.kirkwood.shared.Helpers.round;
import static edu.kirkwood.shared.Validators.isANumber;

@WebServlet(name="kilogramsToPounds", value="/kg-to-lb")
public class KilogramsToPounds extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("kg-to-lb.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String kilograms = req.getParameter("kilograms");
        req.setAttribute("kilograms", kilograms);

        boolean errorFound = false;
        if(!isANumber(kilograms) || Double.parseDouble(kilograms) < 0) {
            req.setAttribute("kilogramsError", "Kilograms is not valid");
            errorFound = true;
        }

        if(errorFound) {
            req.getRequestDispatcher("kg-to-lb.jsp").forward(req, resp);
            return;
        }

        double pounds = getPounds(kilograms);
        req.setAttribute("pounds", String.format("%s kilograms * 2.2046 = %s pounds", kilograms, round(pounds, 10)));
        req.getRequestDispatcher("kg-to-lb.jsp").forward(req, resp);
    }

    private static double getPounds(String kilograms) {
        double n1 = Double.parseDouble(kilograms);
        return n1 * 2.2046;
    }
}
