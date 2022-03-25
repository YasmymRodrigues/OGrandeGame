package pt.ulusofona.lp2.deisiGreatGame;

public class EfeitosSecundarios extends Abismo {
    public EfeitosSecundarios(String nome, int idAbismo) {
        super(nome, idAbismo);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
