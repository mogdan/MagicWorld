package characters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RogueTest {
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
    public void Given_goodValueRogue_When_rogueCreation_Then_OkCreationResult() {

        Rogue rogue = new Rogue("Joueur 1", 10, 0, 10, 0);
        assertNotNull(rogue);
        assert (rogue.getLife() == 50);
        assertEquals("Furtif je suis le Rôdeur Joueur 1 au niveau 10 je possède 50 de vitalité, 0 de force, 10 d'agilité et 0 d'intelligence !\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void Given_basicAttack_When_attackPhase_Then_okDmgeResults() {
        Rogue rogue = new Rogue("Joueur 1", 10, 0, 10, 0);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        rogue.basicAttack(warrior2);
        assertTrue(rogue.getLife() == 50);
        assertTrue(warrior2.getLife() == 40);
    }

    @Test
    public void Given_basicAttack_When_attackPhase_Then_okTextResults() {
        Rogue rogue = new Rogue("Joueur 1", 10, 0, 10, 0);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        rogue.basicAttack(warrior2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Tir à l'Arc et inflige 10 dommages.", output[2]);
        assertEquals("Joueur 2 perd 10 points de vie", output[3]);
    }

    @Test
    public void Given_specialAttack_When_attackPhase_Then_okOutputResults() {
        Rogue rogue = new Rogue("Joueur 1", 10, 0, 10, 0);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        rogue.specialAttack(warrior2);
        assertTrue(rogue.getDexterity() == 15);
    }

    @Test
    public void Given_specialAttack_When_attackPhase_Then_okTextResults() {
        Rogue rogue = new Rogue("Joueur 1", 10, 0, 10, 0);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        rogue.specialAttack(warrior2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Concentration et passe à 15 en agilité (+5).", output[2]);
    }


}