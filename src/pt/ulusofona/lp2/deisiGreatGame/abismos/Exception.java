package pt.ulusofona.lp2.deisiGreatGame.abismos;

public class Exception extends Abismo {
    public Exception(String nome, int id, int pos) {
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
