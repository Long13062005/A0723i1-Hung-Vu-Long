package com.codegym.demo_product.controller;

import com.codegym.demo_product.dto.ProductDto;
import com.codegym.demo_product.model.Product;
import com.codegym.demo_product.model.ProductType;
import com.codegym.demo_product.service.IProductService;
import com.codegym.demo_product.service.IProductTypeService;
import com.codegym.demo_product.service.ProductService;
import com.codegym.demo_product.service.ProductTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    private IProductService productService = new ProductService();
    private IProductTypeService productTypeService = new ProductTypeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormAdd(req, resp);
                break;
            case "search":
                search(req,resp);
                break;
            default:
                showList(req, resp);
        }

    }

    private void search(HttpServletRequest req, HttpServletResponse resp) {
        String searchName = req.getParameter("searchName");
        String searchTypeName = req.getParameter("searchTypeName");
        List<ProductType> productTypeList = productTypeService.findAll();
        req.setAttribute("productTypeList", productTypeList);
        // danh sách sản phẩm
        List<ProductDto> productDtoList = productService.search(searchName,searchTypeName);
        // chuyển name qua để giữ lại
        req.setAttribute("searchName",searchName);
        try {
            req.setAttribute("productList", productDtoList);
            req.getRequestDispatcher("/views/list.jsp").forward(req, resp);

        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) {
        List<ProductType> productTypeList = productTypeService.findAll();
        req.setAttribute("productTypeList", productTypeList);
        try {
            req.getRequestDispatcher("/views/add.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        // chuyển qua làm chức năng search
        List<ProductType> productTypeList = productTypeService.findAll();
        req.setAttribute("productTypeList", productTypeList);
        // danh sách sản phẩm
        List<ProductDto> productDtoList = productService.findAll();
        try {
            req.setAttribute("productList", productDtoList);
            req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                save(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            default:

        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        boolean check = productService.delete(deleteId);
        String mess = "khong thanh cong";
        if (check) {
            mess = "Thanh cong";
        }
        try {
            resp.sendRedirect("/product?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String unit = req.getParameter("unit");
        float price = Float.parseFloat(req.getParameter("price"));
        int typeId = Integer.parseInt(req.getParameter("typeId"));
        Product product = new Product(code, name, unit, price, typeId);
        productService.add(product);
        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
