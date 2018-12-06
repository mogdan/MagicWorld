package characters;

public class Character {
    private String name;
    private int level;
    private int vitality;
    private int strength;
    private int agility;
    private int intellect;

    public Character(String name, int level, int strength, int agility, int intellect) {

        this.name=name;
        this.level = level;
        this.vitality = level * 5;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;

    }

    /**
     * Do a basicAttack
     * @return result output of the basic Attack
     */
    public void basicAttack(Character player2){

    }

    /**
     * Do a special attack
     * @return result output of the special Attack
     */
    public void specialAttack(Character player2){

    }

    public int getLevel() {
        return level;
    }

    public int getVitality() {
        return vitality;
    }

    public int getStrength() {
        return strength;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getIntellect() {
        return intellect;
    }

    public String getName() {
        return name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAgility() {
        return agility;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

}
