package controller.admin.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import models.*;
import org.json.JSONObject;
import services.AdminOrderServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "SeeDetailOrderAdmin", value = "/SeeDetailOrderAdmin")
public class SeeDetailOrderAdmin extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        String orderId = (String) request.getAttribute("orderId");
        List<OrderDetail> listOrderDetailByOrderId = AdminOrderServices.getINSTANCE().getListOrderDetailByOrderId(orderId);
        Order orderTarget = AdminOrderServices.getINSTANCE().getOrderById(orderId);

        DeliveryMethod deliveryMethod = AdminOrderServices.getINSTANCE().getDeliveryMethodManageById(orderTarget.getDeliveryMethodId());
        PaymentMethod paymentMethod = AdminOrderServices.getINSTANCE().getPaymentMethodMangeById(orderTarget.getPaymentMethodId());
        OrderStatus orderStatus = AdminOrderServices.getINSTANCE().getOrderStatusById(orderTarget.getOrderStatusId());
        TransactionStatus transactionStatus = AdminOrderServices.getINSTANCE().getTransactionStatusById(orderTarget.getTransactionStatusId());

        Voucher voucher;
        try {
            voucher = AdminOrderServices.getINSTANCE().getVoucherById(orderTarget.getVoucherId());
        }catch (Exception exception){
            voucher = new Voucher();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(new StdDateFormat().withTimeZone(simpleDateFormat.getTimeZone()));

        String orderJSON = objectMapper.writeValueAsString(orderTarget);
        String deliveryMethodJSON = objectMapper.writeValueAsString(deliveryMethod);
        String paymentMethodJSON = objectMapper.writeValueAsString(paymentMethod);
        String orderStatusJSON = objectMapper.writeValueAsString(orderStatus);
        String transactionStatusJSON = objectMapper.writeValueAsString(transactionStatus);
        String voucherJSON = objectMapper.writeValueAsString(voucher);

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("listOrderDetailByOrderId", listOrderDetailByOrderId);
        jsonObject.put("orderTarget", orderJSON);
        jsonObject.put("deliveryMethodTarget", deliveryMethodJSON);
        jsonObject.put("paymentMethodTarget", paymentMethodJSON);
        jsonObject.put("orderStatusTarget", orderStatusJSON);
        jsonObject.put("transactionStatusTarget", transactionStatusJSON);
        jsonObject.put("voucherTarget", voucherJSON);
        response.getWriter().print(jsonObject);
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