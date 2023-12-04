package dao;

import models.User;

import java.util.List;

public interface UserDAO extends DAO<User> {

    List<User> selectByEmail(String email, String isVerify);

    List<User> selectAccount(String username, String isVerify);

    List<User> findUsername(String username);

    List<User> findEmail(String email);

    public int updatePasswordEncoding(int id, String pass);

    public List<User> selectTokenVerify(String username);

    public void updateTokenVerify(int id, String token);

    public void updateVerify(int id, boolean status);

    public List<User> selectTokenResetPassword(String email);

    public void updateTokenResetPassword(int id, String token);

    @Override
    int delete(User o);
}
