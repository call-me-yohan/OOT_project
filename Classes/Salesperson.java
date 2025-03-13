package Classes;

import java.util.ArrayList;
import java.util.List;

public class Salesperson extends User{
    private List<Customer> customers;
    private  List<Item> items;
    private List<Order> orders;

    public Salesperson(String username, String passwrod, String usertype){
        super(username, passwrod, usertype);
        orders = new ArrayList<>();
        customers = new ArrayList<>();
        items = new ArrayList<>();
    }

    public void handleOrders(int orderId, int quantity, String dateOrder, String deliveryDate, Boolean status){
        Order order = new Order(orderId, quantity, dateOrder, deliveryDate, status);
        orders.add(order);
    }

    public void addItem(String itemName, int itemId, double costperUnit, String[] colours, String itemType, String[] hazardPrecautions, String texture, int qtyinStock){
        Item item = new Item(itemName, itemId, costperUnit, colours, itemType, hazardPrecautions, texture, qtyinStock);
        items.add(item);
    }

    public void addCustomer(int custId, String custName, String paymentMethod, String dob, String phoneNumber, String custAddress){
        Customer customer = new Customer(custId, custName, paymentMethod, dob, phoneNumber, custAddress);
        customers.add(customer);
    }

    public List<Order> getOrder(){
        return orders;
    }

    public List<Item> getitem(){
        return items;
    }

    public List<Customer> getCustomers(){
        return customers;
    }
}