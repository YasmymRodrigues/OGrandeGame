package pt.ulusofona.lp2.deisiGreatGame.tools;

import pt.ulusofona.lp2.deisiGreatGame.tools.Ferramenta;

public class Unitarios extends Ferramenta {
    public Unitarios(String nome, int id, int pos) {
        super(nome, id, pos);
    }

    @Override
    public boolean isAbismo() {
        return false;
    }

    @Override
    public void getReact(int pos) {

    }
}
