package pt.ulusofona.lp2.deisiGreatGame;

public class CicloInfinito extends Abismo {
    String nome;

    public CicloInfinito(String nome) {
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
