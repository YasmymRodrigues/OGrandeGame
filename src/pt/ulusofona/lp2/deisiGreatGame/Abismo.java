package pt.ulusofona.lp2.deisiGreatGame;

public class Abismo {
    int idAbismo;
    String titulo;

    Abismo(){};
    Abismo(int idAbismo, String titulo){
        this.idAbismo = idAbismo;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Abismo{" +
                "idAbismo=" + idAbismo +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
