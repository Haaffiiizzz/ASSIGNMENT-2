public class DraughtPotion extends Potion {

    public DraughtPotion() {
        description = "Base Draught";
    }

    @Override
    public int healing() {
        return 1;
    }

    @Override
    public int stability() {
        return 1;
    }
}
