package pt.ulusofona.lp2.deisiGreatGame;

public class IDE extends Ferramenta {
    public IDE(String nome, int idFerramenta, int pos) {
        super(nome, idFerramenta, pos);
    }

    @Override
    public String toolName() {
        return nome;
    }
}
