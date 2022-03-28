package pt.ulusofona.lp2.deisiGreatGame;

public class Heranca extends Ferramenta {
    public Heranca(String nome, int idFerramenta, int pos) {
        super(nome, idFerramenta, pos);
    }

    @Override
    public String toolName() {
        return nome;
    }
}
