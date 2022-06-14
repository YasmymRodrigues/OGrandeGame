package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Event;

abstract public class Abismo extends Event {

    public Abismo(String nome, int id, int pos) {
        super(nome,id,pos);
    }

    abstract public boolean isAbismo();
}
