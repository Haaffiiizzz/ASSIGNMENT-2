public class PowderedUnicornHorn extends PotionDecorator {

    public PowderedUnicornHorn(Potion potion) {
        super(potion);
    }

    @Override
    public String getDescription() {
        return potion.getDescription() + ", Powdered Unicorn Horn";
    }

    @Override
    public int healing() {
        return potion.healing() + 2;
    }

    @Override
    public int stability() {
        return potion.stability() + 1;
    }
}
