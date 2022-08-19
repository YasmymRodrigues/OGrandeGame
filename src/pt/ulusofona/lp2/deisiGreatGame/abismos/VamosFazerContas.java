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

        double avg = 0.0;
        int finalRes = 0;
        int count = 0;

        for (int i = 2; i < 5; i++){
            if (posicoes.size() >= i){
                avg += posicoes.get(posicoes.size() - i);
                count ++;
            }
        }
        double valueFD = avg;
        double valueSD = valueFD / count;
        finalRes = (int)Math.ceil(valueSD);

        return finalRes;
    }

    @Override
    public String toString() {
        return "Vamos Fazer Contas";
    }

}
