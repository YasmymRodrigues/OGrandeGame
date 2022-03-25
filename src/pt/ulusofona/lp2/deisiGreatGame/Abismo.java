package pt.ulusofona.lp2.deisiGreatGame;

abstract public class Abismo {
    String nome;
    int idAbismo;

    public Abismo(String nome, int idAbismo) {
        this.nome = nome;
        this.idAbismo = idAbismo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdAbismo() {
        return idAbismo;
    }

    abstract public String abisName();
}
