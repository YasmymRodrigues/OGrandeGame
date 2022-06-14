package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;
import pt.ulusofona.lp2.deisiGreatGame.tools.Ferramenta;

public class EfeitosSecundarios extends Abismo {
    public EfeitosSecundarios(String nome, int id, int pos) {
        super(nome, id, pos);
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
        if (programmer.getPosicoes().size() < 3){
            return pos;
        }

        return programmer.getPosicoes().get(-3);
    }
}
