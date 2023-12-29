package models;

public class DeliveryMethod {
    private int id;
    private String typeShipping;
    private String description;
    private double shippingFee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeShipping() {
        return typeShipping;
    }

    public void setTypeShipping(String typeShipping) {
        this.typeShipping = typeShipping;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    @Override
    public String toString() {
        return "DeliveryMethod{" +
                "id=" + id +
                ", typeShipping='" + typeShipping + '\'' +
                ", description='" + description + '\'' +
                ", shippingFee=" + shippingFee +
                '}';
    }
}
