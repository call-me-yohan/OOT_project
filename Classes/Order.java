package Classes;

public class Order {
    private int orderId;
    private int quantity;
    private String dateOrder;
    private String deliveryDate;
    private boolean status;
    
    public Order(int orderId, int quantity, String dateOrder, String deliveryDate, Boolean status){
        this.orderId = orderId;
        this.quantity = quantity;
        this.dateOrder = dateOrder;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }
}
