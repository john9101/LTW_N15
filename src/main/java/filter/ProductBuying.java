package filter;

import models.Category;
import models.ProductCart;
import services.ProductCartServices;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

@WebFilter("/productBuying.jsp")
public class ProductBuying implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        List<ProductCart> productCartList = ProductCartServices.getINSTANCE().getAllProductCart();
        request.setAttribute("productCartList", productCartList);
        List<Category> categoryList = ProductCartServices.getINSTANCE().getAllCategory();
        request.setAttribute("categoryList", categoryList);
        chain.doFilter(request, response);
    }
}
 
