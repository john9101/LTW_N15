import dao.UserDAO;
import dao.UserDAOImplement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSelect {
    public static void main(String[] args) {
//        System.out.println(GeneralDao.executeQueryWithSingleTable("SELECT id, fullname, username FROM users", User.class));
     UserDAO userDAO = new UserDAOImplement();
        System.out.println(userDAO.findUsername("ducvui2003"));
        final String REGEX_EMAIL_VALID = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(REGEX_EMAIL_VALID);
        Matcher matcher = pattern.matcher("ducvui2003@gmail.com");
        System.out.println(matcher.find());
    }
}
