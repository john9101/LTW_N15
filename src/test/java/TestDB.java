
import dao.CategoryDAO;
import dao.CategoryDAOImplement;
import dao.ImageDAO;
import dao.ImageDAOImplement;
import models.ProductCart;
import models.User;
import services.AuthenticateServices;
import services.ProductCartServices;

import java.util.List;

public class TestDB {
    public static void main(String[] args) {
//        UserDAO userDAO = new UserDAOImplement();
//        System.out.println(userDAO.selectByEmail("ducvui2003@gmail.com", "1"));
//        System.out.println(userDAO.selectById(24));
//        userDAO.updatePassword(23, "123456");
//        User user = AuthenticateServices.getINSTANCE().checkSignIn("ducvui2003", "123456");
//        System.out.println(user.isRole());
//        System.out.println(user);
//        System.out.println(user);
//        String str = "ducvui2003";
//        String encoding = Encoding.getINSTANCE().toSHA1(str);
//        System.out.println(encoding);
//        UserDAO userDAO = new UserImplement();
////        System.out.println(userDAO.insert(new User("ducvui20", "20012001", "ducvui@gmail.com", false, false)));
//        List<User> userList = userDAO.selectALl();
//        for (User item : userList) {
//            String passEncoding = Encoding.getINSTANCE().toSHA1(item.getPasswordEncoding());
////            System.out.println( userDAO.updatePasswordEncoding(item.getId(), passEncoding));
//        }
//        System.out.println(  userDAO.updateTokenVerify(23, null));
//        images();
        category();
    }

    public static void checkUser(int id) {

    }

    public static void images() {
        ImageDAO imageDAO = new ImageDAOImplement();
        System.out.println(imageDAO.getThumbnail(10));
        List<ProductCart> productCartServices = ProductCartServices.getINSTANCE().getAllProductCart();
        productCartServices.stream().forEach(System.out::println);
    }
    public static void category(){
        CategoryDAO categoryDAO = new CategoryDAOImplement();
        System.out.println(categoryDAO.getAllCategory());
    }
}
