package pt.ulusofona.lp2.deisiGreatGame;

public class CicloInfinito extends Abismo {
    public CicloInfinito(String nome, int idAbismo) {
        super(nome, idAbismo);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
