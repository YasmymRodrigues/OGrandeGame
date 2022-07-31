package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;
import pt.ulusofona.lp2.deisiGreatGame.tools.Ferramenta;

public class Exception extends Abismo {
    public Exception(String nome, int id, int pos) {
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
            if (ferramenta.getId() == 5 || ferramenta.getId() == 3){ //Ajuda do professor
                return pos;
            }
        }
        if (pos > 2){
            newPosition = programmer.getPos() - 2;
            return newPosition;
        }
        return pos;
    }
}
