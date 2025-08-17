package org.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private List<Product> products = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // Sample products
        products.add(new Product(1, "Laptop", 15000.0));
        products.add(new Product(2, "Phone", 8000.0));
        products.add(new Product(3, "Headphones", 1200.0));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("products.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = products.size() + 1; // auto increment
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));

        products.add(new Product(id, name, price));
        resp.sendRedirect("products");
    }
}
