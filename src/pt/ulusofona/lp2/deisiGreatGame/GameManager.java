package pt.ulusofona.lp2.deisiGreatGame;

//https://deisi.ulusofona.pt/drop-project/upload/lp2-2122-projecto-especial
//move () + react () + getCurrentPlayerID()
import javax.swing.*;
import java.io.File;
import java.util.*;

import static pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor.*;

public class GameManager {
    int worldSize;
    HashMap<Integer, Programmer> programmers = new HashMap<>();
    HashMap<Integer, Ferramenta> ferramentas = new HashMap<>();
    HashMap<Integer, Abismo> abismos = new HashMap<>();



    public GameManager() {
    }

    public boolean createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) throws InvalidInitialBoardException {

        Set<Integer> progId = new HashSet<>();
        Set<ProgrammerColor> progColor = new HashSet<>();

        int id = 0;
        String nome = "";
        this.worldSize = worldSize;
        for (String[] arr : playerInfo) {
            id = Integer.parseInt(arr[0]); //Id do jogador
            progId.add(id);
            nome = arr[1]; // nome do jogador
            Programmer programmer = new Programmer();
            programmer.setId(id);
            programmer.setName(nome);
            String nomesLanguage = arr[2];
            String[] arrayLanguage = nomesLanguage.split(",");
            for(String lang: arrayLanguage){
                Language language1 = new Language(lang);
                programmer.getLinguagens().add(language1);
            }

            if (arr[3].equals("Blue")) {
                programmer.setColor(BLUE);
            } else if (arr[3].equals("Purple")) {
                programmer.setColor(PURPLE);
            } else if (arr[3].equals("Brown")) {
                programmer.setColor(BROWN);
            } else if (arr[3].equals("Green")) {
                programmer.setColor(GREEN);
            }

            programmer.setPos(1); // todos os programadores começam na posição 1
            programmers.put(programmer.id, programmer);
        }

        for (Programmer pro : programmers.values()) {
            if (progId.add(pro.id) ||pro.id < 0) { //todo I am not sure about this range
                return false;
            }
            if ((pro.name == null) || (pro.name.isEmpty())) {
                return false;
            }
            if (pro.color != BLUE && pro.color != PURPLE && pro.color != BROWN && pro.color != GREEN) {
                return false;
            }
            if (!progColor.add(pro.color)) {
                return false;
            }
            if ((programmers.size() > 4) || (worldSize <= programmers.size() * 2)) {
                return false;
            }
        }
        //Note: abyssesAndTools
        if (abyssesAndTools != null) {
        for (String[] arr : abyssesAndTools) {
                int type = Integer.parseInt(arr[0]);
                int idDoTipo = Integer.parseInt(arr[1]);
                int position = Integer.parseInt(arr[2]);
                if (type == 0) {
                    if (idDoTipo == 0) {
                        Abismo erroDeSintaxe = new ErroDeSintaxe("Erro de Sintaxe", 0);
                        abismos.put(0, erroDeSintaxe);
                    } else if (idDoTipo == 1) {
                        Abismo erroDeLogica = new ErroDeLogica("Erro de Logica", 1);
                        abismos.put(1, erroDeLogica);
                    } else if (idDoTipo == 2) {
                        Abismo exception = new Exception("Exception", 2);
                        abismos.put(2, exception);
                    } else if (idDoTipo == 3) {
                        Abismo fileNotFoundException = new FileNotFoundException("FileNotFoundException", 3);
                        abismos.put(3, fileNotFoundException);
                    } else if (idDoTipo == 4) {
                        Abismo crash = new Crash("Crash", 4);
                        abismos.put(4, crash);
                    } else if (idDoTipo == 5) {
                        Abismo duplicatedCode = new DuplicatedCode("DulicatedCode", 5);
                        abismos.put(5, duplicatedCode);
                    } else if (idDoTipo == 6) {
                        Abismo efeitosSecundarios = new EfeitosSecundarios("EfeitosSecundarios", 6);
                        abismos.put(6, efeitosSecundarios);
                    } else if (idDoTipo == 7) {
                        Abismo bsod = new BlueScreenOfDeath("BlueScreenOfDeath", 7);
                        abismos.put(7, bsod);
                    } else if (idDoTipo == 8) {
                        Abismo cicloInfinito = new CicloInfinito("CicloInfinito", 8);
                        abismos.put(8, cicloInfinito);
                    } else if (idDoTipo == 9) {
                        Abismo segF = new SegmentationFault("SegmentationFault", 9);
                        abismos.put(9, segF);
                    } else {
                        System.out.println("Not an abismo found");
                    }
                }
                if(type == 1) {
                    if (idDoTipo == 0) {
                        Ferramenta heranca = new Heranca("Herança", 0);
                        ferramentas.put(0, heranca);
                    } else if (idDoTipo == 1) {
                        Ferramenta progF = new ProgramacaoFuncional("Prog Funtional", 1);
                        ferramentas.put(1, progF);
                    } else if (idDoTipo == 2) {
                        Ferramenta unitarios = new Unitarios("Unitarios", 2);
                        ferramentas.put(2, unitarios);
                    } else if (idDoTipo == 3) {
                        Ferramenta tratEx = new TratamentoDeExcepcoes("TratamentoDeExcepcoes", 3);
                        ferramentas.put(4, tratEx);
                    } else if (idDoTipo == 4) {
                        Ferramenta ide = new IDE("IDE", 4);
                        ferramentas.put(4, ide);
                    } else if (idDoTipo == 5) {
                        Ferramenta helpProf = new AjudaDoProfessor("AjudaDoProfessor", 5);
                        ferramentas.put(5, helpProf);
                    }else {
                        System.out.println("Not a tool found");
                    }
                }

                //DONE: Validation ofAoA
                if ((arr[0] == null)) {
                    return false;
                }
                if (type != 0 && type != 1) {
                    return false;
                }
                if (type == 0) {
                    if (idDoTipo < 0 || idDoTipo > 9) {
                        return false;
                    }
                } else {
                    if (idDoTipo < 0 || idDoTipo > 5) {
                        return false;
                    }
                }
                // DONE: posicao do tabuleiro onde se encontra o Abismo ou a Ferramenta
                if ((worldSize < position) || (arr[2] == null) || (position < 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean createInitialBoard(String[][] playerInfo, int worldSize) throws InvalidInitialBoardException {
        return createInitialBoard(playerInfo, worldSize, null);
    }

     public String getImagePng(int position) {
        return "blank.png";
    }

    public List<Programmer> getProgrammers(boolean includeDefeated) {
        List<Programmer> programmerList = new ArrayList<>();
        for(Programmer pro: programmers.values()){
            programmerList.add(pro);
        }
        return programmerList;
    }

    public List<Programmer> getProgrammers(int position) {
        List<Programmer> programmersList = new ArrayList<>();
        for (Programmer programmer: programmers.values()){
            if(programmer.pos == position ){
                programmersList.add(programmer);
            }
        }
        return programmersList;
    }


    public int getCurrentPlayerID() {
        return 0;
    }

    public boolean moveCurrentPlayer(int nrSpaces) {
        if(nrSpaces < 1 && nrSpaces > 6){
            return false;
        }
        if(abismos.isEmpty()){
            return false;
        }
        return true;
    }

    public String reactToAbyssOrTool () {

        for (Programmer pos : programmers.values()) {
            if (abismos.containsKey(pos.pos)) {
                return "It is a Abismo";
            }else{
                return "It is a tool";
            }
        }
        return null;
    }

    public boolean gameIsOver() {
        return true;
    }


    public List<String> getGameResults() {
        List<String> results = new ArrayList<String>();

        return results;
    }

    public JPanel getAuthorsPanel() {

        return null;
    }

    public String getProgrammersInfo() {
        List<Integer> progIdsSorted = new ArrayList<>();
        for (Programmer programmer : programmers.values()) {
            //progIdsSorted.sort(programmer.id);
            if (programmer.ferramentas == null) {
                return "" + programmer.name + " : No tools";
            }
            return "" + programmer.name + " | " + programmer.ferramentas;
        }

        return null;
    }


        public String getTitle ( int position){

            return null;
        }
        public boolean saveGame (File file){
            return true;
        }
        public boolean loadGame (File file){
            return true;
        }

    }

