package filter.product;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(filterName = "filterMoneyRange"
        , servletNames = {"filterProduct"})
public class FilterByMoney implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String[] moneyRanges = servletRequest.getParameterValues("moneyRange");
        System.out.println(Arrays.toString(moneyRanges));
//        if (moneyRanges != null) {
//            List<Integer> listId = CategoryService.getINSTANCE().checkIDValid(categoryId);
//            servletRequest.setAttribute("categoryId", listId);
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
