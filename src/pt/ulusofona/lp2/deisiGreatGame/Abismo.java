package pt.ulusofona.lp2.deisiGreatGame;

abstract public class Abismo {
    String nome;
    int idAbismo;
    int pos;

    public Abismo(String nome, int idAbismo, int pos) {
        this.nome = nome;
        this.idAbismo = idAbismo;
        this.pos = pos;
    }

    public String getNome() {
        return nome;
    }

    public int getIdAbismo() {
        return idAbismo;
    }

    public int getPos() {
        return pos;
    }


    abstract public String abisName();
}
