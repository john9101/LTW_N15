package dao;

import database.JDBIConnector;
import models.User;
import utils.Encoding;

import java.util.List;
import java.util.stream.Collectors;

public class UserImplement implements UserDAO {
    @Override
    public List<User> selectALl() {
        List<User> users = JDBIConnector.get().withHandle(handle ->
                handle.createQuery("SELECT * FROM users")
                        .mapToBean(User.class).stream().collect(Collectors.toList())
        );
        return users;
    }


    @Override
    public User selectById(int id) {
        List<User> users = JDBIConnector.get().withHandle(handle ->
                handle.createQuery("SELECT id, username, fullName, gender, phone, email, address, birthday, isVerify, role, avatar FROM users WHERE id = ?").bind(0, id)
                        .mapToBean(User.class).stream().collect(Collectors.toList())
        );
        if (users.size() == 1) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<User> selectAccount(String username, String isVerify) {
        List<User> users = null;
        if (isVerify == null) {
            users = JDBIConnector.get().withHandle(handle ->
                    handle.createQuery("SELECT id, username, passwordEncoding, role, isVerify FROM users WHERE username = ?").bind(0, username)
                            .mapToBean(User.class).list()
            );
        } else {
            users = JDBIConnector.get().withHandle(handle ->
                    handle.createQuery("SELECT id, username, passwordEncoding, role, isVerify FROM users WHERE username = ? AND isVerify = ?").bind(0, username).bind(1, isVerify)
                            .mapToBean(User.class).list()
            );
        }
        return users;
    }

    @Override
    public List<User> selectByEmail(String email, String isVerify) {
        List<User> users = null;
        if (isVerify == null) {
            users = JDBIConnector.get().withHandle(handle ->
                    handle.createQuery("SELECT id, username, email, passwordEncoding, tokenResetPassword FROM users WHERE email = ?").bind(0, email)
                            .mapToBean(User.class).list()
            );
        } else {
            users = JDBIConnector.get().withHandle(handle ->
                    handle.createQuery("SELECT id, username, email, passwordEncoding, tokenResetPassword FROM users WHERE email = ? AND isVerify = ?").bind(0, email).bind(
                                    1, isVerify)
                            .mapToBean(User.class).list()
            );
        }
        return users;
    }

    @Override
    public List<User> findUsername(String username) {
        return GeneralDao.executeQueryWithSingleTable("SELECT id FROM users WHERE username = ?", User.class, username);
    }

    @Override
    public List<User> findEmail(String email) {
        return GeneralDao.executeQueryWithSingleTable("SELECT id FROM users WHERE email = ?", User.class, email);
    }

    @Override
    public int updatePassword(int id, String pass) {
        String passwordEncode = Encoding.getINSTANCE().toSHA1(pass);
        String statement = "UPDATE users " +
                "SET passwordEncoding = :passwordEncoding "
                + "WHERE id = :id";
        int count = JDBIConnector.get().withHandle(handle -> handle.createUpdate(statement)
                .bind("id", id)
                .bind("passwordEncoding", passwordEncode)
                .execute());
        return count;
    }

    @Override
    public List<User> selectTokenVerify(String username) {
        List<User> users = JDBIConnector.get().withHandle(handle ->
                handle.createQuery("SELECT id, tokenVerify FROM users WHERE username = ? AND isVerify = 0").bind(0, username)
                        .mapToBean(User.class).stream().collect(Collectors.toList())
        );
        return users;
    }

    @Override
    public void updateTokenVerify(int id, String token) {
        String statement = "UPDATE users " +
                "SET tokenVerify = :tokenVerify " +
                "WHERE id = :id";
        int count = JDBIConnector.get().withHandle(handle -> handle.createUpdate(statement)
                .bind("id", id)
                .bind("tokenVerify", token)
                .execute());
    }

    @Override
    public void updateVerify(int id, boolean status) {
        String statement = "UPDATE users " +
                "SET isVerify = :verify " +
                "WHERE id = :id";
        int count = JDBIConnector.get().withHandle(handle -> handle.createUpdate(statement)
                .bind("id", id)
                .bind("verify", status)
                .execute());
    }

    @Override
    public List<User> selectTokenResetPassword(String email) {
        return GeneralDao.executeQueryWithSingleTable("SELECT id, tokenResetPassword FROM users WHERE email = ?", User.class, email);
    }

    @Override
    public void updateTokenResetPassword(int id, String token) {
        String query = "UPDATE users " +
                "SET tokenResetPassword = ? " +
                "WHERE id = ?";
        GeneralDao.executeAllTypeUpdate(query, token, id);
    }

    @Override
    public int insert(User user) {
        String statement = "INSERT INTO users (username, passwordEncoding, email, isVerify, role, tokenVerify) VALUES (?, ?, ?, ?, ?, ?);";
        int count = JDBIConnector.get().withHandle(handle -> handle.createUpdate(statement)
                .bind(0, user.getUsername())
                .bind(1, user.getPasswordEncoding())
                .bind(2, user.getEmail())
                .bind(3, user.isVerify())
                .bind(4, user.isRole())
                .bind(5, user.getTokenVerify())
                .execute());
        return count;
    }

    @Override
    public int insertAll(List<User> list) {
        int count = 0;
        for (User item : list) {
            insert(item);
            count++;
        }
        return count;
    }

    @Override
    public int delete(User o) {
        return 0;
    }

    @Override
    public int deleteAll(List<User> list) {
        return 0;
    }

    @Override
    public int update(Object o) {
        User user = (User) o;
        String statement = "UPDATE users " +
                "SET username = :username, passwordEncoding = :passwordEncoding, fullName = :fullName, " +
                "gender = :gender, email = :email, phone = :phone, address = :address, birthday = :birthday, " +
                "isVerify = :isVerify, role = :role, avatar = :avatar, tokenVerify = :tokenVerify, " +
                "tokenResetPassword = :tokenResetPassword " +
                "WHERE id = :id";
        int count = JDBIConnector.get().withHandle(handle -> handle.createUpdate(statement)
                .bind("id", user.getId())
                .bind("username", user.getUsername())
                .bind("passwordEncoding", user.getPasswordEncoding())
                .bind("email", user.getEmail())
                .bind("fullName", user.getFullName())
                .bind("phone", user.getPhone())
                .bind("address", user.getAddress())
                .bind("birthday", user.getBirthDay())
                .bind("isVerify", user.isVerify())
                .bind("role", user.isRole())
                .bind("avatar", user.getAvatar())
                .bind("tokenVerify", user.getTokenVerify())
                .bind("tokenResetPassword", user.getTokenResetPassword())
                .execute());
        return count;
    }
}
