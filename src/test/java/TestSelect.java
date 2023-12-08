import dao.UserDAO;
import dao.UserDAOImplement;

public class TestSelect {
    public static void main(String[] args) {
//        System.out.println(GeneralDao.executeQueryWithSingleTable("SELECT id, fullname, username FROM users", User.class));
     UserDAO userDAO = new UserDAOImplement();
        System.out.println(userDAO.findUsername("ducvui2003"));
    }
}
