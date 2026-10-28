public class MandrakeRoot extends PotionDecorator {

    public MandrakeRoot(Potion potion) {
        super(potion);
    }

    @Override
    public String getDescription() {
        return potion.getDescription() + ", Mandrake Root";
    }

    @Override
    public int healing() {
        return potion.healing() + 1;
    }

    @Override
    public int stability() {
        return potion.stability() + 2;
    }
}
