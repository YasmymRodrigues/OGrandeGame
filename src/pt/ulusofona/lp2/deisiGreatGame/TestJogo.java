package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestJogo {

    @Test
    public void teste01criarTabuleiro(){
        GameManager game = new GameManager();
        String[][] board = new String[][]{{"145", "Ole", "java, c", "Purple"}, {"126", "Hello", "python, kotlin", "Blue"}};


        //game.createInitialBoard(board, 5);
        assertEquals("Deveria ser true", true, game.createInitialBoard(board, 5, board));

        List<Programmer> programmers = game.getProgrammers(2);
        System.out.println(programmers);

        List<Programmer> programmerInPosition = game.getProgrammers(1);
        System.out.println(programmerInPosition);


    }

}
