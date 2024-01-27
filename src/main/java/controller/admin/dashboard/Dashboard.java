package controller.admin.dashboard;

import dao.DashboadDAO;
import dao.ProductDao;
import models.Order;
import models.OrderDetail;
import models.Product;
import services.DashboardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Dashboard", value = "/Dashboard")
public class Dashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //số lượng người dùng, sản phẩm, đơn hàng, review
        int userNumber = DashboardService.getINSTANCE().countUser();
        int productNumber = DashboardService.getINSTANCE().countProduct();
        int orderNumber = DashboardService.getINSTANCE().countOrder();
        int reviewNumber =DashboardService.getINSTANCE().countReview();

        request.setAttribute("user", userNumber);
        request.setAttribute("product", productNumber);
        request.setAttribute("order", orderNumber);
        request.setAttribute("review", reviewNumber);

        //Barchart
        List<OrderDetail> top5Product=DashboardService.getINSTANCE().getTop5Product();

        List<Product> listTop5Product = new ArrayList<>();
        List<Integer> listProducId = new ArrayList<>();
        List<OrderDetail> oderDetailTop5 = new ArrayList<>();

        List<String> listtop5NameProduct = new ArrayList<>();
        List<Integer> listtop5Quantity = new ArrayList<>();

        for (OrderDetail top5OrderDetail:top5Product) {
            listProducId.add(top5OrderDetail.getId());
        }
        for (Integer productId:listProducId) {
            listTop5Product = DashboardService.getINSTANCE().getTop5ProductName(productId);
            listtop5NameProduct.add(listTop5Product.get(0).getName());
            oderDetailTop5= DashboardService.getINSTANCE().getTop5ProductQuantity(productId);
            int countQuan=0;
            for (OrderDetail o:oderDetailTop5) {
                countQuan += o.getQuantityRequired();
            }
            listtop5Quantity.add(countQuan);


        }
        System.out.println(listtop5NameProduct);
        System.out.println(listtop5Quantity);

        //AreaChart
        List<Order> listOrderByMonth;
        List<Integer> listOrderId = new ArrayList<>();
        List<Integer> listTotalQuantityByMonth = new ArrayList<>();
        List<Double> listTotalRevenueByMonth = new ArrayList<>();


        for (int i = 1; i <= 12; i++) {
            listOrderByMonth = DashboardService.getINSTANCE().getOrderByMonth(i);

            for (Order order : listOrderByMonth) {
                listOrderId.add(order.getId());
            }

            int totalQuantity = 0;
            double totalRevenue = 0.0;
            for (Integer orderId : listOrderId) {
                List<OrderDetail> listQuantityByMonth = DashboardService.getINSTANCE().getOrderByOrderId(orderId);

                for (OrderDetail orderDetail : listQuantityByMonth) {
                    totalQuantity += orderDetail.getQuantityRequired();
                    int quantity = orderDetail.getQuantityRequired();
                    double price = orderDetail.getPrice();
                    totalRevenue += quantity * price;
                    System.out.println(totalRevenue);
                }
            }

            listTotalQuantityByMonth.add(totalQuantity);
            listTotalRevenueByMonth.add(totalRevenue);
            System.out.println("Tháng " + i + ": Tổng số lượng = " + totalQuantity);

            listOrderId.clear();
        }

        System.out.println(listTotalQuantityByMonth);
        request.setAttribute("quantityOrderByMonth",listTotalQuantityByMonth);
        request.setAttribute("revenueOrderByMonth",listTotalRevenueByMonth);

        request.setAttribute("QuantityTop5", listtop5Quantity);
        request.setAttribute("nameTop5",listtop5NameProduct);

        request.setAttribute("top5",top5Product);

        request.getRequestDispatcher("dashboard.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



//        request.getRequestDispatcher("dashboard.jsp").forward(request,response);
    }

}