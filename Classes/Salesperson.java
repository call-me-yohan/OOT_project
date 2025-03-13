package Classes;

import java.util.ArrayList;
import java.util.List;

public class Salesperson extends User{
    private List<Customer> customers;
    private List<Order> orders;

    public Salesperson(String username, String passwrod, String usertype){
        super(username, passwrod, usertype);
        orders = new ArrayList<>();
        customers = new ArrayList<>();
    }

     //retrieve order from database
    public void handleOrders(int orderId, Item items, int quantities, String dateOrder, String deliveryDate, Boolean status){
        Order order = new Order(orderId, dateOrder, deliveryDate, status);
        order.addItem(items, quantities);
        orders.add(order);
    }

    public void addCustomer(int custId, String custName, String paymentMethod, String dob, String phoneNumber, String custAddress){
        Customer customer = new Customer(custId, custName, paymentMethod, dob, phoneNumber, custAddress);
        customers.add(customer);
    }

    public List<Order> getOrder(){
        return orders;
    }

    public List<Customer> getCustomers(){
        return customers;
    }
}