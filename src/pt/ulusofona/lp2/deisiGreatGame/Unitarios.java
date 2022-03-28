package pt.ulusofona.lp2.deisiGreatGame;

public class Unitarios extends Ferramenta{
    public Unitarios(String nome, int idFerramenta, int pos) {
        super(nome, idFerramenta, pos);
    }

    @Override
    public String toolName() {
        return nome;
    }
}
