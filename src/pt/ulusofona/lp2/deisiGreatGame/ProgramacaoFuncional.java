package pt.ulusofona.lp2.deisiGreatGame;

public class ProgramacaoFuncional extends Ferramenta{
    String nome;

    public ProgramacaoFuncional(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toolName() {
        return nome;
    }
}
