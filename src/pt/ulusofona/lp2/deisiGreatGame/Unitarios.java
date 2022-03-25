package pt.ulusofona.lp2.deisiGreatGame;

public class Unitarios extends Ferramenta{
    public Unitarios(String nome, int idFerramenta) {
        super(nome, idFerramenta);
    }

    @Override
    public String toolName() {
        return nome;
    }
}
