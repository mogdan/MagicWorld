package game;

import exception.CharacterCreationException;

public class Main {

    public static void main(String[] args) throws CharacterCreationException {
        Game game = new Game();
        game.startGame();
    }

}
