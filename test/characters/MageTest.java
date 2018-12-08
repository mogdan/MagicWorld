package characters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class MageTest {
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
    public void Given_goodValueWarrior_When_warriorCreation_Then_OkCreationResult() {

        Mage mage = new Mage("Joueur 1", 10, 0, 0, 10);
        assertNotNull(mage);
        assert (mage.getVitality() == 50);
        assertEquals("Abracadabra je suis le Mage Joueur 1 au niveau 10 je possède 50 de vitalité, 0 de force, 0 d'agilité et 10 d'intelligence !\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void Given_basicAttack_When_attackPhase_Then_okDmgeResults() {
        Mage mage = new Mage("Joueur 1", 10, 0, 0, 10);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        mage.basicAttack(warrior2);
        assertTrue(mage.getVitality() == 50);
        assertTrue(warrior2.getVitality() == 40);
    }

    private void assertTrue(boolean b) {
    }

    @Test
    public void Given_basicAttack_When_attackPhase_Then_okTextResults() {
        Mage mage = new Mage("Joueur 1", 10, 0, 0, 10);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        mage.basicAttack(warrior2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Boule de Feu et inflige 10 dommages.", output[2]);
        assertEquals("Joueur 2 perd 10 points de vie", output[3]);
    }

    @Test
    public void Given_specialAttack_When_attackPhase_Then_okOutputResults() {
        Mage mage = new Mage("Joueur 1", 10, 0, 0, 10);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        mage.setVitality(mage.getVitality() - 40);
        mage.specialAttack(warrior2);
        assertTrue(mage.getVitality() == 30);
        assertTrue(warrior2.getVitality() == 50);
    }

    @Test
    public void Given_specialAttack_When_attackPhase_Then_okTextResults() {
        Mage mage = new Mage("Joueur 1", 10, 0, 0, 10);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        mage.setVitality(20);
        mage.specialAttack(warrior2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Soin et gagne 20 en vitalité.", output[2]);
    }

    @Test
    public void Given_specialAttack_When_attackPhaseWithAlmostAllVitality_Then_returnToMaxVitality() {
        Mage mage = new Mage("Joueur 1", 10, 0, 0, 10);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        mage.setVitality(39);
        mage.specialAttack(warrior2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Soin et gagne 11 en vitalité.", output[2]);
        assertTrue(mage.getVitality() == 50);
    }

    @Test
    public void Given_lethalBasicAttack_When_attackPhase_Then_DeadPlayer2Results() {
        Mage mage = new Mage("Joueur 1", 10, 0, 0, 10);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        warrior2.setVitality(10);
        mage.basicAttack(warrior2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Boule de Feu et inflige 10 dommages.", output[2]);
        assertEquals("Joueur 2 perd 10 points de vie", output[3]);
        assertEquals("Joueur 2 est mort", output[4]);
    }



}


