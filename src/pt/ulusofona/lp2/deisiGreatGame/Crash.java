package pt.ulusofona.lp2.deisiGreatGame;

public class Crash extends Abismo {
    String nome;

    public Crash(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String abisName() {
        return nome;
    }
}
