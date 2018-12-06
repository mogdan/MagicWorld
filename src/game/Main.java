package game;

import characters.Character;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Character[] players = null;
        game.startGame();
        int activePlayer = 0;
        int passivePlayer = 1;
        do {
            game.combatPhase(players[activePlayer], players[passivePlayer]);
            int switchRole = passivePlayer;
            passivePlayer = activePlayer;
            activePlayer = switchRole;
        }
        while (players[0].getVitality() != 0 && players[1].getVitality() != 0);
        if (players[0].getVitality() == 0)
            System.out.println(players[0].getName() + "est mort");
    }

}
