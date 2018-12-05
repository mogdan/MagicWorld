package characters;

import exception.CharacterCreationException;

public class Character {
    private String name;
    private int level;
    private int life;
    private int strength;
    private int dexterity;
    private int intellect;

    public Character(String name,int level, int strength, int dexterity, int intellect) {
        //Test on creation if the statictics match the character's level
        if (strength+dexterity+intellect!=level){
            System.out.println("La valeur cumulée de vos statistiques de force, agilité et endurant ne correspondent pas avec votre niveau");
            throw new CharacterCreationException();
        }
        this.name=name;
        this.level = level;
        this.life = level*5;
        this.strength = strength;
        this.dexterity = dexterity;
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

    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
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

    public void setLife(int life) {
        this.life = life;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

}
