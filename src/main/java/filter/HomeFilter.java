package filter;

import models.Sliders;
import services.HomeServices;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebFilter("/index.jsp")
public class HomeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        List<Map<String, Object>> listTrendingProducts = HomeServices.getINSTANCE().getListTrendingProducts(false);
        List<Map<String, Object>> listNewProducts = HomeServices.getINSTANCE().getListNewProducts(false);
        List<Sliders> listSlideShow = HomeServices.getINSTANCE().getListSlideShow();

        request.setAttribute("list_slide_show", listSlideShow);
        request.setAttribute("list_trending_products", listTrendingProducts);
        request.setAttribute("list_new_products", listNewProducts);

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
