package pt.ulusofona.lp2.deisiGreatGame;

public class InvalidInitialBoardAbyssException extends InvalidInitialBoardException {

    public InvalidInitialBoardAbyssException(String message, int typeId) {
        super(message);
        this.typeId = String.valueOf(typeId);
    }

    @Override
    public boolean isInvalidAbyss(){
        return true;
    }
}
