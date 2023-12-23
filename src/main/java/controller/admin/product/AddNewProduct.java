package controller.admin.product;

import config.PathProperties;
import utils.Token;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "admin-add-product", value = "/admin-add-product")
@MultipartConfig(
        fileSizeThreshold = 1024 * 12024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class AddNewProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String idCategory = request.getParameter("idCategory");
        String originalPrice = request.getParameter("originalPrice");
        String salePrice = request.getParameter("salePrice");
        String description = request.getParameter("description");
        String[] sizePrices = request.getParameterValues("sizePrice");
        String[] nameSizes = request.getParameterValues("nameSize");
        String[] colors = request.getParameterValues("color");

        Collection<Part> images = request.getParts();

        uploadImg(images);
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

    public void uploadImg(Collection<Part> parts) throws IOException {
        ServletContext servletContext = getServletContext();
        File root = new File(servletContext.getRealPath("/") + "data/");
        if (!root.exists()) root.mkdirs();
//        Move
        for (Part part : parts) {
            System.out.println(isPartImage(part));
            if (isPartImage(part)) {
                String fileName = Token.generateToken();
                String fileExtension = part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf(".") + 1);
                part.write(root.getAbsolutePath() + "/" + fileName + "." + fileExtension);
                System.out.println("Done");
            }
        }
    }
}