package game;

import characters.Character;
import characters.Mage;
import characters.Rogue;
import characters.Warrior;
import exception.CharacterCreationException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    Scanner sc = new Scanner(System.in);
    Character[] players = new Character[2];

    /**
     * Game initializer
     *
     * @throws CharacterCreationException
     */
    public void startGame() throws CharacterCreationException {
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
                if (strengthChoice + agilityChoice + intellectChoice != levelChoice)
                    correctStatSelection = false;
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
        boolean goodInput = true;
        int classChoice = 0;
        System.out.println("Veuillez choisir la classe de personnage du Joueur 1 (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        do {
            try {
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
        boolean goodInput = true;
        int statValue = 0;
        String[] questions = new String[4];
        questions[0] = "Niveau du personnage?";
        questions[1] = "Force du personnage?";
        questions[2] = "Agilité du personnage?";
        questions[3] = "Intelligence du personnage?";
        System.out.println(questions[statType]);
        do {
            try {
                statValue = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextInt();
                goodInput = false;
            }
        } while (!goodInput);
        return statValue;
    }


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
}


