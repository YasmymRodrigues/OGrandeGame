package pt.ulusofona.lp2.deisiGreatGame;

public class AjudaDoProfessor extends Ferramenta {
    String nome;

    public AjudaDoProfessor(String nome) {
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
