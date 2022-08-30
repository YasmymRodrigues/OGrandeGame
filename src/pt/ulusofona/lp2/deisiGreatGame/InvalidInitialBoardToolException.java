package pt.ulusofona.lp2.deisiGreatGame;

public class InvalidInitialBoardToolException extends InvalidInitialBoardException {

    public InvalidInitialBoardToolException(String message, int typeId) {
        super(message);
        this.typeId = String.valueOf(typeId);
    }

    @Override
    public boolean isInvalidTool(){
        return true;
    }
}
