package pt.ulusofona.lp2.deisiGreatGame.abismos;

public class Crash extends Abismo {
    public Crash(String nome, int id, int pos) {
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
