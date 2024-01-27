package models;

import java.util.Date;

public class Order {
    private String id;
    private String userId;
    private Date dateOrder;
    private String paymentMethod;
    private int deliveryMethodId;
    private int paymentMethodId;
    private String fullname;
    private String email;
    private String phone;
    private String address;
    private String statusOrder;
    private int orderStatusId;
    private int transactionStatusId;
    private int voucherId;


    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getStatusOrder() {
        return statusOrder;
    }


    public int getVoucherId() {
        return voucherId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }


    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public int getTransactionStatusId() {
        return transactionStatusId;
    }

    public void setTransactionStatusId(int transactionStatusId) {
        this.transactionStatusId = transactionStatusId;
    }

    public int getDeliveryMethodId() {
        return deliveryMethodId;
    }

    public void setDeliveryMethodId(int deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}
