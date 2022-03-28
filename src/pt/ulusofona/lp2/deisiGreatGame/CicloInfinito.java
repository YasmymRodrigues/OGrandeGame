package pt.ulusofona.lp2.deisiGreatGame;

public class CicloInfinito extends Abismo {
    public CicloInfinito(String nome, int idAbismo, int pos) {
        super(nome, idAbismo, pos);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
