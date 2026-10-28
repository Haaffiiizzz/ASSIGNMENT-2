public abstract class PotionDecorator extends Potion {
    protected Potion potion;

    public PotionDecorator(Potion potion) {
        this.potion = potion;
    }

    @Override
    public abstract String getDescription();
}
