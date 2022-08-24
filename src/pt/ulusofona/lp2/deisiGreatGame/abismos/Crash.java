package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;
import pt.ulusofona.lp2.deisiGreatGame.tools.Ferramenta;

public class Crash extends Abismo {
    public Crash(int id, int pos) {
        super(id, pos);
    }

    @Override
    public boolean isAbismo() {
        return true;
    }

    @Override
    public int getReact(int pos, Programmer programmer) {
        if (programmer.getFerramentas() != null){
            for (Ferramenta ferramenta: programmer.getFerramentas()){
                if (ferramenta.getId() == 3){ //Tratamento de Excessões
                    return pos;
                }
            }
        }
        programmer.setWasATrap(true);
        return 1;
    }

    @Override
    public String toString() {
        return "Crash";
    }
}
