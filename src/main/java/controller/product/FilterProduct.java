package controller.product;

import utils.FilterProductBuying;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

@WebServlet(name = "filterProduct", value = "/filterProduct")
public class FilterProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        utils.FilterProduct filterProduct = new FilterProductBuying(request);
        filterProduct.doFilter();
        request.getRequestDispatcher("productBuying.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }

    private List<Integer> findCommonIDs(List<List<Integer>> lists) {
        if (lists.isEmpty()) return new ArrayList<>();
        if (lists.size() == 1) return lists.get(0);
        List<Integer> result = new ArrayList<>();
        result = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            result.retainAll(lists.get(i));
        }
        return result;
    }

    private String cutParameterInURL(String queryString, String key) {
        if (queryString != null) {
            String[] params = queryString.split("&");
            StringBuilder updatedQueryString = new StringBuilder();
            for (String param : params) {
                String[] keyValue = param.split("=");
                if (keyValue.length == 2 && key.equals(keyValue[0])) {
                    continue;
                } else {
                    updatedQueryString.append(param).append("&");
                }
            }
            return updatedQueryString.toString();
        }
        return null;
    }

    public List<String> listValueChecked(String queryString) {
        List<String> result = new ArrayList<>();
        if (queryString != null) {
            String[] params = queryString.split("&");
            for (String param : params) {
                String[] keyValue = param.split("=");
                try {
                    result.add(URLDecoder.decode(keyValue[1], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }
}