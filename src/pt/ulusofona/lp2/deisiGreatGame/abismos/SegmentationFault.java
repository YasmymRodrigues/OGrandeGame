package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.abismos.Abismo;

public class SegmentationFault extends Abismo {
    public SegmentationFault(String nome, int id, int pos) {
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
