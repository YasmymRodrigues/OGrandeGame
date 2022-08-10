package pt.ulusofona.lp2.deisiGreatGame;

abstract public class Event {
    int id;
    int pos;


    public Event(int id, int pos) {
        this.id = id;
        this.pos = pos;

    }


    public int getId() {
        return id;
    }

    public int getPos() {
        return pos;
    }

    abstract public boolean isAbismo();
    abstract public int getReact(int pos, Programmer programmer);

}
