package filter;

import services.ContactServices;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebFilter("/contact.jsp")
public class ContactFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding("UTF-8");
        List<Map<String, Object>> listContactSubjects = ContactServices.getINSTANCE().getListContactSubjects();
        request.setAttribute("list_contact_subjects", listContactSubjects);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
