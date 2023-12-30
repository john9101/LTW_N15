package controller.admin.product;

import controller.product.FilterProduct;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "filterProductAdmin", value = "/filterProductAdmin")
public class FilterProductAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FilterProduct filterProduct = new FilterProduct("filterProductAdmin");
//Lọc theo tên sản phẩm

//Lọc theo thời gian cập nhập

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}