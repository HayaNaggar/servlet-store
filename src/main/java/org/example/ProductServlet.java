package org.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.List.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Product List</h1>");
        // later: fetch products from DB
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        resp.sendRedirect("products");
    }



}
