package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestJogo {

    @Test
    public void teste01criarTabuleiro(){
        GameManager game = new GameManager();
        String[][] board = new String[][]{{"145", "Ole", "java, c", "Purple"}, {"126", "Hello", "python, kotlin", "Blue"}};

        //game.createInitialBoard(board, 5);
        assertEquals("Deveria ser true", true, game.createInitialBoard(board, 5));

        ArrayList<Programmer> programmers = game.getProgrammers();
        System.out.println(programmers);

        ArrayList<Programmer> programmerInPosition = game.getProgrammers(1);
        System.out.println(programmerInPosition);


    }

}
