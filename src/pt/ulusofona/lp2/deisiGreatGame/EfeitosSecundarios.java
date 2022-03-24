package pt.ulusofona.lp2.deisiGreatGame;

public class EfeitosSecundarios extends Abismo {
    String nome;

    public EfeitosSecundarios(String nome) {
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
