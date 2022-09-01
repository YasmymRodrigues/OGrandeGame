package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.deisiGreatGame.tools.Ferramenta;
import pt.ulusofona.lp2.deisiGreatGame.tools.Heranca;
import pt.ulusofona.lp2.deisiGreatGame.tools.IDE;

import java.io.File;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor.*;

public class TestJogo {

    @Test
    public void teste01criarTabuleiro() throws InvalidInitialBoardException {
        GameManager game = new GameManager();
        List<Language> languages = new ArrayList<>();
        languages.add(new Language("Python"));
        languages.add(new Language("Java"));
        String playInfo [][] = {{"1", "Marcos", "Python", "Purple"}, {"2", "Lucas", "Python", "Blue"}, {"3", "Paulo", "Python", "Green"}};
        //String abT[][] = {{"0", "1", "2"}, {"0", "1", "6"}, {"0", "1", "7"}};
        String abT[][] = {{"0", "2", "5"}, {"0", "2", "11"}, {"0", "2", "10"}};
        //String abT[][] = {{"0", "10", "5"}, {"0", "10", "11"}, {"0", "10", "10"}};
        int worldSize = 20;
        ArrayList<Integer> posicoes = new ArrayList<>();
        posicoes.add(1);
        //posicoes.add(4);
        //posicoes.add(5);

        //Note: test function createInitialBoard()
        game.createInitialBoard(playInfo, worldSize, abT); // Resultado Esperado
        //Assert.assertEquals(void , results);
        Ferramenta ferramenta = new IDE( 1, 1);

        //Note: test function getProgrammers() class Game Manager:
        List<Programmer> programmerInPosition = game.getProgrammers(1); // Resultado Esperado
        for (Programmer programmer: programmerInPosition){
            programmer.setPosicoes(posicoes);
        }

        assertEquals(1, programmerInPosition.get(0).id); //ID
        assertEquals("Marcos", programmerInPosition.get(0).name); //NAME
        assertEquals(1, programmerInPosition.get(0).pos); //POS
        assertEquals(PURPLE, programmerInPosition.get(0).color); //COLOR
        assertEquals(posicoes, programmerInPosition.get(0).posicoes);
        //assertEquals("Heranca", programmerInPosition.get(0).ferramentas);

        assertEquals(2, programmerInPosition.get(1).id); //ID
        assertEquals("Lucas", programmerInPosition.get(1).name); //NAME
        assertEquals(1, programmerInPosition.get(1).pos); //POS
        assertEquals(BLUE, programmerInPosition.get(1).color); //COLOR
        assertEquals(posicoes, programmerInPosition.get(1).posicoes);

        assertEquals(3, programmerInPosition.get(2).id); //ID
        assertEquals("Paulo", programmerInPosition.get(2).name); //NAME
        assertEquals(1, programmerInPosition.get(1).pos); //POS
        assertEquals(GREEN, programmerInPosition.get(2).color); //COLOR
        assertEquals(posicoes, programmerInPosition.get(2).posicoes);

        //Note: Test getCurrentPlayerID() class GM
        /*int res = game.getCurrentPlayerID();
        assertEquals(1, res);
        game.changeTurn();
        int res2 = game.getCurrentPlayerID();
        assertEquals(2, res2);
        game.changeTurn();
        int res3 = game.getCurrentPlayerID();
        assertEquals(3, res3);
        game.changeTurn();
        int res1 = game.getCurrentPlayerID();
        assertEquals(1, res1);*/
        /*game.changeTurn();*/

        //Note: moveCurrentPlayer() movimentos antes de salvar
        Boolean move = game.moveCurrentPlayer(1);
        assertEquals(true, move);

        //Note: saveGame()
        Boolean save = game.saveGame(new File("C:\\Users\\Asus\\IdeaProjects\\OGrandeGame\\Jogo.txt"));
        assertTrue("retornou true", save);

        //Note: loadGame()
        Boolean load = game.loadGame(new File("C:\\Users\\Asus\\IdeaProjects\\OGrandeGame\\Jogo.txt"));
        assertTrue("load com sucesso", load);

        //Note: moveCurrentPlayer() movimentos depois de realizar o load
        Boolean moveToNull = game.moveCurrentPlayer(3);
        assertTrue("not null", moveToNull);

        //Note: React
        String react = game.reactToAbyssOrTool();
        assertNotNull( "trap", react);

        //Note: getProgrammersInfo()
        String result = game.getProgrammersInfo();
        //String result2 = programmerInPosition.toString();
        //assertEquals("1 | Marcos | 6 | Heranca | Python | Em Jogo," + " 2 | Lucas | 1 | Heranca | Python | Em Jogo," + " 3 | Paulo | 1 | Heranca | Python | Em Jogo", result);

        //Note: test toString() class Programmer
        //int id, String name, int pos, List<Ferramenta> ferramentas, List<Language> languages, ProgrammerColor color, List<Integer> posicoes
        /*List<Ferramenta> ferramentas = new ArrayList<>();
        Ferramenta ferramenta = new Ferramenta("Heranca");
        ferramentas.add();*/
        //Programmer  programmer = new Programmer(1, "Bruno", 1, languages, ProgrammerColor.PURPLE,1);
        //Programmer programmer = new Programmer();
        //assertEquals("1 | Marcos | 1 | Heranca | Python;Java | Em jogo", programmer.toString());


        //game.getImagePng(2);
        //assertEquals("blank.png",game.getImagePng(2));


        //assertEquals(programmer, game.changeTurn());

    }

   /* @Test
    public void teste02getImagepng()throws  InvalidInitialBoardException{
        GameManager game = new GameManager();
        game.getImagePng(2);
        assertEquals("blank.png",game.getImagePng(2));

    }*/
  /* @Test
    public void teste03getCurrentPlayerID() throws InvalidInitialBoardException {
        GameManager game = new GameManager();
        int res = game.getCurrentPlayerID();
        assertEquals(1, res);
    }*/


   @Test
    public void test04toStringProgrammers() throws InvalidObjectException{
       List<Language> languages = new ArrayList<>();
       languages.add(new Language("Python"));
       languages.add(new Language("Java"));
       List<Integer> posicoes = new ArrayList<>();
       //return "" + id +" | "+ name +" | "+ pos +" | "+ ferramentas +"| "+ converteArrayParaString(languages) + " | " + getStatus();
        //Programmer  programmer = new Programmer("Pedro", 1, languages, "Purple", posicoes);
        //assertEquals("1 | Pedro | 1 | Herança | Python; Java | Em jogo", programmer.toString());
    }

    @Test
    public void test05converteArrayToString() throws InvalidObjectException{
        Programmer programmer = new Programmer();
        List<Language> languages = new ArrayList<>();
        languages.add(new Language("Python"));
        languages.add(new Language("Java"));

        assertEquals("Python; Java", programmer.converteArrayParaString(languages));
    }


}
