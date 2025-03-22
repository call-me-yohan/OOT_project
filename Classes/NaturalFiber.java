package Classes;

public class NaturalFiber extends Item {

    String CareInstructions; 
    int lifeSpan;
    String Source;

    public NaturalFiber(String CareIns, int lifeSpan, String src, String itemName, int itemId, double costperUnit, String[] colours, String itemType,
            String[] hazardPrecautions, String texture, int qtyinStock) {
        super(itemName, itemId, costperUnit, colours, itemType, hazardPrecautions, texture, qtyinStock);
        
        CareInstructions = CareIns;
        this.lifeSpan = lifeSpan;

        Source = src;
    }

    public String getCareInstructions() {
        return CareInstructions;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public String getSource() {
        return Source;
    }

    // Setters
    public void setCareInstructions(String careInstructions) {
        this.CareInstructions = careInstructions;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public void setSource(String source) {
        this.Source = source;
    }
    
}
