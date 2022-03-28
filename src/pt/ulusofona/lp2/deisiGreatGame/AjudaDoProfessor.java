package pt.ulusofona.lp2.deisiGreatGame;

public class AjudaDoProfessor extends Ferramenta {

    public AjudaDoProfessor(String nome, int idFerramenta, int pos) {
        super(nome, idFerramenta, pos);
    }

    @Override
    public String toolName() {
        return nome;
    }
}
