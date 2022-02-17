package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestJogo {

    @Test
    public void teste01criarTabuleiro() throws InvalidInitialBoardException {
        GameManager game = new GameManager();
        String playInfo [][] = {{"Pedro"}};
        String[][] board = new String[][]{{"145", "Ole", "java, c", "Purple"}, {"126", "Hello", "python, kotlin", "Blue"}};
        int worldSize = 10;


        game.createInitialBoard(playInfo, worldSize, board);
        assertEquals(Boolean.TRUE,game.createInitialBoard(playInfo, 10, board));

        List<Programmer> programmers = game.getProgrammers(2);
        System.out.println(programmers);

        List<Programmer> programmerInPosition = game.getProgrammers(1);
        System.out.println(programmerInPosition);
    }

    @Test
    public void teste02getImagepng()throws  InvalidInitialBoardException{
        GameManager game = new GameManager();
        String noValue = "";

        game.getImagePng(2);
        assertEquals("",game.getImagePng(2));

    }

    @Test
    public void teste03getImagepng()throws  InvalidInitialBoardException{
        GameManager game = new GameManager();
        String noValue = "";
        game.getImagePng(2);
        assertEquals("",game.getImagePng(2));

    }

}
