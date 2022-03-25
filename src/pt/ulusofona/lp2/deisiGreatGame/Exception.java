package pt.ulusofona.lp2.deisiGreatGame;

public class Exception extends Abismo {
    public Exception(String nome, int idAbismo) {
        super(nome, idAbismo);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
