package pt.ulusofona.lp2.deisiGreatGame;

public class InvalidInitialBoardException extends Throwable {
    int typeId;

    InvalidInitialBoardException(){

    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
    boolean isInvalidAbyss(){
        return true;
    }
    boolean isInvalidTool(){
        return true;
    }
    public int getTypeId(){
        return typeId;
    }
}
