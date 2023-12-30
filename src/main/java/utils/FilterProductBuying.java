package utils;

import models.Product;
import services.ProductCardServices;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class FilterProductBuying extends FilterProduct {
    public FilterProductBuying(HttpServletRequest request) {
        super(request);
    }

    @Override
    public void doFilter() {
        List<Integer> filterByColor = filterByColor();
        List<Integer> filterByCategoryId = filterByCategory();
        List<Integer> filterByMoneyRange = filterMyMoney();
        List<Integer> filterBySize = filterBySize();
        String pageNumber = request.getParameter("page");
        int page;
        try {
            page = Integer.parseInt(pageNumber);
        } catch (NumberFormatException e) {
            page = 1;
        }
        List<List<Integer>> listId = new ArrayList<>();
        if (filterByColor != null) {
            listId.add(filterByColor);
        }
        if (filterByCategoryId != null) {
            listId.add(filterByCategoryId);
        }
        if (filterByMoneyRange != null) {
            listId.add(filterByMoneyRange);
        }
        if (filterBySize != null) {
            listId.add(filterBySize);
        }
        List<Integer> listIDFiltered = findCommonIDs(listId);
        System.out.println(listIDFiltered);
        List<Product> productCardFiltered = ProductCardServices.getINSTANCE().filter(listIDFiltered, page);
        int quantityPage;
        if (!listIDFiltered.isEmpty()) {
            quantityPage = ProductCardServices.getINSTANCE().getQuantityPage(listIDFiltered.size());
        } else {
            quantityPage = ProductCardServices.getINSTANCE().getQuantityPage();
        }

        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();
        queryString = cutParameterInURL(queryString, "page");
        requestURL.append("?").append(queryString);

        List<String> listInputChecked = listValueChecked(queryString);
        System.out.println("listInputChecked (BE): " + listInputChecked);
        request.setAttribute("requestURL", requestURL);
        request.setAttribute("productCardList", productCardFiltered);
        request.setAttribute("quantityPage", quantityPage);
        request.setAttribute("currentPage", page);
        request.setAttribute("listInputChecked", listInputChecked);
    }
}
