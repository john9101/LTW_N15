package filter;

import models.ProductCart;
import services.ProductCartServices;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

@WebFilter("/productBuying.jsp")
public class ShowProductCarts implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        List<ProductCart> productCartList = ProductCartServices.getINSTANCE().getAllProductCart();
        request.setAttribute("list", productCartList);
        chain.doFilter(request, response);
    }
}
 
