package pt.ulusofona.lp2.deisiGreatGame;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor.*;


public class GameManager {
    String[][] playerInfo;
    String[][] abyssesAndTools;
    int worldSize;
    int pos;
    List<Ferramenta> ferramentas = new ArrayList<>() {};

    public GameManager() {
    }

    public GameManager(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) {
        this.playerInfo = playerInfo;
        this.worldSize = worldSize;
        this.abyssesAndTools = abyssesAndTools;
    }

    public boolean createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) throws InvalidInitialBoardException{

        List<Programmer> programmers = new ArrayList<Programmer>();
        List<Abismo> abismos = new ArrayList<Abismo>();
        List<Ferramenta> ferramentas = new ArrayList<Ferramenta>();
        Programmer programmer = new Programmer();
        Language language = new Language();
        ArrayList<Language> languages = programmer.getLinguagens();
        Ferramenta ferramenta = new Ferramenta();
        Abismo abismo = new Abismo();
        int id = 0;
        String nome = "";
        ProgrammerColor cor = null;

        for(String[] arr: playerInfo) {
            id = Integer.parseInt(arr[0]);
            nome = arr[1];
            programmer.id = id;
            programmer.nome = nome;
            language.nome = arr[2];
            languages.add(language);
            programmer.linguagens = languages;

            if (arr[3].equals("Blue")) {
                cor = BLUE;
            } else if (arr[3].equals("Purple")) {
                cor = PURPLE;
            } else if (arr[3].equals("Brown")) {
                cor = BROWN;
            } else if (arr[3].equals("Green")) {
                cor = GREEN;
            }
        }
            this.worldSize = worldSize;

        for (String[] arr: abyssesAndTools) {
            int type = Integer.parseInt(arr[0]);
            int idDoTipo = Integer.parseInt(arr[1]); // todo: ver se é F ou A e depois ver o tipo de cada
            // todo: Classes Abismo e Ferramentas.
            if (type == 0){
                if (idDoTipo == 0){
                    Abismo erroDeSintaxe = new ErroDeSintaxe();
                }else if(idDoTipo == 1){
                    Abismo erroDeLogica = new ErroDeLogica();
                }else if(idDoTipo == 2){
                    Abismo exception = new
                }








                ferramenta.idFerramenta = type;
                ferramentas.add(ferramenta);
                programmer.ferramentas = ferramentas;
            }else{
                abismo.idAbismo= type;
                abismos.add(abismo);
            }


            int position = Integer.parseInt(arr[2]);
            programmer.pos = position;
        }
        programmers.add(programmer);

           if (id > 4 || id < 0){
                return false;
            }
            if(nome == null){
               return false;
            }
           if(cor != BLUE || cor != PURPLE || cor != BROWN || cor != GREEN){
               return false;
           }
        return true;
    }

    public void createInitialBoard(String[][] playerInfo, int worldSize) throws InvalidInitialBoardException{ }


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

    public String getProgrammersInfo(){
        return "";
    }

    public String reactToAbyssOrTool(){
        return "";
    }

    public String getTitle(int position){
        return "";
    }
    public boolean saveGame(File file){return true;}
    public boolean loadGame(File file){return true;}

}
