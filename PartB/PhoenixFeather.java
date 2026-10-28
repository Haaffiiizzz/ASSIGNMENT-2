public class PhoenixFeather extends PotionDecorator {

    public PhoenixFeather(Potion potion) {
        super(potion);
    }

    @Override
    public String getDescription() {
        return potion.getDescription() + ", Phoenix Feather";
    }

    @Override
    public int healing() {
        return potion.healing() + 3;
    }

    @Override
    public int stability() {
        return potion.stability() + 3;
    }
}
