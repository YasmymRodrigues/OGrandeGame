package pt.ulusofona.lp2.deisiGreatGame;

import javax.sql.rowset.BaseRowSet;
import javax.swing.*;
import java.util.ArrayList;

import static pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor.*;

public class GameManager {
    String[][] playerInfo;
    int boardSize;
    int position;

    public GameManager() {
    }

    public GameManager(String[][] playerInfo, int boardSize, int position) {
        this.playerInfo = playerInfo;
        this.boardSize = boardSize;
        this.position = position;
    }

    public boolean createInitialBoard(String[][] playerInfo, int boardSize){

        ArrayList<Programmer> programmers = new ArrayList<Programmer>();

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

            Programmer programmerF = new Programmer(nome, id, languages,cor);
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
        return true;
    }

  
    public String getImagePng(int position){
        return "";
    }

    public ArrayList<Programmer> getProgrammers(){
        //ArrayList<Programmer> programmers = createInitialBoard(playerInfo, boardSize);



       return new ArrayList<>();
    }

    public ArrayList<Programmer> getProgrammers(int position){
        ArrayList<Programmer> programmers = new ArrayList<Programmer>();


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


    public ArrayList<String> getGameResults(){
        ArrayList<String> results = new ArrayList<String>();

        return results;
    }

    public JPanel getAuthorsPanel(){

        return null;
    }
}
