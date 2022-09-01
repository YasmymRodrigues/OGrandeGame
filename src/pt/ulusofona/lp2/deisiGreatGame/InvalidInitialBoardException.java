package pt.ulusofona.lp2.deisiGreatGame;

public class InvalidInitialBoardException extends Exception {

    protected String typeId;

    InvalidInitialBoardException(String message){
        super(message);
        typeId = "";
    }

    @Override
    public String getMessage() {
        //return super.getMessage();
        super.getMessage();
        return "Erro teste";
    }
    boolean isInvalidAbyss(){
        return false;
    }
    boolean isInvalidTool(){
        return false;
    }
    public String getTypeId(){
        return typeId;
    }
}
