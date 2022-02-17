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
                    abismos.add(erroDeSintaxe);
                }else if(idDoTipo == 1){
                    Abismo erroDeLogica = new ErroDeLogica();
                    abismos.add(erroDeLogica);
                }else if(idDoTipo == 2){
                    Abismo exception = new Exception();
                    abismos.add(exception);
                }else if (idDoTipo == 3){
                    Abismo fileNotFoundException = new FileNotFoundException();
                    abismos.add(fileNotFoundException);
                }else if (idDoTipo == 4){
                    Abismo crash = new Crash();
                    abismos.add(crash);
                }else if (idDoTipo == 5){
                    Abismo duplicatedCode = new DuplicatedCode();
                    abismos.add(duplicatedCode);
                }else if (idDoTipo == 6){
                    Abismo efeitosSecundarios = new EfeitosSecundarios();
                    abismos.add(efeitosSecundarios);
                }else if (idDoTipo == 7){
                    Abismo bsod = new BlueScreenOfDeath();
                    abismos.add(bsod);
                }else if (idDoTipo == 8){
                    Abismo cicloInfinito = new CicloInfinito();
                    abismos.add(cicloInfinito);
                }else if (idDoTipo == 9){
                    Abismo segF = new SegmentationFault();
                    abismos.add(segF);
                }else{
                    System.out.println("Not an abismo");
                }
            }else{
                if (idDoTipo == 0){
                    Ferramenta heranca = new Heranca();
                    ferramentas.add(heranca);
                }else if (idDoTipo == 1){
                    Ferramenta progF = new ProgramacaoFuncional();
                    ferramentas.add(progF);
                }else if (idDoTipo == 2){
                    Ferramenta testU = new TestesUnitarios();
                    ferramentas.add(testU);
                }else if (idDoTipo == 3){
                    Ferramenta tratEx = new TratamentoDeExcepcoes();
                    ferramentas.add(tratEx);
                }else if (idDoTipo == 4){
                    Ferramenta ide = new IDE();
                    ferramentas.add(ide);
                }else if (idDoTipo == 5){
                    Ferramenta helpProf = new AjudaDoProfessor();
                    ferramentas.add(helpProf);
                }
                programmer.ferramentas = ferramentas;
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
