package models;

public class Colors {
    private int id;
    private String codeColor;
    private int productId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeColor() {
        return codeColor;
    }

    public void setCodeColor(String codeColor) {
        this.codeColor = codeColor;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Colors{" +
                "id=" + id +
                ", codeColor='" + codeColor + '\'' +
                ", productId=" + productId +
                '}';
    }
}
