package pt.ulusofona.lp2.deisiGreatGame;

public class BlueScreenOfDeath extends Abismo {
    String nome;

    public BlueScreenOfDeath(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String abisName() {
        return "Blue Screen of Death";
    }
}
