package pt.ulusofona.lp2.deisiGreatGame;

public class ErroDeSintaxe extends Abismo{
    public ErroDeSintaxe(String nome, int idAbismo) {
        super(nome, idAbismo);
    }

    @Override
    public String abisName() {
        return nome;
    }
}
