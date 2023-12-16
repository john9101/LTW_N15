package services;

import dao.*;
import models.*;
import utils.FilterPaging;

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
        ReviewDAO reviewDAO = new ReviewDAOImplement();
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
        ProductCardDAO productCardDAO = new ProductCardDAOImplement();
        List<ProductCard> productCardList = productCardDAO.getCartAllProduct();
        ImageDAO imageDAO = new ImageDAOImplement();
        for (ProductCard productCard : productCardList) {
//           Get thumbnail
            int productId = productCard.getId();
            List<Image> imageList = imageDAO.getThumbnail(productId);
            productCard.setNameImage(imageList.getFirst().getNameImage());
//           Calculate starRating
            int star = calculateStar(productCard);
            productCard.setStar(star);
        }
        return productCardList;
    }

    public List<Category> getAllCategory() {
        CategoryDAO categoryDAO = new CategoryDAOImplement();
        List<Category> listCategories = categoryDAO.getAllCategory();
        return listCategories;
    }

    public List<Color> getAllColor() {
        ColorDAO colorDAO = new ColorDAOImplement();
        List<Color> listColor = colorDAO.getAllColor();
        return listColor;
    }

    public List<Size> getAllSize() {
        SizeDAO sizeDAO = new SizeDAOImplement();
        List<Size> listSize = sizeDAO.getAllSize();
        return listSize;
    }

    public List<ProductCard> getProducts(int numberPage) {
        ProductCardDAO productCardDAO = new ProductCardDAOImplement();
        List<ProductCard> productCardList = productCardDAO.getProducts(LIMIT, numberPage);
        ImageDAO imageDAO = new ImageDAOImplement();
        for (ProductCard productCard : productCardList) {
//           Get thumbnail
            int productId = productCard.getId();
            List<Image> imageList = imageDAO.getThumbnail(productId);
            productCard.setNameImage(imageList.getFirst().getNameImage());
//           Calculate starRating
            int star = calculateStar(productCard);
            productCard.setStar(star);
        }
        return productCardList;
    }

    public int getQuantityPage() {
        ProductCardDAO productCardDAO = new ProductCardDAOImplement();
        double quantityPage = Math.ceil(Double.parseDouble(productCardDAO.getQuantityProduct() + "") / LIMIT);
        return (int) quantityPage;
    }

    public List<ID> findIdByName(String name) {
        ProductDAO productDAO = new ProductDAOImplement();
        return productDAO.findIdByName(name);
    }

    public List<ProductCard> filter(List<ID> listId, int pageNumber) {
        ProductCardDAO productCardDAO = new ProductCardDAOImplement();
        List<ProductCard> productCardList = productCardDAO.pagingAndFilter(listId, pageNumber, LIMIT);
        ImageDAO imageDAO = new ImageDAOImplement();
        for (ProductCard productCard : productCardList) {
//           Get thumbnail
            int productId = productCard.getId();
            List<Image> imageList = imageDAO.getThumbnail(productId);
            productCard.setNameImage(imageList.getFirst().getNameImage());
//           Calculate starRating
            int star = calculateStar(productCard);
            productCard.setStar(star);
        }
        return productCardList;
    }


    private List<Integer> findCommonIDs(List<List<ID>> lists) {
        List<Integer> commonIDs = new ArrayList<>();

        if (lists.isEmpty()) {
            return commonIDs; // Return an empty list if no lists are provided
        }

        // Use a set to store IDs of the first list
        Set<Integer> idSet = new HashSet<>();
        for (ID element : lists.get(0)) {
            idSet.add(element.getId());
        }

        // Iterate through each list starting from the second list
        for (int i = 1; i < lists.size(); i++) {
            List<ID> currentList = lists.get(i);

            // Create a set for the current list IDs to find common elements efficiently
            Set<Integer> currentIdSet = new HashSet<>();
            for (ID element : currentList) {
                currentIdSet.add(element.getId());
            }

            // Retain only IDs present in both sets
            idSet.retainAll(currentIdSet);
        }

        // Add common IDs to the output list
        commonIDs.addAll(idSet);

        return commonIDs;
    }
}
