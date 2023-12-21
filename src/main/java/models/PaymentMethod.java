package models;

public class PaymentMethod {
    private int id;
    private String typeMethod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeMethod() {
        return typeMethod;
    }

    public void setTypeMethod(String typeMethod) {
        this.typeMethod = typeMethod;
    }

    @Override
    public String toString() {
        return "paymentMethod{" +
                "id=" + id +
                ", typeMethod='" + typeMethod + '\'' +
                '}';
    }
}
