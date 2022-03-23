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

        //Note: test function getProgrammers:
        List<Programmer> programmerInPosition = game.getProgrammers(1); // Resultado Esperado
        assertEquals("Marcos", programmerInPosition.get(0).name);

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
        game.getCurrentPlayerID();
        int res = game.getCurrentPlayerID();
    }

    @Test
    public void test04toStringProgrammers() throws InvalidObjectException{
        Programmer  programmer = new Programmer();
        assertEquals("" + programmer.id +" | "+ programmer.name +" | "+ programmer.pos +" | "+ "No tools " +" | "+ programmer.linguagens + "", programmer.toString());
    }

    @Test
    public void test05converteArrayToString() throws InvalidObjectException{
        Programmer programmer = new Programmer();
        List<Language> lang = programmer.getLinguagens();
        Language language1 = new Language("Python");
        Language language2 = new Language("Java");
        Language language3 = new Language("Python");
        List<Language> languages = new ArrayList<>();
        languages.add(language1);
        languages.add(language2);
        languages.add(language3);
        programmer.converteArrayParaString(languages);
        assertEquals("Python", languages.get(0).nome);


    }
}
