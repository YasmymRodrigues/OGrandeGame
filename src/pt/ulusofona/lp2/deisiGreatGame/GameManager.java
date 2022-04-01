package pt.ulusofona.lp2.deisiGreatGame;

//https://deisi.ulusofona.pt/drop-project/upload/lp2-2122-projecto-especial
//move () + react () + getCurrentPlayerID()
import javax.swing.*;
import java.io.File;
import java.util.*;

import static pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor.*;

public class GameManager {
    int worldSize;
    List<Programmer> programmers = new ArrayList<>();
    List<Ferramenta> ferramentas = new ArrayList<>();
    List<Abismo> abismos = new ArrayList<>();
    List<Object> mapa = new ArrayList<>();
    List<Integer> positions = new ArrayList<>();



    public GameManager() {}

    public boolean createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) throws InvalidInitialBoardException {

        Set<Integer> progId = new HashSet<>();
        Set<ProgrammerColor> progColor = new HashSet<>();

        int id;
        String nome;
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
                        Abismo erroDeSintaxe = new ErroDeSintaxe("Erro de Sintaxe", 0, position);
                        abismos.add(0, erroDeSintaxe);
                        mapa.add(erroDeSintaxe);
                    } else if (idDoTipo == 1) {
                        Abismo erroDeLogica = new ErroDeLogica("Erro de Logica", 1, position);
                        abismos.add(1, erroDeLogica);
                        mapa.add(erroDeLogica);
                    } else if (idDoTipo == 2) {
                        Abismo exception = new Exception("Exception", 2, position);
                        abismos.add(2, exception);
                        mapa.add(exception);
                    } else if (idDoTipo == 3) {
                        Abismo fileNotFoundException = new FileNotFoundException("FileNotFoundException", 3, position);
                        abismos.add(3, fileNotFoundException);
                        mapa.add(fileNotFoundException);
                    } else if (idDoTipo == 4) {
                        Abismo crash = new Crash("Crash", 4, position);
                        abismos.add(4, crash);
                        mapa.add(crash);
                    } else if (idDoTipo == 5) {
                        Abismo duplicatedCode = new DuplicatedCode("DulicatedCode", 5, position);
                        abismos.add(5, duplicatedCode);
                        mapa.add(duplicatedCode);
                    } else if (idDoTipo == 6) {
                        Abismo efeitosSecundarios = new EfeitosSecundarios("EfeitosSecundarios", 6, position);
                        abismos.add(6, efeitosSecundarios);
                        mapa.add(efeitosSecundarios);
                    } else if (idDoTipo == 7) {
                        Abismo bsod = new BlueScreenOfDeath("BlueScreenOfDeath", 7, position);
                        abismos.add(7, bsod);
                        mapa.add(bsod);
                    } else if (idDoTipo == 8) {
                        Abismo cicloInfinito = new CicloInfinito("CicloInfinito", 8, position);
                        abismos.add(8, cicloInfinito);
                        mapa.add(cicloInfinito);
                    } else if (idDoTipo == 9) {
                        Abismo segF = new SegmentationFault("SegmentationFault", 9, position);
                        abismos.add(9, segF);
                        mapa.add(segF);
                    } else {
                        System.out.println("Not an abismo found");
                    }
                }
                if(type == 1) {
                    if (idDoTipo == 0) {
                        Ferramenta heranca = new Heranca("Herança", 0, position);
                        ferramentas.add(0, heranca);
                        mapa.add(heranca);
                    } else if (idDoTipo == 1) {
                        Ferramenta progF = new ProgramacaoFuncional("Prog Funtional", 1, position);
                        ferramentas.add(1, progF);
                        mapa.add(progF);
                    } else if (idDoTipo == 2) {
                        Ferramenta unitarios = new Unitarios("Unitarios", 2, position);
                        ferramentas.add(2, unitarios);
                        mapa.add(unitarios);
                    } else if (idDoTipo == 3) {
                        Ferramenta tratEx = new TratamentoDeExcepcoes("TratamentoDeExcepcoes", 3, position);
                        ferramentas.add(3, tratEx);
                        mapa.add(tratEx);
                    } else if (idDoTipo == 4) {
                        Ferramenta ide = new IDE("IDE", 4, position);
                        ferramentas.add(4, ide);
                        mapa.add(ide);
                    } else if (idDoTipo == 5) {
                        Ferramenta helpProf = new AjudaDoProfessor("AjudaDoProfessor", 5, position);
                        ferramentas.add(5, helpProf);
                        mapa.add(helpProf);
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
        for(Programmer pro: programmers){
            if(includeDefeated == true ){
                programmerList.add(pro);
            } //note: não entendi bem essa função
        }
        return programmerList;
    }

    public List<Programmer> getProgrammers(int position) {
        List<Programmer> programmersList = new ArrayList<>();
        for (Programmer programmer: programmers){
            if(programmer.pos == position){
                programmersList.add(programmer);
            }
        }
        return programmersList;
    }


    public int getCurrentPlayerID() {
        return 0;
    }

    public boolean moveCurrentPlayer(int nrSpaces) {

        if(nrSpaces < 1 || nrSpaces > 6){
            return false;
        }

       /* for (Abismo abs: abismos) {
            for (Programmer pro : programmers) {
                if (abs.pos == pro.pos) {
                    return false;
                }
            }
        }*/
        return true;
    }

    public String reactToAbyssOrTool () {
        Random random = new Random();
        int dice = random.nextInt(7);
        //TODO: Confirmation about go forward
        //TODO: Confirmation about go back
        //NOTE: How to save the last positions of each programmer ?
        //NOTE: The dice is here or in Move() ?


            for (int i = 1; i < mapa.size(); i++) {
                if (mapa.get(i) != null) {
                    for (Programmer programmer : getProgrammers(i)) {
                    /*if (programmer.pos == ferramentas.get(i).pos){
                        if(ferramentas.get(i).idFerramenta == 0){
                            programmer.ferramentas.add(ferramentas.get(i));
                            return "Herança - You have a new tool";
                        }
                    }else */
                        if (programmer.pos == abismos.get(i).pos) {
                            if (abismos.get(i).idAbismo == 0) {
                                if(programmer.pos - 1 > 0) {
                                    programmer.pos--;
                                    return "Erro de Sintaxe - go back one space";
                                }
                            } else if (abismos.get(i).idAbismo == 1) {
                                int n = dice / 2;
                                if(programmer.pos - n > 0) {
                                    programmer.pos -= n;
                                    return "Erro de Lógica - go back " + n + " space(s)";
                                }
                            }else if(abismos.get(i).idAbismo == 2){
                                if(programmer.pos - 2 > 0) {
                                    programmer.pos -= 2;
                                    return "Exception - go back 2 space(s)";
                                }
                            }else if(abismos.get(i).idAbismo == 3){
                                if(programmer.pos - 3 > 0){
                                    programmer.pos -= 3;
                                }
                            }else if(abismos.get(i).idAbismo == 4){
                                programmer.pos = 1;

                            }else if(abismos.get(i).idAbismo == 5){

                            }else if(abismos.get(i).idAbismo == 6){

                            }else if(abismos.get(i).idAbismo == 7){
                                programmers.remove(programmer);

                            }else if(abismos.get(i).idAbismo == 8){

                            }else if(abismos.get(i).idAbismo == 9){

                            }
                        } else {
                            return "Empty";
                        }
                    }
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
        for (Programmer programmer : programmers) {
            //progIdsSorted.sort(programmer.id);
            if (programmer.ferramentas == null) {
                return "" + programmer.name + " : No tools";
            }
            return "" + programmer.name + " | " + programmer.ferramentas;
        }

        return null;
    }


        public String getTitle (int position){

        for(Ferramenta ferramenta: ferramentas){
            if(ferramenta.pos == position){
                return ferramenta.nome;
            }
        }
        for(Abismo abismo: abismos){
            if (abismo.pos == position){
                return abismo.nome;
            }
        }

        return null;
        }


        public boolean saveGame (File file){
            return true;
        }
        public boolean loadGame (File file){
            return true;
        }

    }

