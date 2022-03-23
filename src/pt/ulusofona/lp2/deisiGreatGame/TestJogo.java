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

        Language language1 = new Language("Python");
        Language language1A = new Language("Java");
        ProgrammerColor programmerColor1 = ProgrammerColor.PURPLE;
        List<Language> languages1 = new ArrayList<>();
        languages1.add(language1);

        Programmer programmer1 = new Programmer();
        programmer1.id = 1;
        programmer1.name = "Marcos";
        programmer1.linguagens = languages1;
        programmer1.color = programmerColor1;

        Language language2 = new Language("Python");
        ProgrammerColor programmerColor2 = ProgrammerColor.BLUE;
        List<Language> languages2 = new ArrayList<>();
        languages2.add(language2);
        Programmer programmer2 = new Programmer();
        programmer2.id = 2;
        programmer2.name = "Lucas";
        programmer2.linguagens = languages2;
        programmer2.color = programmerColor2;

        List<Programmer> programmerInThatPosition = new ArrayList<>();
        programmerInThatPosition.add(programmer1);
        programmerInThatPosition.add(programmer2);

        boolean results = game.createInitialBoard(playInfo, worldSize, abT);
        Assert.assertEquals(Boolean.TRUE,results);

        List<Programmer> programmerInPosition = game.getProgrammers(1);
        Assert.assertEquals(programmerInThatPosition, programmerInPosition);
    }

    @Test
    public void teste02getImagepng()throws  InvalidInitialBoardException{
        GameManager game = new GameManager();
        File file = new File("images");
        String noValue = "src/images";

        game.getImagePng(2);
        assertEquals(noValue,game.getImagePng(2));
        //C:\Users\Asus\IdeaProjects\OGrandeGame\lib\LP2-GuiViewer2122-p2-1.0.2.jar!\images
    }

    @Test
    public void teste03getImagepng()throws  InvalidInitialBoardException{
        GameManager game = new GameManager();
        String noValue = "";
        game.getImagePng(2);
        assertEquals("",game.getImagePng(2));

    }
   @Test
    public void teste04getCurrentPlayerID() throws InvalidInitialBoardException {
        GameManager game = new GameManager();
        game.getCurrentPlayerID();
        int res = game.getCurrentPlayerID();
    }

    @Test
    public void test05toStringProgrammers() throws InvalidObjectException{
        Programmer  programmer = new Programmer();
        assertEquals("" + programmer.id +" | "+ programmer.name +" | "+ programmer.pos +" | "+ "No tools " +" | "+ programmer.linguagens + "", programmer.toString());
    }
    @Test
    public void test06getProgrammers() throws InvalidObjectException{
        GameManager game = new GameManager();
        List<Programmer> programmers = game.getProgrammers(1);
        assertEquals("Joaquim", programmers.get(0).name);

    }

    @Test
    public void test07converteArrayToString() throws InvalidObjectException{
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
