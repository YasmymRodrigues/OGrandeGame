package pt.ulusofona.lp2.deisiGreatGame;

public class SegmentationFault extends Abismo {
    public SegmentationFault(String nome, int idAbismo, int pos) {
        super(nome, idAbismo, pos);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
