package pt.ulusofona.lp2.deisiGreatGame;

public class Exception extends Abismo {
    String nome;

    public Exception(String nome) {
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
