package pt.ulusofona.lp2.deisiGreatGame;

public class DuplicatedCode extends Abismo{
    String nome;

    public DuplicatedCode(String nome) {
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
