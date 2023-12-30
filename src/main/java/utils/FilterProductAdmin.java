package utils;

import javax.servlet.http.HttpServletRequest;

public class FilterProductAdmin extends FilterProduct{
    public FilterProductAdmin(HttpServletRequest request) {
        super(request);
    }

    @Override
    public void doFilter() {

    }
}
