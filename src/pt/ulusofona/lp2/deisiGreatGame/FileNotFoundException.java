package pt.ulusofona.lp2.deisiGreatGame;

public class FileNotFoundException extends Abismo {
    String nome;

    public FileNotFoundException(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String abisName() {
        return nome;
    }
}
