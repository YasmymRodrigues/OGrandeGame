package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;
import pt.ulusofona.lp2.deisiGreatGame.tools.Ferramenta;

import java.util.List;

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
            if (ferramenta.getId() == 1 || ferramenta.getId() == 2){ //Testes Unitários
                return pos;
            }
        }
        //TODO: Validate this if with professor
        if (programmer.getPosicoes().size() < 3){
            return pos;
        }
        List<Integer> posicoes = programmer.getPosicoes();
        return programmer.getPosicoes().get(posicoes.size() - 3);
    }

    @Override
    public String toString() {
        return "EfeitosSecundarios";
    }
}
