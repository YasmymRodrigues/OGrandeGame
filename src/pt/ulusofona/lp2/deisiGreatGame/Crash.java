package pt.ulusofona.lp2.deisiGreatGame;

public class Crash extends Abismo {
    public Crash(String nome, int idAbismo, int pos) {
        super(nome, idAbismo, pos);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
