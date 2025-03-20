package Classes;

public class ManMadeFiber extends Item {

    String[] properties;
    int LifeSpan;

    public ManMadeFiber(String[] props, int lifeSpan, String itemName, int itemId, double costperUnit, String[] colours, String itemType,
            String[] hazardPrecautions, String texture, int qtyinStock) {
        super(itemName, itemId, costperUnit, colours, itemType, hazardPrecautions, texture, qtyinStock);
        
        properties = props;
        LifeSpan = lifeSpan;
    }

}
