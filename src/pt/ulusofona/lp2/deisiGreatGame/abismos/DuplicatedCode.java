package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;
import pt.ulusofona.lp2.deisiGreatGame.tools.Ferramenta;

public class DuplicatedCode extends Abismo{
    public DuplicatedCode(int id, int pos) {
        super(id, pos);
    }

    @Override
    public boolean isAbismo() {
        return true;
    }

    @Override
    public int getReact(int pos, Programmer programmer) {
        for (Ferramenta ferramenta: programmer.getFerramentas()){
            if (ferramenta.getId() == 0){ //Herança
                return pos;
            }
        }
        //TODO: Validate this if with professor
        if (programmer.getPosicoes().size() < 2){
            return pos;
        }
        programmer.setWasATrap(true);
        return programmer.getPosicoes().size() - 1;
    }

    @Override
    public String toString() {
        return "DuplicatedCode";
    }
}
