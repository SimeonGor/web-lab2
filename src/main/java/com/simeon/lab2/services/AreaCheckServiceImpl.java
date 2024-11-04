package com.simeon.lab2.services;

import com.simeon.lab2.beans.CheckResult;
import com.simeon.lab2.beans.History;
import com.simeon.lab2.dto.AreaCheckRequest;
import jakarta.enterprise.inject.Model;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;

@Model
public class AreaCheckServiceImpl implements AreaCheckService {
    @Override
    public void handle(AreaCheckRequest request, HttpSession session) {
        long start = System.currentTimeMillis();

        boolean hit = CheckUtil.check(request.x(), request.y(), request.r());

        long end = System.currentTimeMillis();
        long workingTime = end - start;

        CheckResult result = new CheckResult(request.x(), request.y(), request.r(), hit, workingTime, LocalDateTime.now());

        saveToHistory(result, session);
    }

    private void saveToHistory(CheckResult result, HttpSession session) {
        History history = (History) session.getAttribute("history");
        if (history == null) {
            history = new History();
        }
        else {
            history.addResult(result);
        }
        session.setAttribute("history", history);
    }
}
