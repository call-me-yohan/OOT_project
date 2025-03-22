package Classes;

import java.util.Arrays;

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
     public String getItemName() {
        return itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public double getCostPerUnit() {
        return costperUnit;
    }

    public String[] getColours() {
        return Arrays.copyOf(colours, colours.length); // Defensive Copy
    }

    public String getItemType() {
        return itemType;
    }

    public String[] getHazardPrecautions() {
        return Arrays.copyOf(hazardPrecautions, hazardPrecautions.length); // Defensive Copy
    }

    public String getTexture() {
        return texture;
    }

    public int getQtyInStock() {
        return qtyinStock;
    }


}
