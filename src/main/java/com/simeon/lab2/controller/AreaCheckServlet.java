package com.simeon.lab2.controller;

import com.simeon.lab2.beans.CheckResult;
import com.simeon.lab2.beans.History;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AreaCheckServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        History history = (History) session.getAttribute("history");
        if (history == null) {
            history = new History();
            session.setAttribute("history", history);
        }
        history.addResult(new CheckResult(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, false, 0, LocalDateTime.now()));

        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/check.jsp");
        dispatcher.forward(request, response);
    }

}
