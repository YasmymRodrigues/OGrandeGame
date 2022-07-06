package pt.ulusofona.lp2.deisiGreatGame;

//https://deisi.ulusofona.pt/drop-project/upload/lp2-2122-projecto-especial
//move() + react() + getCurrentPlayerID()
//Note: Um objeto é uma instância - Ocorrência - de uma Classe
//Note: Metódos static só podem referenciar vars ou outro metódo static (Não manipulam Vars do object)
//Note: Quem manipula os metodos da classe são metódos da classe ?
import pt.ulusofona.lp2.deisiGreatGame.abismos.*;
import pt.ulusofona.lp2.deisiGreatGame.abismos.Exception;
import pt.ulusofona.lp2.deisiGreatGame.tools.*;

import javax.swing.*;
import java.io.File;
import java.util.*;

import static pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor.*;

public class GameManager {
    int worldSize;
    List<Programmer> programmers = new ArrayList<>();
    List<Ferramenta> ferramentas = new ArrayList<>();
    List<Abismo> abismos = new ArrayList<>();
    HashMap<Integer, Object> map = new HashMap<>(); // array com os espaços do mapa
    Programmer programmerActual = new Programmer();


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
            programmer.posicoes = new ArrayList<>();
            programmer.posicoes.add(programmer.pos);
            programmer.setEstado(true);
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
                        map.put(position,erroDeSintaxe);
                    } else if (idDoTipo == 1) {
                        Abismo erroDeLogica = new ErroDeLogica("Erro de Lógica", 1, position);
                        abismos.add(erroDeLogica);
                        map.put(position, erroDeLogica);
                    } else if (idDoTipo == 2) {
                        Abismo exception = new Exception("Exception", 2, position);
                        abismos.add(exception);
                        map.put(position, exception);
                    } else if (idDoTipo == 3) {
                        Abismo fileNotFoundException = new FileNotFoundException("FileNotFoundException", 3, position);
                        abismos.add(fileNotFoundException);
                        map.put(position, fileNotFoundException);
                    } else if (idDoTipo == 4) {
                        Abismo crash = new Crash("Crash", 4, position);
                        abismos.add(crash);
                        map.put(position,crash);
                    } else if (idDoTipo == 5) {
                        Abismo duplicatedCode = new DuplicatedCode("DuplicatedCode", 5, position);
                        abismos.add(duplicatedCode);
                        map.put(position,duplicatedCode);
                    } else if (idDoTipo == 6) {
                        Abismo efeitosSecundarios = new EfeitosSecundarios("EfeitosSecundarios", 6, position);
                        abismos.add(efeitosSecundarios);
                        map.put(position,efeitosSecundarios);
                    } else if (idDoTipo == 7) {
                        Abismo bsod = new BlueScreenOfDeath("BlueScreenOfDeath", 7, position);
                        abismos.add(bsod);
                        map.put(position,bsod);
                    } else if (idDoTipo == 8) {
                        Abismo cicloInfinito = new CicloInfinito("CicloInfinito", 8, position);
                        abismos.add(cicloInfinito);
                        map.put(position,cicloInfinito);
                    } else if (idDoTipo == 9) {
                        Abismo segF = new SegmentationFault("SegmentationFault", 9, position);
                        abismos.add(segF);
                        map.put(position,segF);
                    } else {
                        System.out.println("Not an abismo found");
                    }
                }
                if(type == 1) {
                    if (idDoTipo == 0) {
                        Ferramenta heranca = new Heranca("Herança", 0, position);
                        ferramentas.add(heranca);
                        map.put(position,heranca);
                    } else if (idDoTipo == 1) {
                        Ferramenta progF = new ProgramacaoFuncional("Prog Funcional", 1, position);
                        ferramentas.add(progF);
                        map.put(position,progF);
                    } else if (idDoTipo == 2) {
                        Ferramenta unitarios = new Unitarios("Unitários", 2, position);
                        ferramentas.add(unitarios);
                        map.put(position,unitarios);
                    } else if (idDoTipo == 3) {
                        Ferramenta tratEx = new TratamentoDeExcepcoes("TratamentoDeExceções", 3, position);
                        ferramentas.add(tratEx);
                        map.put(position,tratEx);
                    } else if (idDoTipo == 4) {
                        Ferramenta ide = new IDE("IDE", 4, position);
                        ferramentas.add(ide);
                        map.put(position, ide);
                    } else if (idDoTipo == 5) {
                        Ferramenta helpProf = new AjudaDoProfessor("AjudaDoProfessor", 5, position);
                        ferramentas.add(helpProf);
                        map.put(position, helpProf);
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

    //Note: Programmers em Jogo OU todos
    public List<Programmer> getProgrammers(boolean includeDefeated) {
        List<Programmer> programmerList = new ArrayList<>();
            if(includeDefeated){ // True todos os jogadores já existentes
               programmerList = programmers;
            }else{
                for (Programmer programmer: programmers){
                    if (programmer.isEstado() == true){
                        programmerList.add(programmer);
                    }
                }
            }
        return programmerList;
    }

    //Note: Programmers na position X
    public List<Programmer> getProgrammers(int position) {
        List<Programmer> programmersList = new ArrayList<>();
        for (Programmer programmer: programmers){
            if(programmer.getPos() == position){
                programmersList.add(programmer);
            }
        }
        return programmersList;
    }


    //Note: Player actual --> ID
    public int getCurrentPlayerID() {
        List<Programmer> sortedProg = getProgrammers(false);
        Collections.sort(sortedProg, Comparator.comparing(Programmer::getId));

        for(Programmer programmer: sortedProg) {
            if (programmer.isHasTurn()) {
                programmer.setHasTurn(false);
                programmerActual = programmer;
                return 1;
            }
        }
        for (Programmer programmer: sortedProg){
            programmer.setHasTurn(true);
        }
        programmerActual = sortedProg.get(0);
        programmerActual.setHasTurn(false);
        /*sortedProg.forEach(programmer -> {
            if (programmer.isEstado() == true){
                programmer.setEstado(false);
                programadorAtual = programmer;
                programadorAtual.getId();
            }
          }
        );*/
        return 1;

    }

    //Note: Move
    public boolean moveCurrentPlayer(int nrSpaces) {

        if(nrSpaces < 1 || nrSpaces > 6){
            return false;
        }

       /*for (Abismo abismo: abismos){
            if (abismo.getPos() == getCurrentPlayerID()){
                return false;
            }
        }*/
       //getCurrentPlayerID();
        /*for (Programmer programmer: getProgrammers(false)){ // devia chamar a outra
            if (programmer.getId() == getCurrentPlayerID()){
                int pos = programmer.getPos();
                int move = pos + nrSpaces;
                List<Integer> posicoesList = programmer.getPosicoes();
                if (move < worldSize) {
                    int newPos = programmer.getPos();
                    newPos += nrSpaces;
                    programmer.setPos(newPos);
                    posicoesList.add(newPos);
                    //programmer.posicoes.add(programmer.pos);
                    programmer.setPosicoes(posicoesList);
                }
            }
        }*/
        getCurrentPlayerID();
        List<Integer> posicoes = new ArrayList<>();
        int pos = programmerActual.getPos();
        posicoes.add(pos);
        int move = pos + nrSpaces;
        if (move < worldSize){
            programmerActual.setPos(move);
            posicoes.add(move);
            programmerActual.setPosicoes(posicoes);
        }
        return true;
    }

    //Note: React
    public String reactToAbyssOrTool () {
        //Note: Apenas reações as Ferramentas e Abismos
        //TODO: Confirmation about go forward
        //TODO: Confirmation about go back
        //Todo: Validar a posicao quando já tem um programador lá

        //Hashmap mapa
        //programadorAtual

       /* int programmerActualPos = programmerActual.getPos();
        if (map.get(programmerActualPos) != null){
            Event obj = (Event) map.get(programmerActualPos);
            if(obj.isAbismo()){
                int newPos = obj.getReact(programmerActualPos, programmerActual);
                //programmer.setPos(newPos);
            }else{
                programmerActual.ferramentas.add((Ferramenta)obj);
            }
        }else{
            getCurrentPlayerID();
        }
*/
        for (Programmer programmer: getProgrammers(false)){
            if(programmer.getId() == programmerActual.getId()){
                int pos = programmer.getPos();
                if(map.get(pos) != null){
                     Event obj = (Event) map.get(pos);
                     if(obj.isAbismo()){
                         int newPos = obj.getReact(pos, programmer);
                     }else{
                         programmer.ferramentas.add((Ferramenta)obj);
                     }
                }else{
                    getCurrentPlayerID();
                }
            }
        }
        return null;
    }


    public boolean gameIsOver() {
        return false;
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
            if(ferramenta.getPos() == position){
                return ferramenta.getNome();
            }
        }
        for(Abismo abismo: abismos){
            if (abismo.getPos()== position){
                return abismo.getNome();
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
