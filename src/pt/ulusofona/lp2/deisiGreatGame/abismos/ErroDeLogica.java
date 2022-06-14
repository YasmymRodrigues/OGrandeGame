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
            int tmpPos = programmer.getPos();
            newPosition = tmpPos / 2 ;
        }else{
            return pos;
        }
        return newPosition;
    }
}
