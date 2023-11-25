public class EnhancedPlayer {

    private String fullName;
    private int healthPercetage;
    private String weapon;

    public EnhancedPlayer(String fullName) {
        this(fullName, 100, "Sword");
    }

    public EnhancedPlayer(String fullName, int health, String weapon) {
        this.fullName = fullName;
        if (health <= 0) {
            this.healthPercetage = 1;
        } else if (health > 100) {
            this.healthPercetage = 100;
        } else {
            this.healthPercetage = health;
        }
                this.weapon = weapon;
    }

    public void loseHeath(int damage) {
        healthPercetage = healthPercetage - damage;
        if (healthPercetage <= 0) {
            System.out.println("Player knocked out of game");
        }
    }

    public int healthRemaining() {
        return healthPercetage;
    }

    public void restoreHealth(int extraHealth) {
        healthPercetage = healthPercetage + extraHealth;
        if (healthPercetage > 100) {
            System.out.println("Player restored to 100%");
            healthPercetage = 100;
        }
    }
}
