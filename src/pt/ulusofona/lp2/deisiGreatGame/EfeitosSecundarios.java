package pt.ulusofona.lp2.deisiGreatGame;

public class EfeitosSecundarios extends Abismo {
    public EfeitosSecundarios(String nome, int idAbismo, int pos) {
        super(nome, idAbismo, pos);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
