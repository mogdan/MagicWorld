package characters;

public class Rogue extends Character {
    public Rogue(String name, int level, int strength, int agility, int intellect) {
        super(name, level, strength, agility, intellect);
        System.out.println("Furtif je suis le Rôdeur " + name + " au niveau " + level + " je possède "
                + getVitality() + " de vitalité, " + strength + " de force, " + agility + " d'agilité et "
                + intellect + " d'intelligence !");
    }

    public static void main(String[] args) {
        Rogue rogue = new Rogue("Joueur 1", 10, 0, 10, 0);
        Rogue rogue1 = new Rogue("Joueur 2", 10, 0, 10, 0);
        rogue.specialAttack(rogue1);
    }

    /**
     * Basic Attack for Rogue
     *
     * @param player2 opponent character
     */
    @Override
    public void basicAttack(Character player2) {
        String basicAttackName = "Tir à l'Arc";
        int damage = this.getAgility();
        player2.setVitality(player2.getVitality() - damage);
        System.out.println(getName() + " utilise " + basicAttackName + " et inflige " + damage + " dommages.");
        System.out.println(player2.getName() + " perd " + damage + " points de vie");
        if (player2.getVitality() <= 0) {
            player2.setDead(true);
            System.out.println(player2.getName() + " est mort");
        }
    }

    /**
     * Special Attack for Rogue
     *
     * @param player2 opponent character
     */
    @Override
    public void specialAttack(Character player2) {
        String specialAttackName = "Concentration";
        int agiStatModifier = getLevel() / 2;
        setAgility(getAgility() + agiStatModifier);
        int agiModified = getAgility();
        System.out.println(getName() + " utilise " + specialAttackName + " et passe à " + agiModified + " en agilité (+" + agiStatModifier + ").");

    }

}
