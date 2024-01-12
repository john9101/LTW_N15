package filter.authorization;

import models.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "admin", urlPatterns = {
        "/adminProductForm.jsp",
        "/adminProducts.jsp",
        "/adminUsers.jsp",
        "/adminOrders.jsp",
})
public class AdminRole implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("auth");

        if (user == null)
            httpServletResponse.sendRedirect("signIn.jsp");
        else

            chain.doFilter(request, response);
    }
}
 
