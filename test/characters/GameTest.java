package characters;

import game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void Given_chooseWarrior_When_classSelection_Then_WarriorResult() {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        Game game = new Game();
        int choice = game.characterSelection();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", output[0]);
        assertTrue(choice == 1);
    }

    @Test
    public void Given_chooseRogue_When_classSelection_Then_RogueResult() {
        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        Game game = new Game();
        int choice = game.characterSelection();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", output[0]);
        assertTrue(choice == 2);
    }

    @Test
    public void Given_chooseMage_When_classSelection_Then_MageResult() {
        System.setIn(new ByteArrayInputStream("3\n".getBytes()));
        Game game = new Game();
        int choice = game.characterSelection();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", output[0]);
        assertTrue(choice == 3);
    }

    @Test
    public void Given_correctValue_When_strengthStatSelection_Then_OkResult() {
        System.setIn(new ByteArrayInputStream("10\n".getBytes()));
        Game game = new Game();
        int choice = game.statSelection(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Force du personnage?", output[0]);
        assertTrue(choice == 10);
    }

    @Test
    public void Given_correctValue_When_warriorCreation_Then_OkResult() {
        Game game = new Game();
        game.characterCreation(1, "Joueur 1", 10, 10, 0, 0);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Woarg je suis le Guerrier Joueur 1 au niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !", output[0]);
    }
}
