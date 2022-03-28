package pt.ulusofona.lp2.deisiGreatGame;

abstract class Ferramenta {
     String nome;
     int idFerramenta;
     int pos;

     public Ferramenta(String nome, int idFerramenta, int pos) {
          this.nome = nome;
          this.idFerramenta = idFerramenta;
          this.pos = pos;
     }

     abstract public String toolName();
}
