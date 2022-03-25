package pt.ulusofona.lp2.deisiGreatGame;

abstract class Ferramenta {
     String nome;
     int idFerramenta;

     public Ferramenta(String nome, int idFerramenta) {
          this.nome = nome;
          this.idFerramenta = idFerramenta;
     }

     abstract public String toolName();
}
