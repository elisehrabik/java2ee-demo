package edu.kirkwood.emeraldTrails.controller;

import edu.kirkwood.emeraldTrails.model.Visitor;
import edu.kirkwood.emeraldTrails.model.VisitorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value="/visitors")
public class AdminVisitors extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Visitor> visitors = VisitorDAO.getVisitorsAdmin();
        req.setAttribute("visitors", visitors);
        req.getRequestDispatcher("WEB-INF/emeraldTrails/admin-visitors.jsp").forward(req, resp);
    }
}