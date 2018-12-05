package game;

import characters.Mage;
import characters.Rogue;
import characters.Warrior;

import java.util.Scanner;

public class Game {

    Scanner sc = new Scanner(System.in);

    public void startGame() {
        System.out.println("**********************************************************************");
        System.out.println("**********************************************************************");
        System.out.println("Bienvenue à MagicWorl! Le jeu des combats épiques!");
        System.out.println("**********************************************************************");
        System.out.println("**********************************************************************");
        System.out.println("Création des personnages");
    }

    private void characterCreation(String playerName) {
        System.out.println("Veuillez choisir la classe de personnage du Joueur 1 (1 : Guerrier, 2 : Rôdeur, 3 : Mage");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Warrior player = new Warrior(playerName, 0, 0, 0, 0, );
                break;
            case 2:
                Rogue player = new Rogue(playerName, 0, 0, 0, 0, );
                break;
            case 3:
                Mage player = new Mage(playerName, 0, 0, 0, 0, );
                break;
            default:
                System.out.println("Vous n'avez pas choisi de personnages dans la liste proposée!");
                break;


        }


    }
}
