package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor.BLUE;
import static pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor.PURPLE;

public class TestJogo {

    @Test
    public void teste01criarTabuleiro() throws InvalidInitialBoardException {
        GameManager game = new GameManager();
        List<Language> languages = new ArrayList<>();
        languages.add(new Language("Python"));
        languages.add(new Language("Java"));
        String playInfo [][] = {{"1", "Marcos", "Python", "Purple"}, {"2", "Lucas", "Python", "Blue"}};
        String abT[][] = {{"0", "0", "1"}, {"0", "1", "1"}};
        int worldSize = 10;

        //Note: test function createInitialBoard()
        boolean results = game.createInitialBoard(playInfo, worldSize, abT); // Resultado Esperado
        Assert.assertEquals(Boolean.TRUE,results);

        //Note: test function getProgrammers() class Game Manager:
        List<Programmer> programmerInPosition = game.getProgrammers(1); // Resultado Esperado
        assertEquals(1, programmerInPosition.get(0).id);
        assertEquals("Marcos", programmerInPosition.get(0).name);
        assertEquals(1, programmerInPosition.get(0).pos);
        assertEquals(PURPLE, programmerInPosition.get(0).color);

        assertEquals(2, programmerInPosition.get(1).id);
        assertEquals("Lucas", programmerInPosition.get(1).name);
        assertEquals(1, programmerInPosition.get(1).pos);
        assertEquals(BLUE, programmerInPosition.get(1).color);

        //Note: test moveCurrentPlayer() class GM
        boolean move = game.moveCurrentPlayer(1);
        assertEquals(Boolean.TRUE, move);

        //Note: test reactToAbyssOrTool() class GM
        String react = game.reactToAbyssOrTool();
        assertEquals("Tool - You have a new tool", react);

        //Note: test toString() class Programmer
        //Programmer  programmer = new Programmer("Pedro", 1, languages, ProgrammerColor.PURPLE,1);
       //assertEquals("1 | Pedro | 1 | No tools | Python;Java | false", programmer.toString());

        //Note: Test getCurrentPlayerID() class GM
        //int res = game.getCurrentPlayerID();
        //assertEquals(1, res);

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
       List<Language> languages = new ArrayList<>();
       languages.add(new Language("Python"));
       languages.add(new Language("Java"));
        //Programmer  programmer = new Programmer("Pedro", 1, languages, PURPLE,1);
        //assertEquals("1 | Pedro | 1 | No tools |", programmer.toString());
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
