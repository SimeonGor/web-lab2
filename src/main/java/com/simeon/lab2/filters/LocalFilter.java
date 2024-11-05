package com.simeon.lab2.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class LocalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        List<String> path = List.of(request.getRequestURI().split("/"));

        if (path.contains("local")) {
            String url = request.getContextPath() + "/index.jsp";
            String encoded = response.encodeRedirectURL(url);
            response.sendRedirect(encoded);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
