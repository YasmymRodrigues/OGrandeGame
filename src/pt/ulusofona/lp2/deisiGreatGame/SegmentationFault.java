package pt.ulusofona.lp2.deisiGreatGame;

public class SegmentationFault extends Abismo {
    String nome;

    public SegmentationFault(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String abisName() {
        return "Segmentation Fault";
    }
}
