package Classes;

import java.util.Arrays;

public class ManMadeFiber extends Item {

    String[] properties;
    int LifeSpan;

    public ManMadeFiber(String[] props, int lifeSpan, String itemName, int itemId, double costperUnit, String[] colours, String itemType,
            String[] hazardPrecautions, String texture, int qtyinStock) {
        super(itemName, itemId, costperUnit, colours, itemType, hazardPrecautions, texture, qtyinStock);
        
        properties = props;
        LifeSpan = lifeSpan;
    }

    public String[] getProperties() {
        return Arrays.copyOf(properties, properties.length); // Defensive Copy
    }

    public int getLifeSpan() {
        return LifeSpan;
    }

    // Setters
    public void setProperties(String[] properties) {
        this.properties = Arrays.copyOf(properties, properties.length); // Defensive Copy
    }

    public void setLifeSpan(int lifeSpan) {
        this.LifeSpan = lifeSpan;
    }

}
