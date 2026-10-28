public class FoodAdapter extends Potion {
    private Food food;

    public FoodAdapter(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return "Elixir of Froth";
    }

    @Override
    public int healing() {
        return food.getEnergy();
    }

    @Override
    public int stability() {
        return 0;
    }
}
