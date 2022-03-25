package pt.ulusofona.lp2.deisiGreatGame;

public class Crash extends Abismo {
    public Crash(String nome, int idAbismo) {
        super(nome, idAbismo);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
