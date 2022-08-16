package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;

import java.util.ArrayList;
import java.util.List;

public class VamosFazerContas extends Abismo{
    public VamosFazerContas(int id, int pos) {
        super(id, pos);
    }

    @Override
    public boolean isAbismo() {
        return true;
    }

    @Override
    public int getReact(int pos, Programmer programmer) {
        //casa que é a média das 3 pos anteriores arredondo para cima
        //se não tiver 3pos pega as que existe
        List<Integer> posicoes = programmer.getPosicoes();

        int avg = 0;

        if (posicoes.size() <= 3) {

            for (Integer position : posicoes) {
                avg += position; // Sum up all elements
            }
            int resultFirstDiv = avg/3; // Divide by 3
            int resultSecondDiv = resultFirstDiv / 3;
            int finalRes = Math.round(resultSecondDiv);

            return finalRes;

        }else {

            avg = (posicoes.get(posicoes.size() - 1)) +
                    (posicoes.get(posicoes.size() - 2)) +
                    (posicoes.get(posicoes.size() - 3));
            int resultFirstDiv = avg/3;
            int resultSecondDiv = resultFirstDiv/3;
            int finalRes = Math.round(resultSecondDiv);

            return finalRes;
        }

    }

}
