package characters;

public class Warrior extends Character {

    public Warrior(String name, int level, int strength, int dexterity, int intellect) {
        super(name, level, strength, dexterity, intellect);
        System.out.println("Woarg je suis le Guerrier " + name + " au niveau " + level + " je possède "
                + getLife() + " de vitalité, " + strength + " de force, " + dexterity + " d'agilité et "
                + intellect + " d'intelligence !");
    }

    /**
     * Basic Attack for Warrior
     *
     * @param player2 opponent character
     */
    @Override
    public void basicAttack(Character player2) {
        String basicAttackName = "Coup d'épée";
        int damage = this.getStrength();
        player2.setLife(player2.getLife()-damage);
        System.out.println(getName() + " utilise " + basicAttackName + " et inflige " + damage + " dommages.");
        System.out.println(player2.getName() + " perd " + damage + " points de vie");
    }

    /**
     * Special Attack for Warrior
     * @param player2 opponent character
     */
    @Override
    public void specialAttack(Character player2) {
        String specialAttackName = "Coup de Rage";
        int damage = getStrength() * 2;
        int knockback = getStrength() / 2;
        player2.setLife(player2.getLife() - damage);
        setLife(getLife() - knockback);
        System.out.println(getName() + " utilise " + specialAttackName + " et inflige " + damage + " dommages.");
        System.out.println(player2.getName() + " perd " + damage + " points de vie");
        System.out.println(getName() + " perd " + knockback + " points de vie");
    }
}
