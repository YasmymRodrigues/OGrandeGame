package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;

public class ErroDeSintaxe extends Abismo{
    public ErroDeSintaxe(String nome, int id, int pos) {
        super(nome, id, pos);
    }

    @Override
    public boolean isAbismo() {
        return true;
    }

    @Override
    public int getReact(int pos, Programmer programmer) {
        int newPosition = 0;
        if (pos > 1){
            newPosition = programmer.getPos() - 1;
        }

        return newPosition;
    }
}
