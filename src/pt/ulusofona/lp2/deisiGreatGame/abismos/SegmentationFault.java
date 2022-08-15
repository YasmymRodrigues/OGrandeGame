package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;

public class SegmentationFault extends Abismo {
    public SegmentationFault(int id, int pos) {
        super(id, pos);
    }

    @Override
    public boolean isAbismo() {
        return true;
    }

    @Override
    public int getReact(int pos, Programmer programmer) {
        return 1;
    }
    //IDE 4
    //2 ou mais programadores na casa
    //recuam 3 casas
    //1 programador não tem efeito

    @Override
    public String toString() {
        return "Segmentation Fault";
    }
}
