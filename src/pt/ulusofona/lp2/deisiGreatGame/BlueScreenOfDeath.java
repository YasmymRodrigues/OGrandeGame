package pt.ulusofona.lp2.deisiGreatGame;

public class BlueScreenOfDeath extends Abismo {
    public BlueScreenOfDeath(String nome, int idAbismo, int pos) {
        super(nome, idAbismo, pos);
    }

    @Override
    public String abisName() {
        return "Blue Screen of Death";
    }
}
