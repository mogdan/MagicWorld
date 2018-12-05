package characters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
        assert (warrior.getLife() == 50);
        assertEquals("Woarg je suis le Guerrier Joueur 1 au niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void Given_basicAttack_When_attackPhase_Then_okDmgeResults() {
        Warrior warrior1 = new Warrior("Joueur 1", 10, 10, 0, 0);
        Warrior warrior2 = new Warrior("Joueur 2", 10, 10, 0, 0);
        warrior1.basicAttack(warrior2);
        assertTrue(warrior1.getLife()==50);
        assertTrue(warrior2.getLife()==40);
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
        assertTrue(warrior1.getLife()==45);
        assertTrue(warrior2.getLife()==30);
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

}

