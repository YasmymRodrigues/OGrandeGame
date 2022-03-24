package pt.ulusofona.lp2.deisiGreatGame;

public class Heranca extends Ferramenta {
    String nome;

    public Heranca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toolName() {
        return "Herança";
    }
}
