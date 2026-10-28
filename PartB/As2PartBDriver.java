import java.util.Random;
import javax.swing.JOptionPane;

public class As2PartBDriver {
    private static final Random random = new Random();

    private static final String[] ITEMS = {
        "Base Draught",
        "Chocolate Frog",
        "Bertie Botts' Every Flavour Beans",
        "Butterbeer",
        "Mandrake Root",
        "Powdered Unicorn Horn",
        "Phoenix Feather",
        "Exploding Cauldron"
    };

    public static void main(String[] args) {
        Player player = new Player();

        JOptionPane.showMessageDialog(null,
            "Welcome to Potion Quest!\nHealth: "
            + player.getHealth() + " HP\nPotion: None");

        while (true) {
            int choice = random.nextInt(ITEMS.length);

            if (choice == 0 && player.getPotion() != null) {
                continue;
            }

            int answer = JOptionPane.showConfirmDialog(
                null,
                ITEMS[choice] + ": pick up?",
                "Potion Quest",
                JOptionPane.YES_NO_OPTION
            );

            if (answer == JOptionPane.CLOSED_OPTION) {
                break;
            }

            if (answer != JOptionPane.YES_OPTION) {
                continue;
            }

            switch (choice) {
                case 0:
                    player.setPotion(new DraughtPotion());
                    showPotion(player, "New potion: Base Draught");
                    break;

                case 1:
                    eatFood(player, new ChocolateFrog());
                    break;

                case 2:
                    eatFood(player, new BertiesBeans());
                    break;

                case 3:
                    eatFood(player, new Butterbeer());
                    break;

                case 4:
                    enhance(player, 4);
                    break;

                case 5:
                    enhance(player, 5);
                    break;

                case 6:
                    enhance(player, 6);
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null,
                        "Cauldron exploded... Seamus!!!\nGame over!");
                    return;

                default:
                    break;
            }
        }
    }

    private static void eatFood(Player player, Food food) {
        player.eat(food);

        JOptionPane.showMessageDialog(null,
            "Ate " + food.getDescription()
            + "\nHealth: " + player.getHealth() + " HP");
    }

    private static void enhance(Player player, int choice) {
        Potion potion = player.getPotion();

        if (potion == null) {
            JOptionPane.showMessageDialog(null,
                "You need a Base Draught before adding enhancements.");
            return;
        }

        if (choice == 4) {
            potion = new MandrakeRoot(potion);
        } else if (choice == 5) {
            potion = new PowderedUnicornHorn(potion);
        } else if (choice == 6) {
            potion = new PhoenixFeather(potion);
        }

        player.setPotion(potion);
        showPotion(player, "Enhancement added");
    }

    private static void showPotion(Player player, String title) {
        Potion potion = player.getPotion();

        JOptionPane.showMessageDialog(null,
            title
            + "\n" + potion.getDescription()
            + "\nHealing: " + potion.healing()
            + "\nStability: " + potion.stability()
            + "\nHealth: " + player.getHealth() + " HP");
    }
}
