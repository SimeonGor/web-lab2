package com.simeon.lab2.controller;

import com.simeon.lab2.dto.AreaCheckRequest;
import com.simeon.lab2.services.AreaCheckService;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

public class AreaCheckServlet extends HttpServlet {
    private final AreaCheckService areaCheckService;

    @Inject
    public AreaCheckServlet(@Any AreaCheckService areaCheckService) {
        this.areaCheckService = areaCheckService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        AreaCheckRequest areaCheckRequest = parseRequest(request);

        areaCheckService.handle(areaCheckRequest);

        redirectToView(request, response);
    }

    private AreaCheckRequest parseRequest(HttpServletRequest request) {
        return new AreaCheckRequest(
                new BigDecimal(request.getParameter("x")),
                new BigDecimal(request.getParameter("y")),
                new BigDecimal(request.getParameter("r"))
        );
    }

    private void redirectToView(HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/check.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
