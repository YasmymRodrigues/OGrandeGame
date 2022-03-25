package pt.ulusofona.lp2.deisiGreatGame;

public class FileNotFoundException extends Abismo {
    public FileNotFoundException(String nome, int idAbismo) {
        super(nome, idAbismo);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
