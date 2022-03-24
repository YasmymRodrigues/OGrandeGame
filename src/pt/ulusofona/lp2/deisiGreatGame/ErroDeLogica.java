package pt.ulusofona.lp2.deisiGreatGame;

public class ErroDeLogica extends Abismo{
    String nome;

    public ErroDeLogica(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String abisName() {
        return nome;
    }
}
