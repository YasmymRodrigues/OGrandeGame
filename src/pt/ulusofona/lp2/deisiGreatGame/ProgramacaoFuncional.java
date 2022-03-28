package pt.ulusofona.lp2.deisiGreatGame;

public class ProgramacaoFuncional extends Ferramenta{
    public ProgramacaoFuncional(String nome, int idFerramenta, int pos) {
        super(nome, idFerramenta, pos);
    }

    @Override
    public String toolName() {
        return nome;
    }
}
