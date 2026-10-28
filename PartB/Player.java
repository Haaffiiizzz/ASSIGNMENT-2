public class Player {
    private int health;
    private Potion potion;
    private Potion specialPotion;

    public Player() {
        health = 1;
        potion = null;
        specialPotion = null;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    public Potion getSpecialPotion() {
        return specialPotion;
    }

    public void setSpecialPotion(Potion specialPotion) {
        this.specialPotion = specialPotion;
    }

    public void eat(Food food) {
        health += food.getEnergy();
    }
}
