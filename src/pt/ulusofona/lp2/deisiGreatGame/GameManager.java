package pt.ulusofona.lp2.deisiGreatGame;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor.*;


public class GameManager {
    String[][] playerInfo;
    //String[][] abyssesAndTools;
    int boardSize;
    int position;

    public GameManager() {
    }

    public GameManager(String[][] playerInfo, int boardSize, int position) {
        this.playerInfo = playerInfo;
        this.boardSize = boardSize;
        this.position = position;
        //this.abyssesAndTools = abyssesAndTools;
    }

    void createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) throws InvalidInitialBoardException{

        List<Programmer> programmers = new ArrayList<Programmer>();
        List<Ferramenta> ferramenta = new ArrayList<Ferramenta>();
        //List<Ferramenta> ferramenta = new ArrayList<Abismo>();


        for(String[] arr: playerInfo) {
            int id = Integer.parseInt(arr[0]);
            String nome = arr[1];
            Programmer programmer = new Programmer();
            arr[2].getClass();
            ArrayList<Language> languages = programmer.getLinguagens();
            ProgrammerColor cor = null;
            if (arr[3].equals("BLUE")){
                cor = BLUE;
            }else if (arr[3].equals("PURPLE")){
                cor = PURPLE;
            }else if(arr[3].equals("BROWN")){
                cor = BROWN;
            }else if(arr[3].equals("GREEN")){
                cor = GREEN;
            }

            this.boardSize = boardSize;

            Programmer programmerF = new Programmer(nome, id, languages,cor, ferramenta);
            programmers.add(programmerF);

        /*    if (id > 4 || id < 0){
                return false;
            }
            if(nome == null){
               return false;
            }
           if(cor != BLUE || cor != PURPLE || cor != BROWN || cor != GREEN){
               return false;
           }*/

        }
        //return true;
        //return 0;
    }

    void createInitialBoard(String[][] playerInfo, int worldSize) throws InvalidInitialBoardException{ }


    public String getImagePng(int position){
        return "";
    }

    public List<Programmer> getProgrammers(boolean includeDefeated){

       return new ArrayList<>();
    }

    public List<Programmer> getProgrammers(int position){
        List<Programmer> programmers = new ArrayList<Programmer>();


        return programmers;
    }

    public int getCurrentPlayerID(){

        return 0;
    }

    public boolean moveCurrentPlayer(int position){

        return true;
    }

    public boolean gameIsOver(){
        return true;
    }


    public List<String> getGameResults(){
        List<String> results = new ArrayList<String>();

        return results;
    }

    public JPanel getAuthorsPanel(){

        return null;
    }

    String getProgrammersInfo(){
        return "";
    }

    String reactToAbyssOrTool(){
        return "";
    }

    String getTitle(int position){
        return "";
    }
    public boolean saveGame(File file){return true;}
    public boolean loadGame(File file){return true;}

}
