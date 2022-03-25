package pt.ulusofona.lp2.deisiGreatGame;

public class Heranca extends Ferramenta {
    public Heranca(String nome, int idFerramenta) {
        super(nome, idFerramenta);
    }

    @Override
    public String toolName() {
        return nome;
    }
}
