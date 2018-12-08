package characters;

public class Warrior extends Character {

    public Warrior(String name, int level, int strength, int agility, int intellect) {
        super(name, level, strength, agility, intellect);
        System.out.println("Woarg je suis le Guerrier " + name + " au niveau " + level + " je possède "
                + getVitality() + " de vitalité, " + strength + " de force, " + agility + " d'agilité et "
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
        player2.setVitality(player2.getVitality() - damage);
        System.out.println(getName() + " utilise " + basicAttackName + " et inflige " + damage + " dommages.");
        System.out.println(player2.getName() + " perd " + damage + " points de vie");
        if (damage >= player2.getVitality()) {
            player2.setDead(true);
            System.out.println(player2.getName() + " est mort");
        }
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
        player2.setVitality(player2.getVitality() - damage);
        setVitality(getVitality() - knockback);
        System.out.println(getName() + " utilise " + specialAttackName + " et inflige " + damage + " dommages.");
        System.out.println(player2.getName() + " perd " + damage + " points de vie");
        if (player2.getVitality() <= 0) {
            player2.setDead(true);
            System.out.println(player2.getName() + " est mort");
        }
        System.out.println(getName() + " perd " + knockback + " points de vie");
        if (getVitality() <= 0) {
            setDead(true);
            System.out.println(getName() + " est mort");
        }
    }
}
