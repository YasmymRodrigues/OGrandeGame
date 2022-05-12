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

     public String getNome() {
          return nome;
     }

     public int getIdFerramenta() {
          return idFerramenta;
     }

     public int getPos() {
          return pos;
     }

     abstract public String toolName();
}
