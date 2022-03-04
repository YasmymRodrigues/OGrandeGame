package pt.ulusofona.lp2.deisiGreatGame;

//https://deisi.ulusofona.pt/drop-project/upload/lp2-2122-projecto-especial
//move () + react () + getCurrentPlayerID()
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor.*;

public class GameManager {
    String[][] playerInfo;
    String[][] abyssesAndTools;
    int worldSize;
    List<Integer> positions = new ArrayList<>();
    List<Ferramenta> ferramentas = new ArrayList<>();
    List<Programmer> programmers = new ArrayList<>();
    List<Abismo> abismos = new ArrayList<>();



    public GameManager() {
    }

    public GameManager(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) {
        this.playerInfo = playerInfo;
        this.worldSize = worldSize;
        this.abyssesAndTools = abyssesAndTools;
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
            programmers.add(programmer);
        }

        for (Programmer pro : programmers) {
            if (!progId.add(pro.id) || (pro.id < 0)) { //todo I am not sure about this range
                return false;
            }
            if ((pro.name == null) || (pro.name.isEmpty())) {
                return false;
            }
            if (pro.color != BLUE || pro.color != PURPLE || pro.color != BROWN || pro.color != GREEN) {
                return false;
            }
            if (!progColor.add(pro.color)) {
                return false;
            }
            if ((programmers.size() > 4) || (worldSize >= programmers.size() * 2)) {
                return false;
            }
        }

        /*//Note: abyssesAndTools
        if (abyssesAndTools != null) {
        for (String[] arr : abyssesAndTools) {
                int type = Integer.parseInt(arr[0]);
                int idDoTipo = Integer.parseInt(arr[1]);
                int position = Integer.parseInt(arr[2]);
                this.positions.add(position);
                if (type == 0) {
                    if (idDoTipo == 0) {
                        Abismo erroDeSintaxe = new ErroDeSintaxe();
                        abismos.add(erroDeSintaxe);
                    } else if (idDoTipo == 1) {
                        Abismo erroDeLogica = new ErroDeLogica();
                        abismos.add(erroDeLogica);
                    } else if (idDoTipo == 2) {
                        Abismo exception = new Exception();
                        abismos.add(exception);
                    } else if (idDoTipo == 3) {
                        Abismo fileNotFoundException = new FileNotFoundException();
                        abismos.add(fileNotFoundException);
                    } else if (idDoTipo == 4) {
                        Abismo crash = new Crash();
                        abismos.add(crash);
                    } else if (idDoTipo == 5) {
                        Abismo duplicatedCode = new DuplicatedCode();
                        abismos.add(duplicatedCode);
                    } else if (idDoTipo == 6) {
                        Abismo efeitosSecundarios = new EfeitosSecundarios();
                        abismos.add(efeitosSecundarios);
                    } else if (idDoTipo == 7) {
                        Abismo bsod = new BlueScreenOfDeath();
                        abismos.add(bsod);
                    } else if (idDoTipo == 8) {
                        Abismo cicloInfinito = new CicloInfinito();
                        abismos.add(cicloInfinito);
                    } else if (idDoTipo == 9) {
                        Abismo segF = new SegmentationFault();
                        abismos.add(segF);
                    } else {
                        System.out.println("Not an abismo");
                    }
                } else {
                    if (idDoTipo == 0) {
                        Ferramenta heranca = new Heranca();
                        ferramentas.add(heranca);
                    } else if (idDoTipo == 1) {
                        Ferramenta progF = new ProgramacaoFuncional();
                        ferramentas.add(progF);
                    } else if (idDoTipo == 2) {
                        Ferramenta unitarios = new Unitarios();
                        ferramentas.add(unitarios);
                    } else if (idDoTipo == 3) {
                        Ferramenta tratEx = new TratamentoDeExcepcoes();
                        ferramentas.add(tratEx);
                    } else if (idDoTipo == 4) {
                        Ferramenta ide = new IDE();
                        ferramentas.add(ide);
                    } else if (idDoTipo == 5) {
                        Ferramenta helpProf = new AjudaDoProfessor();
                        ferramentas.add(helpProf);
                    }
                  //note add ferramentas where ?
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
        }*/
        return true;
    }

    public boolean createInitialBoard(String[][] playerInfo, int worldSize) throws InvalidInitialBoardException {
        return createInitialBoard(playerInfo, worldSize, null);
    }

     public String getImagePng(int position) {
        return "blank.png";
    }

    public List<Programmer> getProgrammers(boolean includeDefeated) {
        return programmers;
    }

    public List<Programmer> getProgrammers(int position) {
        List<Programmer> programmersList = new ArrayList<>();
        for (Programmer programmer: programmers){
            if(programmer.getPos() == position){
                programmersList.add(programmer);
            }else{
                return null;
                //todo: verificação position is invalid OR não existe programadores na posicao indicada
            }
        }
        return programmersList;
    }


    public int getCurrentPlayerID() {
        int id = 0;
        for (Programmer programmer : programmers) {
            id = programmer.getId();
            return id;
        }
        return id;
    }

    public boolean moveCurrentPlayer(int position) {

        return true;
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
        for (Programmer programmer : programmers) {
            //progIdsSorted.sort(programmer.id);
            if (programmer.ferramentas == null) {
                return "" + programmer.name + " : No tools";
            }
            return "" + programmer.name + " | " + programmer.ferramentas;
        }

        return null;
    }

        public String reactToAbyssOrTool () {
            return "";
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

