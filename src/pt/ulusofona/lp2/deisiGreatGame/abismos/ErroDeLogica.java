package pt.ulusofona.lp2.deisiGreatGame.abismos;

public class ErroDeLogica extends Abismo{
    public ErroDeLogica(String nome, int id, int pos) {
        super(nome, id, pos);
    }

    @Override
    public boolean isAbismo() {
        return true;
    }

    @Override
    public void getReact(int pos) {

    }
}
