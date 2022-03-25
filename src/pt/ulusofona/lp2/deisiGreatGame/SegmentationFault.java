package pt.ulusofona.lp2.deisiGreatGame;

public class SegmentationFault extends Abismo {
    public SegmentationFault(String nome, int idAbismo) {
        super(nome, idAbismo);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
