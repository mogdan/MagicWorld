package characters;

public class Mage extends Character {
    public Mage(String name, int level, int strength, int dexterity, int intellect) {
        super(name, level, strength, dexterity, intellect);
        System.out.println("Abracadabra je suis le Mage " + name + " au niveau " + level + " je possède "
                + getLife() + " de vitalité, " + strength + " de force, " + dexterity + " d'agilité et "
                + intellect + " d'intelligence !");
    }


    /**
     * Basic Attack for Mage
     *
     * @param player2 opponent character
     */
    @Override
    public void basicAttack(Character player2) {
        String basicAttackName = "Boule de Feu";
        int damage = this.getIntellect();
        player2.setLife(player2.getLife() - damage);
        System.out.println(getName() + " utilise " + basicAttackName + " et inflige " + damage + " dommages.");
        System.out.println(player2.getName() + " perd " + damage + " points de vie");
    }

    /**
     * Special Attack for Mage
     *
     * @param player2 opponent character
     */
    @Override
    public void specialAttack(Character player2) {
        String specialAttackName = "Soin";
        int soin = getIntellect() * 2;
        setLife(getLife() + soin);
        System.out.println(getName() + " utilise " + specialAttackName + " et gagne " + soin + " en vitalité.");
    }

}
