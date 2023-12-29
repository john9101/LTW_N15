package controller.shoppingCart;

import models.ShoppingCart;
import models.User;
import models.Voucher;
import services.ShoppingCartServices;
import utils.FormatCurrency;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "ApplyVoucherController", value = "/ApplyVoucher")
public class ApplyVoucherController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<String> listCodeOfVouchers = ShoppingCartServices.getINSTANCE().getListCodeOfVouchers();
        String code = (String) request.getAttribute("code");
        double temporaryPrice = (double) request.getAttribute("temporaryPrice");

        HttpSession session = request.getSession(true);
        User userAuth = (User) session.getAttribute("auth");
        String userIdCart = String.valueOf(userAuth.getId());
        ShoppingCart cart = (ShoppingCart) session.getAttribute(userIdCart);
        if(listCodeOfVouchers.contains(code)){
            Voucher voucher = ShoppingCartServices.getINSTANCE().getValidVoucherApply(code);
            double minPriceToApply = ShoppingCartServices.getINSTANCE().getMinPriceApplyVoucherByCode(code);
            if(cart.getTemporaryPrice() >= voucher.getMinimumPrice()){
                cart.setVoucherApplied(voucher);
                session.setAttribute(userIdCart, cart);
                session.removeAttribute("failedApply");
                session.setAttribute("successApplied", "Bạn đã áp dụng mã " + code + " thành công");
            }else {
                double priceBuyMore = minPriceToApply - temporaryPrice;
                String priceBuyMoreFormat = FormatCurrency.vietNamCurrency(priceBuyMore);
                cart.setVoucherApplied(null);
                session.setAttribute(userIdCart, cart);
                session.removeAttribute("successApplied");
                session.setAttribute("failedApply", "Bạn chưa đủ điều kiện để áp dụng mã " + code + ". Hãy mua thêm " + priceBuyMoreFormat);
            }
        }else{
            cart.setVoucherApplied(null);
            session.setAttribute(userIdCart, cart);
            session.removeAttribute("successApplied");
            session.setAttribute("failedApply", "Mã " + code + " mà bạn nhập không tồn tại");
        }
        session.setAttribute("code", code);
        response.sendRedirect("shoppingCart.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}