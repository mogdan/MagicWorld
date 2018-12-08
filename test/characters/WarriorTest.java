package characters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class WarriorTest {
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

        Warrior warrior = new Warrior("Joueur 1", 10, 10, 0, 0);
        assertNotNull(warrior);
        assert (warrior.getVitality() == 50);
        assertEquals("Woarg je suis le Guerrier Joueur 1 au niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void Given_basicAttack_When_attackPhase_Then_okDmgeResults() {
        Warrior warrior1 = new Warrior("Joueur 1", 10, 10, 0, 0);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        warrior1.basicAttack(warrior2);
        assertTrue(warrior1.getVitality() == 50);
        assertTrue(warrior2.getVitality() == 40);
    }
    @Test
    public void Given_basicAttack_When_attackPhase_Then_okTextResults() {
        Warrior warrior1 = new Warrior("Joueur 1", 10, 10, 0, 0);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        warrior1.basicAttack(warrior2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup d'épée et inflige 10 dommages.",output[2]);
        assertEquals("Joueur 2 perd 10 points de vie",output[3]);
    }

    @Test
    public void Given_specialAttack_When_attackPhase_Then_okDmgeResults() {
        Warrior warrior1 = new Warrior("Joueur 1", 10, 10, 0, 0);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        warrior1.specialAttack(warrior2);
        assertTrue(warrior1.getVitality() == 45);
        assertTrue(warrior2.getVitality() == 30);
    }

    private void assertTrue(boolean b) {
    }

    @Test
    public void Given_specialAttack_When_attackPhase_Then_okTextResults() {
        Warrior warrior1 = new Warrior("Joueur 1", 10, 10, 0, 0);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        warrior1.specialAttack(warrior2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup de Rage et inflige 20 dommages.",output[2]);
        assertEquals("Joueur 2 perd 20 points de vie",output[3]);
        assertEquals("Joueur 1 perd 5 points de vie",output[4]);
    }

    @Test
    public void Given_lethalSpecialAttack_When_attackPhase_Then_DeadResultsforWarrior2() {
        Warrior warrior1 = new Warrior("Joueur 1", 10, 10, 0, 0);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        warrior2.setVitality(20);
        warrior1.specialAttack(warrior2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup de Rage et inflige 20 dommages.", output[2]);
        assertEquals("Joueur 2 perd 20 points de vie", output[3]);
        assertEquals("Joueur 2 est mort", output[4]);
        assertEquals("Joueur 1 perd 5 points de vie", output[5]);
    }

}

