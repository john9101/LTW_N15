package models;

public class Image {
    private int id;
    private String nameImage;
    private int productId;
    private boolean isThumbnail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean isThumbnail() {
        return isThumbnail;
    }

    public void setThumbnail(boolean thumbnail) {
        isThumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", nameImage='" + nameImage + '\'' +
                ", productId=" + productId +
                ", isThumbnail=" + isThumbnail +
                '}';
    }
}
