package controller.shoppingCart;

import models.Vouchers;
import com.google.gson.JsonObject;
import services.ShoppingCartServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ApplyVoucherController", value = "/ApplyVoucher")
public class ApplyVoucherController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<String> listCodeOfVouchers = ShoppingCartServices.getINSTANCE().getListCodeOfVouchers();
        String code = (String) request.getAttribute("code");
        double temporaryPrice = (double) request.getAttribute("temporaryPrice");
        if(listCodeOfVouchers.contains(code)){
            Vouchers voucher = ShoppingCartServices.getINSTANCE().getDiscountPercentByCode(temporaryPrice, code);
            if(voucher != null){
                double discountPercent = voucher.getDiscountPercent();
                double newTotalPrice = temporaryPrice * (1 - discountPercent);
                String successApplied = "Bạn đá áp dụng mã " + code + " thành công";
                request.setAttribute("newTotalPrice", newTotalPrice);
                request.setAttribute("successApplied", successApplied);
            }else {
                double minPriceToApply = voucher.getMinimumPrice();
                request.setAttribute("failedApply", "Bạn chưa đủ điều kiện để áp dụng mã " + code + ". Hãy mua thêm " + (minPriceToApply - temporaryPrice));
            }
        }else{
            request.setAttribute("failedApply", "Mã " + code + " mà bạn nhập không tồn tại");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shoppingCart.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void sendErrorResponse(HttpServletResponse response, String errorMessage) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("errorMessage", errorMessage);

        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();
    }

    private void sendSuccessResponse(HttpServletResponse response, double newTotal, String successMessage) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("newTotal", newTotal);
        jsonResponse.addProperty("successMessage", successMessage);

        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();
    }
}