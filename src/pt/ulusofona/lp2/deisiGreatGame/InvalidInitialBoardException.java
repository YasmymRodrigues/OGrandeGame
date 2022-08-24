package pt.ulusofona.lp2.deisiGreatGame;

public class InvalidInitialBoardException extends Exception {
    int typeId;

    InvalidInitialBoardException(){}

    @Override
    public String getMessage() {
        //return super.getMessage();
        super.getMessage();
        return "Erro teste";
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
