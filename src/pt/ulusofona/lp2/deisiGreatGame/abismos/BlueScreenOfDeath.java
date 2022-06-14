package pt.ulusofona.lp2.deisiGreatGame.abismos;

public class BlueScreenOfDeath extends Abismo {
    public BlueScreenOfDeath(String nome, int id, int pos) {
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
