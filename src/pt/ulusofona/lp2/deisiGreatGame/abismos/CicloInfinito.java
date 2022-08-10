package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;

public class CicloInfinito extends Abismo {
    public CicloInfinito(int id, int pos) {
        super(id, pos);
    }

    @Override
    public boolean isAbismo() {
        return true;
    }

    @Override
    public int getReact(int pos, Programmer programmer) {
        return pos;
        //1  P Funcional
        //
    }

    @Override
    public String toString() {
        return "CicloInfinito";
    }
}
