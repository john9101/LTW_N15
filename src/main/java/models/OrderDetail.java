package models;

public class OrderDetail {
    private int id;
    private int orderId;
    private int productId;
    private String sizeRequired;
    private String colorRequired;
    private int quantityRequired;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSizeRequired() {
        return sizeRequired;
    }

    public void setSizeRequired(String sizeRequired) {
        this.sizeRequired = sizeRequired;
    }

    public String getColorRequired() {
        return colorRequired;
    }

    public void setColorRequired(String colorRequired) {
        this.colorRequired = colorRequired;
    }

    public int getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(int quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}