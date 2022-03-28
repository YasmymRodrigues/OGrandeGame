package pt.ulusofona.lp2.deisiGreatGame;

public class Exception extends Abismo {
    public Exception(String nome, int idAbismo, int pos) {
        super(nome, idAbismo, pos);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
