package se.iths.PetStore;

public class Order {
    private int id;
    private int petId;
    private int quantity;
    private String shipmentDate;
    private String status;

    public Order(int id, int petId, int quantity, String shipmentDate, String status) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipmentDate = shipmentDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
