package pt.ulusofona.lp2.deisiGreatGame;

public class TratamentoDeExcepcoes extends Ferramenta {
    String nome;

    public TratamentoDeExcepcoes(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toolName() {
        return "Tratamento de Excepções";
    }
}
