/**
 * ACS-3913 - Assignment 2
 */

public abstract class Food implements Item{
    protected String description = "unknown food";
    protected int energy = 0;
    
    public String getDescription(){
        return description;
    }

    public int getEnergy(){
        return energy;
    }
}
