package pt.ulusofona.lp2.deisiGreatGame;

public class ErroDeLogica extends Abismo{
    public ErroDeLogica(String nome, int idAbismo, int pos) {
        super(nome, idAbismo, pos);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
