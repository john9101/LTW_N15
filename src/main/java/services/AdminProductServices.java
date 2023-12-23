package services;

import dao.ProductDao;
import models.*;

import java.util.List;

public class AdminProductServices {
    ProductDao productDAO = new ProductDao();

    public int getIdProductByName(String name) {
        return productDAO.getIdProductByName(name).get(0).getId();
    }

    public boolean addProduct(Product product) {
//        Check product exist
        List<Product> productList = productDAO.getIdProductByName(product.getName());
        if (productList.isEmpty()) {
            return productDAO.addProduct(product);
        } else {
            return false;
        }
    }

//    public boolean addParameter(Parameter[] parameterArray, String idProduct) {
//
//    }

    public boolean addColors(String[] codeColors, int productId) {
        if (codeColors == null || codeColors.length == 0) return false;
        Color[] colors = new Color[codeColors.length];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = new Color();
            colors[i].setCodeColor(codeColors[i]);
            colors[i].setProductId(productId);
        }
        return productDAO.addColors(colors);
    }

    public boolean addImages(String[] nameImages, int productId) {
        if (nameImages.length == 0) return false;
        Image[] images = new Image[nameImages.length];
        for (int i = 0; i < images.length; i++) {
            images[i] = new Image();
            images[i].setNameImage(nameImages[i]);
            images[i].setProductId(productId);
        }
        return productDAO.addImages(images);
    }

    public boolean addSizes(String[] nameSizes, String[] priceSizes, int productId) {
        if (nameSizes.length != priceSizes.length || nameSizes.length == 0) return false;
        Size[] sizes = new Size[nameSizes.length];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = new Size();
            sizes[i].setNameSize(nameSizes[i]);
            sizes[i].setProductId(productId);
            sizes[i].setSizePrice(Double.parseDouble(priceSizes[i]));
        }
        return productDAO.addSizes(sizes);
    }
}
