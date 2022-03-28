package pt.ulusofona.lp2.deisiGreatGame;

public class TratamentoDeExcepcoes extends Ferramenta {
    public TratamentoDeExcepcoes(String nome, int idFerramenta, int pos) {
        super(nome, idFerramenta, pos);
    }

    @Override
    public String toolName() {
        return nome;
    }
}
