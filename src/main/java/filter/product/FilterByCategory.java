package filter.product;

import services.CategoryService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "filterCategoryId"
        , servletNames = {"filterProduct"})
public class FilterByCategory implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String[] categoryId = servletRequest.getParameterValues("categoryId");
        if (categoryId != null) {
            List<Integer> listId = CategoryService.getINSTANCE().checkIDValid(categoryId);
            servletRequest.setAttribute("categoryId", listId);
        }
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
