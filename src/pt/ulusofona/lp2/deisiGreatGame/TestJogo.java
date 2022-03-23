package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestJogo {

    @Test
    public void teste01criarTabuleiro() throws InvalidInitialBoardException {
        GameManager game = new GameManager();
        String playInfo [][] = {{"1", "Marcos", "Python", "Purple"}, {"2", "Lucas", "Python", "Blue"}};
        String abT[][] = {{"1", "1", "5"}};
        int worldSize = 10;

        boolean results = game.createInitialBoard(playInfo, worldSize, abT); // Resultado Esperado
        Assert.assertEquals(Boolean.TRUE,results);

        //Note: test function getProgrammers() class Game Manager:
        List<Programmer> programmerInPosition = game.getProgrammers(1); // Resultado Esperado
        assertEquals("Marcos", programmerInPosition.get(0).name);

        //Note: test toString() class Programmer
       /* Programmer  programmer = new Programmer();
        assertEquals("" + programmer.id +" | "+ programmer.name +" | "+ programmer.pos +" | "+ "No tools " +" | "+ programmer.linguagens + "", programmer.toString());
*/
        int res = game.getCurrentPlayerID();
        assertEquals(1, res);

    }

    @Test
    public void teste02getImagepng()throws  InvalidInitialBoardException{
        GameManager game = new GameManager();
        game.getImagePng(2);
        assertEquals("blank.png",game.getImagePng(2));

    }
   @Test
    public void teste03getCurrentPlayerID() throws InvalidInitialBoardException {
        GameManager game = new GameManager();
        int res = game.getCurrentPlayerID();
        assertEquals(1, res);
    }

   @Test
    public void test04toStringProgrammers() throws InvalidObjectException{
        Programmer  programmer = new Programmer("Pedro", 1, ProgrammerColor.PURPLE,1);
        assertEquals("1 | Pedro | 1 | No tools |", programmer.toString());
    }

    @Test
    public void test05converteArrayToString() throws InvalidObjectException{
        Programmer programmer = new Programmer();
        List<Language> languages = new ArrayList<>();
        languages.add(new Language("Python"));
        languages.add(new Language("Java"));

        assertEquals("Python;Java;", programmer.converteArrayParaString(languages));


    }
}
