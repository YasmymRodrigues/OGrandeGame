package pt.ulusofona.lp2.deisiGreatGame;

public class Unitarios extends Ferramenta{
    String nome;

    public Unitarios(String nome) {
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
