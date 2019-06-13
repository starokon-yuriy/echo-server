package com.epam.rd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EchoServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            Object headerName = headerNames.nextElement();
            String headerValue = request.getHeader((String) headerName);
            out.println(String.format("<h1>%s:%s</h1>", headerName, headerValue));
        }

    }

    public void destroy() {
        // do nothing.
    }
}