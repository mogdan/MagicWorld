package characters;

public class Rogue extends Character {
    public Rogue(String name, int level, int strength, int dexterity, int intellect) {
        super(name, level, strength, dexterity, intellect);
        System.out.println("Furtif je suis le Rôdeur " + name + " au niveau " + level + " je possède "
                + getLife() + " de vitalité, " + strength + " de force, " + dexterity + " d'agilité et "
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
        int damage = this.getDexterity();
        player2.setLife(player2.getLife() - damage);
        System.out.println(getName() + " utilise " + basicAttackName + " et inflige " + damage + " dommages.");
        System.out.println(player2.getName() + " perd " + damage + " points de vie");
    }

    /**
     * Special Attack for Rogue
     *
     * @param player2 opponent character
     */
    @Override
    public void specialAttack(Character player2) {
        String specialAttackName = "Concentration";
        int dextStatModifier = getLevel() / 2;
        setDexterity(getDexterity() + dextStatModifier);
        int dextModified = getDexterity();
        System.out.println(getName() + " utilise " + specialAttackName + " et passe à " + dextModified + " en agilité (+" + dextStatModifier + ").");
    }

}
