package pt.ulusofona.lp2.deisiGreatGame.abismos;

import pt.ulusofona.lp2.deisiGreatGame.Programmer;
import pt.ulusofona.lp2.deisiGreatGame.tools.Ferramenta;

public class FileNotFoundException extends Abismo {
    public FileNotFoundException(int id, int pos) {
        super(id, pos);
    }

    @Override
    public boolean isAbismo() {
        return true;
    }

    @Override
    public int getReact(int pos, Programmer programmer) {
        int newPosition;
        for (Ferramenta ferramenta: programmer.getFerramentas()){
            if (ferramenta.getId() == 5 || ferramenta.getId() == 3){
                return pos;
            }
        }

        if (pos > 3){
            newPosition = programmer.getPos() - 3;
            return newPosition;
        }

        return pos;
    }

    @Override
    public String toString() {
        return "FileNotFoundException";
    }
}
