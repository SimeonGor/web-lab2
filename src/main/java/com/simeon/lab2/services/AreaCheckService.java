package com.simeon.lab2.services;

import com.simeon.lab2.dto.AreaCheckRequest;
import jakarta.servlet.http.HttpSession;

public interface AreaCheckService {
    void handle(AreaCheckRequest request, HttpSession session);
}
