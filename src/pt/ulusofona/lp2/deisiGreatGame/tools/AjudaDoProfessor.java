package pt.ulusofona.lp2.deisiGreatGame.tools;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;

public class AjudaDoProfessor extends Ferramenta {

    public AjudaDoProfessor(int id, int pos) {
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
        return "Ajuda do Professor";
    }
}
