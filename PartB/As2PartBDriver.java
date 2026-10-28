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
            "Welcome to Potion Quest!\nHealth: " + player.getHealth()
            + " HP\nPotion: None\nSpecial Potion: None");

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
                    showPotion(player, "New potion: Base Draught",
                        player.getPotion());
                    break;

                case 1:
                    eatFood(player, new ChocolateFrog());
                    break;

                case 2:
                    eatFood(player, new BertiesBeans());
                    break;

                case 3:
                    handleButterbeer(player);
                    break;

                case 4:
                case 5:
                case 6:
                    enhance(player, choice);
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

    private static void handleButterbeer(Player player) {
        Butterbeer butterbeer = new Butterbeer();

        if (player.getSpecialPotion() == null) {
            int answer = JOptionPane.showConfirmDialog(
                null,
                "Do you want to use the Butterbeer as a potion?",
                "Elixir of Froth",
                JOptionPane.YES_NO_OPTION
            );

            if (answer == JOptionPane.CLOSED_OPTION) {
                return;
            }

            if (answer == JOptionPane.YES_OPTION) {
                player.setSpecialPotion(new FoodAdapter(butterbeer));

                showPotion(player, "New potion: Elixir of Froth",
                    player.getSpecialPotion());
                return;
            }
        }

        eatFood(player, butterbeer);
    }

    private static void eatFood(Player player, Food food) {
        player.eat(food);

        JOptionPane.showMessageDialog(null,
            "Ate " + food.getDescription()
            + "\nHealth: " + player.getHealth() + " HP");
    }

    private static void enhance(Player player, int choice) {
        Potion draught = player.getPotion();
        Potion special = player.getSpecialPotion();

        if (draught == null && special == null) {
            JOptionPane.showMessageDialog(null,
                "You need a potion before adding enhancements.");
            return;
        }

        boolean useSpecial;

        if (draught != null && special != null) {
            String[] buttons = {
                "Base Draught",
                "Elixir of Froth"
            };

            int selected = JOptionPane.showOptionDialog(
                null,
                "Select the potion to enhance:",
                "Choose Potion",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[0]
            );

            if (selected == JOptionPane.CLOSED_OPTION) {
                return;
            }

            useSpecial = selected == 1;
        } else {
            useSpecial = special != null;
        }

        Potion potion = useSpecial ? special : draught;

        if (choice == 4) {
            potion = new MandrakeRoot(potion);
        } else if (choice == 5) {
            potion = new PowderedUnicornHorn(potion);
        } else if (choice == 6) {
            potion = new PhoenixFeather(potion);
        }

        if (useSpecial) {
            player.setSpecialPotion(potion);
        } else {
            player.setPotion(potion);
        }

        showPotion(player,
            "Added enhancement: " + ITEMS[choice],
            potion);
    }

    private static void showPotion(
        Player player,
        String title,
        Potion potion
    ) {
        JOptionPane.showMessageDialog(null,
            title
            + "\n" + potion.getDescription()
            + "\nHealing: " + potion.healing()
            + "\nStability: " + potion.stability()
            + "\nHealth: " + player.getHealth() + " HP");
    }
}
