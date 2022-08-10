package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;

public class BSOD extends Abismo {
    public BSOD(int id, int pos) {
        super(id, pos);
    }

    @Override
    public boolean isAbismo() {
        return true;
    }

    @Override
    public int getReact(int pos, Programmer programmer) {
        programmer.setEstado(false);
        return pos;
    }

    @Override
    public String toString() {
        return "BSOD";
    }
}
