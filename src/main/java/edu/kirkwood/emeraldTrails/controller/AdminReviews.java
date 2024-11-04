package edu.kirkwood.emeraldTrails.controller;

import edu.kirkwood.emeraldTrails.model.Review;
import edu.kirkwood.emeraldTrails.model.ReviewDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value="/reviews")
public class AdminReviews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Review> reviews = ReviewDAO.getReviewsAdmin();
        req.setAttribute("reviews", reviews);
        req.getRequestDispatcher("WEB-INF/emeraldTrails/admin-reviews.jsp").forward(req, resp);
    }
}