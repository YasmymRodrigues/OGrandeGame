package pt.ulusofona.lp2.deisiGreatGame;

public class FileNotFoundException extends Abismo {
    public FileNotFoundException(String nome, int idAbismo, int pos) {
        super(nome, idAbismo, pos);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
