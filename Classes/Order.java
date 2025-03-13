package Classes;

import java.util.List;

public class Order {
    private int orderId;
    private List<Item> items;
    private List<Integer> quantities;
    private String dateOrder;
    private String deliveryDate;
    private boolean status;
    
    public Order(int orderId, String dateOrder, String deliveryDate, Boolean status){
        this.orderId = orderId;
        this.dateOrder = dateOrder;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public int getorderId(){
        return orderId;
    }

    public List<Item> getItems(){
        return items;
    }

    public List<Integer> getquantities(){
        return quantities;
    }

    public String getdateOrder(){
        return dateOrder;
    }

    public String getdeliveryDate(){
        return deliveryDate;
    }

    public boolean getStatus(){
        return status;
    }

    public void addItem(Item item, int quantity){
        items.add(item);
        quantities.add(quantity);
    }

    public void deleteItem(String itemName){
        boolean remove = false;
        for(int i=0; i< items.size(); i++){
            if(items.get(i).getitemName().equalsIgnoreCase(itemName)){
                items.remove(i);
                quantities.remove(i);
                remove = true;
                break;
            }
        }
        if(remove == false)
        System.out.println("Item not found");
    }

    public double calculateTotal(){
        double total =0.0;
        for(int i=0; i< items.size(); i++){
            Item item = items.get(i);
            int quantity = quantities.get(i);

            total += item.getcostperUnit() * quantity;
        }

        return total;
    }

    public void handlebackup(){
        for(int i=0; i< items.size(); i++ ){
            int requestedqty = quantities.get(i);
            Item item = items.get(i);

            if(requestedqty <= item.getqtyinStock()){
                item.reduceStock(requestedqty);
            }else{
                int backorderedqty = requestedqty - item.getqtyinStock();
                System.out.println("Backorder for item:" + item.getitemName() + " Quantity:" + backorderedqty);
                item.reduceStock(item.getqtyinStock());
            }
        }
    }


}