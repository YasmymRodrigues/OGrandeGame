package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;
import pt.ulusofona.lp2.deisiGreatGame.tools.Ferramenta;

import java.util.ArrayList;
import java.util.List;

public class ErroDeLogica extends Abismo{
    public ErroDeLogica(int id, int pos) {
        super(id, pos);
    }

    @Override
    public boolean isAbismo() {
        return true;
    }

    @Override
    public int getReact(int pos, Programmer programmer) {
        int newPosition;
        for (Ferramenta ferramenta: programmer.getFerramentas()){
            if (ferramenta.getId() == 5){ //Ajuda do professor
                return pos;
            }
        }
        if (pos > 1){
            //get current pos - the last pos = nrSpace
            int currentPos = programmer.getPos();
            List<Integer> posicoes = programmer.getPosicoes();
            int lastPos = posicoes.get(posicoes.size() - 2);
            //get dice value
            int dice = currentPos - lastPos;
            //make the move

            newPosition = currentPos - (dice/2);

            return newPosition;
        }
        return pos;
    }

    @Override
    public String toString() {
        return "ErroDeLogica";
    }
}
