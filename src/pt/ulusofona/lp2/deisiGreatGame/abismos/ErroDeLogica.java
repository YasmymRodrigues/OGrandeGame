package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;
import pt.ulusofona.lp2.deisiGreatGame.tools.Ferramenta;

public class ErroDeLogica extends Abismo{
    public ErroDeLogica(String nome, int id, int pos) {
        super(nome, id, pos);
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
            //get current pos - the last pos = nrSpace * -1
            int currentPos = programmer.getPos();
            int lastPos = programmer.getPosicoes().size() - 2;
            //get dice value
            int dice = (currentPos - lastPos) * - 1;
            //make the move
            newPosition = dice / 2;
        }else{
            return pos;
        }
        return newPosition;
    }
}
