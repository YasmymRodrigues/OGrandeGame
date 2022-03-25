package pt.ulusofona.lp2.deisiGreatGame;

public class ProgramacaoFuncional extends Ferramenta{
    public ProgramacaoFuncional(String nome, int idFerramenta) {
        super(nome, idFerramenta);
    }

    @Override
    public String toolName() {
        return nome;
    }
}
