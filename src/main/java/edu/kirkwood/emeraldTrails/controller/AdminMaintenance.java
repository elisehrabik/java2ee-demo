package edu.kirkwood.emeraldTrails.controller;

import edu.kirkwood.emeraldTrails.model.Maintenance;
import edu.kirkwood.emeraldTrails.model.MaintenanceDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value="/maintenance")
public class AdminMaintenance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Maintenance> maintenances = MaintenanceDAO.getMaintenanceAdmin();
        req.setAttribute("maintenances", maintenances);
        req.getRequestDispatcher("WEB-INF/emeraldTrails/admin-maintenance.jsp").forward(req, resp);
    }
}