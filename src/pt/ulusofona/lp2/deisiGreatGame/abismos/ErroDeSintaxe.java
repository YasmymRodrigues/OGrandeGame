package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;
import pt.ulusofona.lp2.deisiGreatGame.tools.Ferramenta;

public class ErroDeSintaxe extends Abismo{
    public ErroDeSintaxe(int id, int pos) {
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
            if (ferramenta.getId() == 4 || ferramenta.getId() == 5){ //Ajuda do professor + IDE
                return pos;
            }
        }
        if (pos > 1) {
            newPosition = programmer.getPos() - 1;
            programmer.setWasATrap(true);
            return newPosition;
        }

        return pos;
    }

    @Override
    public String toString() {
        return "Erro de sintaxe";
    }
}
