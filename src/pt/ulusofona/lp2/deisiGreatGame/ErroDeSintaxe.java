package pt.ulusofona.lp2.deisiGreatGame;

public class ErroDeSintaxe extends Abismo{
    String nome;

    public ErroDeSintaxe(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String abisName() {
        return nome;
    }
}
