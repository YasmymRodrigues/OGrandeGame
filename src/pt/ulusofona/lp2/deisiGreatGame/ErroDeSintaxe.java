package pt.ulusofona.lp2.deisiGreatGame;

public class ErroDeSintaxe extends Abismo{
    public ErroDeSintaxe(String nome, int idAbismo, int pos) {
        super(nome, idAbismo, pos);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
