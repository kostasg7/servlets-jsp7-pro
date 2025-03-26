package gr.aueb.cf.helloapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("inspect-request")
public class InspectRequestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().write("Session id: " + request.getSession());

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie :cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    response.getWriter().write("Cookie name: " + cookie.getName() + ", Cookie Value:" + cookie.getValue());
                }
            }
        }

        response.getWriter().write("Request URI: " + request.getRequestURI() + "\n");
        response.getWriter().write("Request Context Path: " + request.getContextPath() + "\n");
        response.getWriter().write("Request Servlet Path: " + request.getServletPath() + "\n");
    }
}
