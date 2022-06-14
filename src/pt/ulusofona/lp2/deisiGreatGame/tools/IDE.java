package pt.ulusofona.lp2.deisiGreatGame.tools;

public class IDE extends Ferramenta {
    public IDE(String nome, int id, int pos) {
        super(nome, id, pos);
    }

    @Override
    public boolean isAbismo() {
        return false;
    }


    @Override
    public void getReact(int pos) {

    }
}
