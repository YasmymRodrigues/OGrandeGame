package pt.ulusofona.lp2.deisiGreatGame;

abstract public class Event {
    String nome;
    int id;
    int pos;


    public Event(String nome, int id, int pos) {
        this.nome = nome;
        this.id = id;
        this.pos = pos;

    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public int getPos() {
        return pos;
    }

    abstract public boolean isAbismo();
    abstract public void getReact(int pos);

}
