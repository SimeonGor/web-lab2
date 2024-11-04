package com.simeon.lab2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ControllerServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        if (request.getParameter("x") != null
            && request.getParameter("y") != null
            && request.getParameter("r") != null) {
                RequestDispatcher controller = servletContext.getRequestDispatcher("/local/check");
                controller.forward(request, response);
        }
        else {
            String path = request.getContextPath() + "/index.jsp";
            String encoded = response.encodeRedirectURL(path);
            response.sendRedirect(encoded);
        }
    }
}
