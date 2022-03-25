package pt.ulusofona.lp2.deisiGreatGame;

public class AjudaDoProfessor extends Ferramenta {

    public AjudaDoProfessor(String nome, int idFerramenta) {
        super(nome, idFerramenta);
    }

    @Override
    public String toolName() {
        return nome;
    }
}
