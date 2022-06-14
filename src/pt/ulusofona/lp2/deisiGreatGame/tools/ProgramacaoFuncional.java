package pt.ulusofona.lp2.deisiGreatGame.tools;

public class ProgramacaoFuncional extends Ferramenta{
    public ProgramacaoFuncional(String nome, int id, int pos) {
        super(nome, id, pos);
    }

    @Override
    public boolean isAbismo() {
        return false;
    }

    @Override
    public void getReact(int pos) {

    }
}
