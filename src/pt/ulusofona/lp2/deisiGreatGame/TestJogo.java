package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.io.InvalidObjectException;
import java.util.List;

import static org.junit.Assert.*;

public class TestJogo {

    @Test
    public void teste01criarTabuleiro() throws InvalidInitialBoardException {
        GameManager game = new GameManager();
        String playInfo [][] = {{"1", "Marcos", "Python; Java", "Purple"}};
        //String[][] board = new String[][]{{"1123", "Ole", "java, c", "Purple"}, {"126", "Hello", "python, kotlin", "Blue"}};
        String abT[][] = {{"1", "1", "5"}};
        int worldSize = 10;


        game.createInitialBoard(playInfo, worldSize, abT);
        assertEquals(Boolean.TRUE,game.createInitialBoard(playInfo, 10, abT));

//        List<Programmer> programmers = game.getProgrammers(5);
//        System.out.println(programmers);

        List<Programmer> programmerInPosition = game.getProgrammers(0);
        System.out.println(programmerInPosition);
    }

   /* @Test
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

    }*/
   /* @Test
    public void teste04getCurrentPlayerID() throws InvalidInitialBoardException {
        GameManager game = new GameManager();
        game.getCurrentPlayerID();
        int res = game.getCurrentPlayerID();
    }*/

    @Test
    public void test05toStringProgrammers() throws InvalidObjectException{
        Programmer  programmer = new Programmer();
        assertEquals("" + programmer.id +" | "+ programmer.name +" | "+ programmer.pos +" | "+ "No tools " +" | "+ programmer.linguagens + "", programmer.toString());
    }
    @Test
    public void test06getProgrammers() throws InvalidObjectException{
        Programmer programmer = new Programmer();

    }
}
