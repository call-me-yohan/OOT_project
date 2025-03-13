package Classes;

public class Item {
    private String itemName;
    private int itemId;
    private double costperUnit;
    private String[] colours;
    private String itemType;
    private String[] hazardPrecautions;
    private String texture;
    private int qtyinStock;

    public Item(String itemName, int itemId, double costperUnit, String[] colours, String itemType, String[] hazardPrecautions, String texture, int qtyinStock){
        this.itemName = itemName;
        this.itemId = itemId;
        this.costperUnit= costperUnit;
        this.colours = colours;
        this.itemType = itemType;
        this.hazardPrecautions = hazardPrecautions;
        this.texture = texture;
        this.qtyinStock = qtyinStock;
    }

    public String getitemName(){
        return itemName;
    }

    public int getitemId(){
        return itemId;
    }

    public double getcostperUnit(){
        return costperUnit;
    }

    public String[] getColours(){
        return colours;
    }

    public String getitemType(){
        return itemType;
    }

    public String[] getharzardPrecautions(){
        return hazardPrecautions;
    }

    public String getTexture(){
        return texture;
    }

    public int getqtyinStock(){
        return qtyinStock;
    }

    public void reduceStock(int quantity){
        if(quantity< qtyinStock){
            qtyinStock -= quantity;
        }else{
            System.out.println("Error, not enough stock to reduce");
        }
    }
}
