package Classes;

import java.util.Date;

public class Mixed extends Item {

    NaturalFiber[] naturalFibers;
    ManMadeFiber[] manMadeFibers;

    Double percentNatural;
    Double percentManMade;

    int LifeSpan;
    Date expiryDate;
    
    public Mixed(NaturalFiber[] naturalFibers, ManMadeFiber[] manMadeFibers, Double percNat, Double percMan, Date expiryDate, int lifeSpan,String itemName, int itemId, double costperUnit, String[] colours, String itemType,
            String[] hazardPrecautions, String texture, int qtyinStock) {
        super(itemName, itemId, costperUnit, colours, itemType, hazardPrecautions, texture, qtyinStock);
        
        this.naturalFibers = naturalFibers;
        this.manMadeFibers = manMadeFibers;

        percentNatural = percNat;
        percentManMade = percMan;

        LifeSpan = lifeSpan;
        this.expiryDate = expiryDate;
    }

    public void SetExpiryDate(Date expiryDate){
        this.expiryDate = expiryDate;
    }
}
