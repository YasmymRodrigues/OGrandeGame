package pt.ulusofona.lp2.deisiGreatGame;

public class TratamentoDeExcepcoes extends Ferramenta {
    public TratamentoDeExcepcoes(String nome, int idFerramenta) {
        super(nome, idFerramenta);
    }

    @Override
    public String toolName() {
        return nome;
    }
}
