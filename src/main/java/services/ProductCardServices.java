package services;

import dao.*;
import models.*;
import utils.MoneyRange;

import java.util.*;

public class ProductCardServices {
    private static ProductCardServices INSTANCE;
    private static final int LIMIT = 9;

    private ProductCardServices() {
    }

    public static ProductCardServices getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new ProductCardServices();
        return INSTANCE;
    }

    private int calculateStar(ProductCard productCard) {
        ReviewDAO reviewDAO = new ReviewDAO();
        List<Review> list = reviewDAO.getReviewStar(productCard.getId());
        productCard.setReviews(list.size());
        if (list.isEmpty()) return 0;
        int totalStar = 0;
        for (Review item : list) {
            totalStar += item.getRatingStar();
        }
        return totalStar / list.size();
    }

    public List<ProductCard> getAllProductCart() {
        ProductCardDAO productCardDAO = new ProductCardDAO();
        List<ProductCard> productCardList = productCardDAO.getCartAllProduct();
        return productCardList;
    }

    public List<Category> getAllCategory() {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> listCategories = categoryDAO.getAllCategory();
        return listCategories;
    }

    public List<Color> getAllColor() {
        ColorDAO colorDAO = new ColorDAO();
        List<Color> listColor = colorDAO.getAllColor();
        return listColor;
    }

    public List<Size> getAllSize() {
        SizeDAO sizeDAO = new SizeDAO();
        List<Size> listSize = sizeDAO.getAllSize();
        return listSize;
    }

    public List<ProductCard> getProducts(int numberPage){
        ProductCardDAO productCardDAO = new ProductCardDAO();
        List<ProductCard> productCardList = productCardDAO.getProducts(LIMIT, numberPage);
        return productCardList;
    }

    public int getQuantityPage() {
        ProductCardDAO productCardDAO = new ProductCardDAO();
        double quantityPage = Math.ceil(Double.parseDouble(productCardDAO.getQuantityProduct() + "") / LIMIT);
        return (int) quantityPage;
    }

    public int getQuantityPage(int quantityProduct) {
        double quantityPage = Math.ceil(Double.parseDouble(quantityProduct + "") / LIMIT);
        return (int) quantityPage;
    }

    public List<Product> filter(List<Integer> listId, int pageNumber) {
        ProductCardDAO productCardDAO = new ProductCardDAO();
        List<Product> productList = productCardDAO.pagingAndFilter(listId, pageNumber, LIMIT);
        return productList;
    }
    public List<Integer> getIdProductFromCategoryId(String[] categoryIds) {
        ProductCardDAO productCardDAO = new ProductCardDAO();
        List<Product> listProduct = productCardDAO.getIdProductByCategoryId(Arrays.asList(categoryIds));
        if (listProduct.isEmpty()) return null;
        List<Integer> listId = new ArrayList<>();
        for (Product p :
                listProduct) {
            listId.add(p.getId());
        }
        return listId;
    }

    public List<Integer> getIdProductFromSize(String[] sizes) {
        ProductCardDAO productCardDAO = new ProductCardDAO();
        List<Product> listProduct = productCardDAO.getIdProductBySize(Arrays.asList(sizes));
        if (listProduct.isEmpty()) return null;
        List<Integer> listId = new ArrayList<>();
        for (Product p :
                listProduct) {
            listId.add(p.getId());
        }
        return listId;
    }

    public List<Integer> getIdProductFromColor(String[] colors) {
        ProductCardDAO productCardDAO = new ProductCardDAO();
        List<Product> listProduct = productCardDAO.getIdProductByColor(Arrays.asList(colors));
        if (listProduct.isEmpty()) return null;
        List<Integer> listId = new ArrayList<>();
        for (Product p :
                listProduct) {
            listId.add(p.getId());
        }
        return listId;
    }

    public List<Integer> getIdProductFromMoneyRange(List<MoneyRange> moneyRangeList) {
        ProductCardDAO productCardDAO = new ProductCardDAO();
        List<Product> listProduct = productCardDAO.getIdProductByMoneyRange(moneyRangeList);
        if (listProduct.isEmpty()) return null;
        List<Integer> listId = new ArrayList<>();
        for (Product p :
                listProduct) {
            listId.add(p.getId());
        }
        return listId;
    }

}
