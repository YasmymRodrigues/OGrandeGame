package pt.ulusofona.lp2.deisiGreatGame;

//https://deisi.ulusofona.pt/drop-project/upload/lp2-2122-projecto-especial
//move() + react() + getCurrentPlayerID()
//Note: Um objeto é uma instância - Ocorrência - de uma Classe
//Note: Metódos static só podem referenciar vars ou outro metódo static (Não manipulam Vars do object)
//Note: Quem manipula os metodos da classe são metódos da classe ?
import javax.swing.*;
import java.io.File;
import java.util.*;

import static pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor.*;

public class GameManager {
    int worldSize;
    List<Programmer> programmers = new ArrayList<>();
    List<Ferramenta> ferramentas = new ArrayList<>();
    List<Abismo> abismos = new ArrayList<>();
    List<Object> mapa = new ArrayList<>(); // array com os espaços do mapa


    public GameManager() {}

    public boolean createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) throws InvalidInitialBoardException {

        Set<Integer> progId = new HashSet<>();
        Set<ProgrammerColor> progColor = new HashSet<>();

        int id;
        String nome;
        this.worldSize = worldSize;
        this.mapa = Arrays.asList(new Integer[worldSize]);

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
                programmer.getLanguages().add(language1);
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
            programmer.estado = true;
            programmer.posicoes = new ArrayList<>();
            programmer.posicoes.add(programmer.pos);
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
                        abismos.add(erroDeSintaxe);
                        mapa.add(position, erroDeSintaxe);
                    } else if (idDoTipo == 1) {
                        Abismo erroDeLogica = new ErroDeLogica("Erro de Logica", 1, position);
                        abismos.add(erroDeLogica);
                        mapa.add(position, erroDeLogica);
                    } else if (idDoTipo == 2) {
                        Abismo exception = new Exception("Exception", 2, position);
                        abismos.add(exception);
                        mapa.add(position, exception);
                    } else if (idDoTipo == 3) {
                        Abismo fileNotFoundException = new FileNotFoundException("FileNotFoundException", 3, position);
                        abismos.add(fileNotFoundException);
                        mapa.add(position, fileNotFoundException);
                    } else if (idDoTipo == 4) {
                        Abismo crash = new Crash("Crash", 4, position);
                        abismos.add(crash);
                        mapa.add(position, crash);
                    } else if (idDoTipo == 5) {
                        Abismo duplicatedCode = new DuplicatedCode("DulicatedCode", 5, position);
                        abismos.add(duplicatedCode);
                        mapa.add(position, duplicatedCode);
                    } else if (idDoTipo == 6) {
                        Abismo efeitosSecundarios = new EfeitosSecundarios("EfeitosSecundarios", 6, position);
                        abismos.add(efeitosSecundarios);
                        mapa.add(position, efeitosSecundarios);
                    } else if (idDoTipo == 7) {
                        Abismo bsod = new BlueScreenOfDeath("BlueScreenOfDeath", 7, position);
                        abismos.add(bsod);
                        mapa.add(position, bsod);
                    } else if (idDoTipo == 8) {
                        Abismo cicloInfinito = new CicloInfinito("CicloInfinito", 8, position);
                        abismos.add(cicloInfinito);
                        mapa.add(position, cicloInfinito);
                    } else if (idDoTipo == 9) {
                        Abismo segF = new SegmentationFault("SegmentationFault", 9, position);
                        abismos.add(segF);
                        mapa.add(position, segF);
                    } else {
                        System.out.println("Not an abismo found");
                    }
                }
                if(type == 1) {
                    if (idDoTipo == 0) {
                        Ferramenta heranca = new Heranca("Herança", 0, position);
                        ferramentas.add(heranca);
                        mapa.add(heranca);
                    } else if (idDoTipo == 1) {
                        Ferramenta progF = new ProgramacaoFuncional("Prog Funtional", 1, position);
                        ferramentas.add(progF);
                        mapa.add(progF);
                    } else if (idDoTipo == 2) {
                        Ferramenta unitarios = new Unitarios("Unitarios", 2, position);
                        ferramentas.add(unitarios);
                        mapa.add(unitarios);
                    } else if (idDoTipo == 3) {
                        Ferramenta tratEx = new TratamentoDeExcepcoes("TratamentoDeExcepcoes", 3, position);
                        ferramentas.add(tratEx);
                        mapa.add(tratEx);
                    } else if (idDoTipo == 4) {
                        Ferramenta ide = new IDE("IDE", 4, position);
                        ferramentas.add(ide);
                        mapa.add(ide);
                    } else if (idDoTipo == 5) {
                        Ferramenta helpProf = new AjudaDoProfessor("AjudaDoProfessor", 5, position);
                        ferramentas.add(helpProf);
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
            if(includeDefeated){ // True todos os jogadores já existentes
               programmerList = programmers;
            }else{
                for (Programmer programmer: programmers){
                    if (programmer.estado == true){
                        programmerList.add(programmer);
                    }
                }
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

         return 1;
    }

    public boolean moveCurrentPlayer(int nrSpaces) {

        if(nrSpaces < 1 || nrSpaces > 6){
            return false;
        }
        int playerAtual = getCurrentPlayerID();
        /*for (Abismo abismo: abismos){
            if (abismo.pos == playerAtual){
                return false;
            }
        }*/

        for (Programmer programmer: getProgrammers(false)){
                if (programmer.id == playerAtual){
                    int pos = programmer.pos;
                    int move = pos + nrSpaces;
                    if (move < worldSize) {
                        programmer.pos += nrSpaces;
                        programmer.posicoes.add(programmer.pos);
                    }
                }
        }

        return true;
    }

    public String reactToAbyssOrTool () {
         //TODO: Confirmation about go forward
        //TODO: Confirmation about go back
        //Note: Apenas reações as Ferramentas e Abismos


            for (int i = 1; i < worldSize; i++) { //percorre o world
                if (mapa.get(i) != null) { // se o espaço no mapa não são blank então é uma tool ou abismo. Mas quando já há um player lá ?
                    for (Programmer programmer : getProgrammers(false)) {
                    /*if (programmer.pos == ferramentas.get(i).pos){
                        if(ferramentas.get(i).idFerramenta == 0){
                            programmer.ferramentas.add(ferramentas.get(i));
                            return "Herança - You have a new tool";
                        }
                    }*/
                        if (programmer.pos == abismos.get(i).pos) {
                            if (abismos.get(i).idAbismo == 0) {
                                if(programmer.pos - 1 > 0) {
                                    programmer.pos--;
                                    programmer.estado = false;
                                    return "Erro de Sintaxe - go back one space";
                                }else{
                                    return "Erro de Sintaxe - stay in the same space";
                                }
                            } else if (abismos.get(i).idAbismo == 1) {
                                //todo: make the reaction - posição atual - numero de espaços oferecidos pela função move ?
                                if((programmer.pos / 2) > 0) { // todo= salvar os valores em uma variavel que eu passo e diminuo, variavel global ???
                                    programmer.estado = false;
                                    return "Erro de Lógica - go back space(s)";
                                }else{
                                    return "Erro de Lógica - stay in the same space";
                                }
                            }
                            }else if(abismos.get(i).idAbismo == 2){
                                if(programmer.pos - 2 > 0) {
                                    programmer.estado = false;
                                    return "Exception - go back 2 space(s)";
                                }else{
                                    return "Exception - stay in the same space";

                                }
                            }else if(abismos.get(i).idAbismo == 3){
                                if(programmer.pos - 3 > 0){
                                    programmer.pos -= 3;
                                    programmer.estado = false;
                                    return "File Not Found Exception - go back 3 spaces";
                                }else{
                                    return "File Not Found Exception - stay in the same space";
                                }
                            }else if(abismos.get(i).idAbismo == 4){
                                programmer.pos = 1;
                                programmer.estado = false;
                                return "Crash - go back to the first space";

                            }else if(abismos.get(i).idAbismo == 5){
                                programmer.pos = programmer.posicoes.get(0);
                                programmer.estado = false;
                                return "Duplicated Code - Go back to your last position.";

                            }else if(abismos.get(i).idAbismo == 6){
                                programmer.pos = programmer.posicoes.get(1);
                                programmer.estado = false;
                                return "Secondary Efects - Go back to your second last position";

                            }else if(abismos.get(i).idAbismo == 7){
                                programmer.estado = false;
                                programmers.remove(programmer);

                                return "Blue Screen of Death - Fail";

                            }else if(abismos.get(i).idAbismo == 8){
                            //Todo: Não entendi essa parte, pois na função move() eu já mando o programador para lá. Ou seja sempre vai ter alguém lá.
                                /*if (mapa.contains(programmer)){

                                }*/

                            }else if(abismos.get(i).idAbismo == 9){

                          }
                        }
                    }
                }

            return "Nothing";
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

