package models;

public class OrderStatus {
    private int id;
    private String typeStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(String typeStatus) {
        this.typeStatus = typeStatus;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", typeStatus='" + typeStatus + '\'' +
                '}';
    }
}
