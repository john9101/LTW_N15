package filter.product;

import models.Product;
import services.ProductCardServices;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "ProductBuying", urlPatterns = {"/filterProductBuying", "/productBuying.jsp"})
public class ProductBuying implements Filter {
    private final int LIMIT = 9;
    private final int DEFAULT_PAGE = 1;

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        List<Product> productCardList = ProductCardServices.getINSTANCE().getProducts(DEFAULT_PAGE, LIMIT);
        request.setAttribute("productCardList", productCardList);
        int quantityPage = ProductCardServices.getINSTANCE().getQuantityPage(LIMIT);
        request.setAttribute("quantityPage", quantityPage);
        String requestURL = "/filterProductBuying?";
        request.setAttribute("requestURL", requestURL);
        chain.doFilter(request, response);
    }
}
 
