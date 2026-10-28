public abstract class Potion implements Item {
    protected String description;

    @Override
    public String getDescription() {
        return description;
    }

    public abstract int healing();

    public abstract int stability();
}
