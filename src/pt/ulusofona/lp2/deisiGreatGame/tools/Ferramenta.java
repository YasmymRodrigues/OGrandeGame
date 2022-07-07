package pt.ulusofona.lp2.deisiGreatGame.tools;

import pt.ulusofona.lp2.deisiGreatGame.Event;

public abstract class Ferramenta extends Event {
     public Ferramenta(String nome, int id, int pos) {
          super(nome,id,pos);
     }

     abstract public boolean isAbismo();

     @Override
     public String toString() {
          return super.toString();
     }

}
