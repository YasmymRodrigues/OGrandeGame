package pt.ulusofona.lp2.deisiGreatGame;

public class ErroDeLogica extends Abismo{
    public ErroDeLogica(String nome, int idAbismo) {
        super(nome, idAbismo);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
