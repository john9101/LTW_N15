package models;

public class Size {
    private int id;
    private String nameSize;
    private int productId;
    private double sizePrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSize() {
        return nameSize;
    }

    public void setNameSize(String nameSize) {
        this.nameSize = nameSize;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(double sizePrice) {
        this.sizePrice = sizePrice;
    }

    @Override
    public String toString() {
        return "Sizes{" +
                "id=" + id +
                ", nameSize='" + nameSize + '\'' +
                ", productId=" + productId +
                ", sizePrice=" + sizePrice +
                '}';
    }
}
