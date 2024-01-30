package com.hvl.ss9_servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet",value = "/DiscountServlet")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("description");
        int price = Integer.parseInt(req.getParameter("price"));
        int discount = Integer.parseInt(req.getParameter("discount"));
        double discountAmount = price * discount * 0.01;
        double discountPrice = price - discountAmount;

        req.setAttribute("discountAmount",discountAmount);
        req.setAttribute("discountPrice",discountPrice);
        req.setAttribute("description",name);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
