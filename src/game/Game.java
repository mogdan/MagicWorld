package game;

import characters.Character;
import characters.Mage;
import characters.Rogue;
import characters.Warrior;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    Scanner sc = new Scanner(System.in);
    Character[] players = new Character[2];
    Character loser;

    /**
     * Game initializer - Characters creation
     *
     */
    public void startGame() {
        System.out.println("**********************************************************************");
        System.out.println("**********************************************************************");
        System.out.println("Bienvenue à MagicWorld! Le jeu de combat épique!");
        System.out.println("**********************************************************************");

        System.out.println("**********************************************************************");
        System.out.println("Création des personnages");

        for (int i = 0; i < players.length; i++) {
            int classChoice;
            int levelChoice;
            int strengthChoice;
            int agilityChoice;
            int intellectChoice;
            boolean correctStatSelection = true;
            String playerName = "Joueur " + (i + 1);
            classChoice = characterSelection();
            do {
                levelChoice = statSelection(0);
                strengthChoice = statSelection(1);
                agilityChoice = statSelection(2);
                intellectChoice = statSelection(3);
                int totalStats = strengthChoice + agilityChoice + intellectChoice;
                if (totalStats != levelChoice) {
                    correctStatSelection = false;
                    System.out.println("************************************************************************************************************************");
                    System.out.println("La somme des statistiques (" + totalStats + ") ne correspond pas avec le niveau (" + levelChoice + ") du personnage. Veuillez recommencer le choix des statistiques");
                } else {
                    correctStatSelection = true;
                }
            } while (!correctStatSelection);
            players[i] = characterCreation(classChoice, playerName, levelChoice, strengthChoice, agilityChoice, intellectChoice);
        }
    }

    /**
     * Character class selection
     *
     * @return the class selected (1:Warrior, 2:Rogue, 3:Mage)
     */
    public int characterSelection() {
        boolean goodInput;
        int classChoice = 0;
        do {
            try {
                System.out.println("Veuillez choisir la classe de personnage du Joueur 1 (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
                classChoice = sc.nextInt();
                goodInput = (classChoice >= 1 && classChoice <= 3);
            } catch (InputMismatchException e) {
                sc.next();
                goodInput = false;
            }
        } while (!goodInput);
        return classChoice;
    }

    /**
     * Set a stat value
     *
     * @param statType type of stat desired to get contextual text
     * @return value of the stat returned
     */
    public int statSelection(int statType) {
        boolean goodInput;
        int statValue = 0;
        String[] questions = new String[4];
        questions[0] = "Niveau du personnage?";
        questions[1] = "Force du personnage?";
        questions[2] = "Agilité du personnage?";
        questions[3] = "Intelligence du personnage?";
        do {
            try {
                System.out.println(questions[statType]);
                statValue = sc.nextInt();
                goodInput = (statValue >= 0);
            } catch (InputMismatchException e) {
                sc.next();
                goodInput = false;
            }
        } while (!goodInput);
        return statValue;
    }

    /**
     * Character constructor for gameStart
     *
     * @param classChoice     class selected by player
     * @param playerName      auto increment class name for player
     * @param levelChoice     level selected by player
     * @param strengthChoice  strength selected by player
     * @param agilityChoice   agility selected by player
     * @param intellectChoice intellect selected by player
     * @return Character for player
     */
    public Character characterCreation(int classChoice, String playerName, int levelChoice, int strengthChoice, int agilityChoice, int intellectChoice) {
        if (classChoice == 1) {
            Warrior warrior = new Warrior(playerName, levelChoice, strengthChoice, agilityChoice, intellectChoice);
            return warrior;
        } else if (classChoice == 2) {
            Rogue rogue = new Rogue(playerName, levelChoice, strengthChoice, agilityChoice, intellectChoice);
            return rogue;
        } else if (classChoice == 3) {
            Mage mage = new Mage(playerName, levelChoice, strengthChoice, agilityChoice, intellectChoice);
            return mage;
        } else return null;
    }

    /**
     * Combat phase for active Player
     *
     * @param activePlayer  Player on the offensive side
     * @param passivePlayer Player on the defensive side
     */
    public void combatPhase(Character activePlayer, Character passivePlayer) {
        boolean goodInput;
        int attackChoice = 0;
        do {
            try {
                System.out.println(activePlayer.getName() + " (" + activePlayer.getVitality() + " Vitalité) veuillez" +
                        "choisir votre action ( 1: Attaque Basique , 2: Attaque Spéciale )");
                attackChoice = sc.nextInt();
                goodInput = (attackChoice == 1 || attackChoice == 2);
            } catch (InputMismatchException e) {
                System.out.println("Veuillez choisir une attaque parmi celle proposée!");
                goodInput = false;
            }
        } while (!goodInput);
        if (attackChoice == 1)
            activePlayer.basicAttack(passivePlayer);
        else {
            activePlayer.specialAttack(passivePlayer);
        }
    }

    /**
     * Method to play all turns and switch active/passive player. It stops when one player is dead
     * and return the loser on terminal
     */
    public void doTurn() {
        int activePlayer = 0;
        int passivePlayer = 1;
        boolean hasLoser = false;
        do {
            combatPhase(players[activePlayer], players[passivePlayer]);
            int switchRole = passivePlayer;
            passivePlayer = activePlayer;
            activePlayer = switchRole;
            if (players[activePlayer].isDead()) {
                System.out.println(players[activePlayer].getName() + " a perdu!");
                hasLoser = true;
            }
            if (players[passivePlayer].isDead()) {
                System.out.println(players[passivePlayer].getName() + " a perdu!");
                hasLoser = true;
            }
        }
        while (!hasLoser);

    }

}




