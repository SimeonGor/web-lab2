package com.simeon.lab2;

import com.simeon.lab2.dto.AreaCheckRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

public class ControllerServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        if (request.getParameter("x") != null
            && request.getParameter("y") != null
            && request.getParameter("r") != null) {
            AreaCheckRequest requestData = parseRequest(request);
            request.setAttribute("areaCheckRequest", requestData);
            RequestDispatcher controller = servletContext.getRequestDispatcher("/local/check");
            controller.forward(request, response);
        }
        else {
            String path = request.getContextPath() + "/index.jsp";
            String encoded = response.encodeRedirectURL(path);
            response.sendRedirect(encoded);
        }
    }

    private AreaCheckRequest parseRequest(HttpServletRequest request) {
        return new AreaCheckRequest(
                new BigDecimal(request.getParameter("x")),
                new BigDecimal(request.getParameter("y")),
                new BigDecimal(request.getParameter("r"))
        );
    }
}
