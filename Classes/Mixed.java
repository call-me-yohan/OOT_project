package Classes;

import java.util.Arrays;
import java.util.Date;

public class Mixed extends Item {
    // Dangerous sh!t [Ping]
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

    public NaturalFiber[] getNaturalFibers() {
        return Arrays.copyOf(naturalFibers, naturalFibers.length); // Defensive Copy
    }

    public ManMadeFiber[] getManMadeFibers() {
        return Arrays.copyOf(manMadeFibers, manMadeFibers.length); // Defensive Copy
    }

    public double getPercentNatural() {
        return percentNatural;
    }

    public double getPercentManMade() {
        return percentManMade;
    }

    public int getLifeSpan() {
        return LifeSpan;
    }

    public Date getExpiryDate() {
        return new Date(expiryDate.getTime()); // Defensive Copy
    }

    public void addNaturalFiber(NaturalFiber newFiber) {
        if (newFiber == null) {
            throw new IllegalArgumentException("Fiber cannot be null");
        }
    
        NaturalFiber[] updatedFibers = new NaturalFiber[naturalFibers.length + 1];
        System.arraycopy(naturalFibers, 0, updatedFibers, 0, naturalFibers.length);
        updatedFibers[naturalFibers.length] = newFiber;

        naturalFibers = updatedFibers;
    }

    public void addManMadeFiber(ManMadeFiber newFiber) {
        if (newFiber == null) {
            throw new IllegalArgumentException("Fiber cannot be null");
        }
    
        ManMadeFiber[] updatedFibers = new ManMadeFiber[manMadeFibers.length + 1];
        System.arraycopy(manMadeFibers, 0, updatedFibers, 0, manMadeFibers.length);
        updatedFibers[manMadeFibers.length] = newFiber;
        manMadeFibers = updatedFibers;
    }


}
