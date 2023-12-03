package models;

import utils.Encoding;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
    private int id;
    private String username;
    private String passwordEncoding;
    private String fullName;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private Date birthDay;
    private boolean isVerify;
    private boolean role;
    private String avatar;

    private String tokenVerify;
    private String tokenResetPassword;

    public User() {
    }
    

    public User(String username, String password) {
        this.username = username;
        this.passwordEncoding = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordEncoding() {
        return passwordEncoding;
    }

    public void setPasswordEncoding(String passwordEncoding) {
        this.passwordEncoding = passwordEncoding;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isVerify() {
        return isVerify;
    }

    public void setVerify(boolean verify) {
        isVerify = verify;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordEncoding='" + passwordEncoding + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", birthDay=" + birthDay +
                ", isVerify=" + isVerify +
                ", role=" + role +
                ", avatar='" + avatar + '\'' +
                ", tokenVerify='" + tokenVerify + '\'' +
                ", tokenResetPassword='" + tokenResetPassword + '\'' +
                '}';
    }

    public String getTokenVerify() {
        return tokenVerify;
    }

    public void setTokenVerify(String tokenVerify) {
        this.tokenVerify = tokenVerify;
    }

    public String getTokenResetPassword() {
        return tokenResetPassword;
    }

    public void setTokenResetPassword(String tokenResetPassword) {
        this.tokenResetPassword = tokenResetPassword;
    }
}
