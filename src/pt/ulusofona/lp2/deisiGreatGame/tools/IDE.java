package pt.ulusofona.lp2.deisiGreatGame.tools;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;

public class IDE extends Ferramenta {
    public IDE(int id, int pos) {
        super(id, pos);
    }

    @Override
    public boolean isAbismo() {
        return false;
    }


    @Override
    public int getReact(int pos, Programmer programmer) {
        return 1;
    }

    @Override
    public String toString() {
        return "IDE";
    }
}
