public class Player {
    private int health;
    private Potion potion;

    public Player() {
        health = 1;
        potion = null;
    }

    public int getHealth() {
        return health;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    public void eat(Food food) {
        health += food.getEnergy();
    }
}
