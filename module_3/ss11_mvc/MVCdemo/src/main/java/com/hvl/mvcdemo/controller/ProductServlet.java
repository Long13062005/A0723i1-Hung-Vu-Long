package com.hvl.mvcdemo.controller;

import com.hvl.mvcdemo.models.model.Product;
import com.hvl.mvcdemo.models.service.IProductService;
import com.hvl.mvcdemo.models.service.imp.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(value = "/Product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "add":
                save(req,resp);
                // thêm mới
                break;
            case "delete":
                delete(req, resp);
                // xoá
                break;
            case "update":
                update(req, resp);
                break;
            default:


        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "add":
                showAddForm(req,resp);
                // thêm mới
                break;
            case "delete":
                showFormDelete(req,resp);
                // xoá
                break;
            case "update":
                showFormUpdate(req,resp);
                break;
            default:
                // hiểj thị danh sách
                showList(req,resp);

        }
    }
    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/add.jsp");
        requestDispatcher.forward(req, resp);
    }
    private void save(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        Product product = new Product(name,price,quantity);
        boolean isSuccess =productService.add(product);
        String mess = "Them moi khong thanh cong";
        if (!isSuccess){
            mess = "Them moi thanh cong";
        }
        try {
            resp.sendRedirect("/Product?mess="+mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/home.jsp");
        req.setAttribute("productList", productService.findAll());
        req.setAttribute("myDate", new Date());
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/views/delete.jsp");
        requestDispatcher.forward(request,response);
    }
    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("name");
        Product product= productService.findProduct(name);
        request.setAttribute("product",product);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/views/update.jsp");
        requestDispatcher.forward(request,response);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name =request.getParameter("name");
        String message1="Found";
        String message2="Not Found";

        if(productService.delete(name)){
            request.setAttribute("message",message1);
        } else{
            request.setAttribute("message",message2);
        }
        request.setAttribute("productList",productService.findAll());
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/views/home.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name=request.getParameter("name");
        int quantity=Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        Product product=productService.findProduct(name);
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        productService.update(name,product);
        request.setAttribute("message","Product information was updated");
        request.setAttribute("productList",productService.findAll());
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/views/home.jsp");
        requestDispatcher.forward(request,response);


    }
}
