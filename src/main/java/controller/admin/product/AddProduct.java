package controller.admin.product;

import models.Product;
import properties.PathProperties;
import services.AdminProductServices;
import utils.Token;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "admin-add-product", value = "/admin-add-product")
@MultipartConfig(
        fileSizeThreshold = 1024 * 12024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        String name = request.getParameter("name");
        String idCategory = request.getParameter("idCategory");
        String originalPrice = request.getParameter("originalPrice");
        String salePrice = request.getParameter("salePrice");
        String description = request.getParameter("description");
        String[] nameSizes = request.getParameterValues("nameSize");
        String[] sizePrices = request.getParameterValues("sizePrice");
        String[] colors = request.getParameterValues("color");

//        Add Product
        Product product = new Product();
        product.setName(name);
        product.setCategoryId(Integer.parseInt(idCategory));
        product.setOriginalPrice(Double.parseDouble(originalPrice));
        product.setDescription(description);
        product.setSalePrice(Double.parseDouble(salePrice));
        product.setVisibility(true);
        product.setCreateAt(Date.valueOf(LocalDate.now()));

//        Add Product
        int productId = AdminProductServices.getINSTANCE().addProduct(product);

        StringBuilder objJson = new StringBuilder();
        if (productId == 0) {
            objJson.append("{\"status\":").append("false}");
        } else {
//        Add Size
            double[] sizePricesDouble = new double[sizePrices.length];
            for (int i = 0; i < sizePricesDouble.length; i++) {
                sizePricesDouble[i] = Double.parseDouble(sizePrices[i]);
            }
            AdminProductServices.getINSTANCE().addSize(nameSizes, sizePricesDouble, productId);

//        Add Color
            AdminProductServices.getINSTANCE().addColor(colors, productId);

//        Add Images
            Collection<Part> images = request.getParts();
            uploadImg(images, 2);
            objJson.append("{\"status\":").append("true}");
        }
        response.getWriter().write(objJson.toString());
    }

    public static boolean isPartImage(Part part) {
        if (part != null) {
            String contentType = part.getContentType();
            if (contentType != null && contentType.startsWith("image/")) {
                return true;
            }
        }
        return false;
    }

    public void uploadImg(Collection<Part> parts, int productId) throws IOException {
        ServletContext servletContext = getServletContext();
        List<String> nameImages = new ArrayList<>();
        File root = new File(servletContext.getRealPath("/") + PathProperties.getINSTANCE().getPathProductWeb());
        if (!root.exists()) root.mkdirs();
//        Move
        for (Part part : parts) {
            if (isPartImage(part)) {
                String fileName = Token.generateToken();
                String fileExtension = part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf(".") + 1);
                String pathImage = root.getAbsolutePath() + "/" + fileName + "." + fileExtension;
                nameImages.add(fileName + "." + fileExtension);
                part.write(pathImage);
            }
        }
        AdminProductServices.getINSTANCE().addImages(nameImages, productId);
        System.out.println("Done");
    }
}