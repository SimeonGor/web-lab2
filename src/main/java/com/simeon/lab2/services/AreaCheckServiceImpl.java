package com.simeon.lab2.services;

import com.simeon.lab2.beans.CheckResult;
import com.simeon.lab2.beans.History;
import com.simeon.lab2.dto.AreaCheckRequest;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

import java.time.LocalDateTime;

@Model
public class AreaCheckServiceImpl implements AreaCheckService {
    private History history;

    @Inject
    public void setHistory(@Any History history) {
        this.history = history;
    }

    @Override
    public void handle(AreaCheckRequest request) {
        long start = System.currentTimeMillis();

        boolean hit = CheckUtil.check(request.x(), request.y(), request.r());

        long end = System.currentTimeMillis();
        long workingTime = end - start;

        CheckResult result = new CheckResult(request.x(), request.y(), request.r(), hit, workingTime, LocalDateTime.now());

        history.addResult(result);
    }
}
