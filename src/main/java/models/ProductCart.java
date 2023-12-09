package models;

public class ProductCart {
    private int id;
    private String name;
    private String nameImage;
    private int star;
    private int reviews;
    private double originalPrice;
    private double salePrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "ProductCart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameImage='" + nameImage + '\'' +
                ", star=" + star +
                ", reviews=" + reviews +
                ", originalPrice=" + originalPrice +
                ", salePrice=" + salePrice +
                '}';
    }
}
