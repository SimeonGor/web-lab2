package com.simeon.lab2.controller;

import com.simeon.lab2.beans.CheckResult;
import com.simeon.lab2.beans.History;
import com.simeon.lab2.dto.AreaCheckRequest;
import com.simeon.lab2.services.CheckAreaService;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;

public class AreaCheckServlet extends HttpServlet {
    @Inject
    @Model
    private CheckAreaService checkAreaService;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long start = System.currentTimeMillis();

        AreaCheckRequest areaCheckRequest = (AreaCheckRequest) request.getAttribute("areaCheckRequest");

        boolean hit = checkAreaService.check(areaCheckRequest.x(), areaCheckRequest.y(), areaCheckRequest.r());

        long end = System.currentTimeMillis();
        long workingTime = end - start;

        CheckResult checkResult = new CheckResult(areaCheckRequest.x(), areaCheckRequest.y(), areaCheckRequest.r(), hit, workingTime, LocalDateTime.now());

        saveToHistory(request, checkResult);

        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/check.jsp");
        dispatcher.forward(request, response);
    }

    private void saveToHistory(HttpServletRequest request, CheckResult checkResult) {
        HttpSession session = request.getSession();
        History history = (History) session.getAttribute("history");
        if (history == null) {
            history = new History();
            session.setAttribute("history", history);
        }
        history.addResult(checkResult);
    }

}
