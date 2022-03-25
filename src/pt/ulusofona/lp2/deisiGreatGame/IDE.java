package pt.ulusofona.lp2.deisiGreatGame;

public class IDE extends Ferramenta {
    public IDE(String nome, int idFerramenta) {
        super(nome, idFerramenta);
    }

    @Override
    public String toolName() {
        return nome;
    }
}
