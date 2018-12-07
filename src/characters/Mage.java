package characters;

public class Mage extends Character {
    public Mage(String name, int level, int strength, int agility, int intellect) {
        super(name, level, strength, agility, intellect);
        System.out.println("Abracadabra je suis le Mage " + name + " au niveau " + level + " je possède "
                + getVitality() + " de vitalité, " + strength + " de force, " + agility + " d'agilité et "
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
        player2.setVitality(player2.getVitality() - damage);
        System.out.println(getName() + " utilise " + basicAttackName + " et inflige " + damage + " dommages.");
        System.out.println(player2.getName() + " perd " + damage + " points de vie");
        if (damage >= player2.getVitality()) {
            player2.setDead(true);
            System.out.println(player2.getName() + " est mort");
        }
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
        if (soin + getVitality() > getLevel() * 5)
            soin = 50 - getVitality();
        setVitality(getVitality() + soin);
        System.out.println(getName() + " utilise " + specialAttackName + " et gagne " + soin + " en vitalité.");

    }

}
