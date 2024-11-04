package edu.kirkwood.emeraldTrails.controller;

import edu.kirkwood.emeraldTrails.model.Trail;
import edu.kirkwood.emeraldTrails.model.TrailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value="/trails")
public class AdminTrails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Trail> trails = TrailDAO.getTrailsAdmin();
        req.setAttribute("trails", trails);
        req.getRequestDispatcher("WEB-INF/emeraldTrails/admin-trails.jsp").forward(req, resp);
    }
}