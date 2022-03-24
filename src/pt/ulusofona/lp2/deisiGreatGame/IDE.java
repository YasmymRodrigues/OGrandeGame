package pt.ulusofona.lp2.deisiGreatGame;

public class IDE extends Ferramenta {
    String nome;

    public IDE(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toolName() {
        return nome;
    }
}
