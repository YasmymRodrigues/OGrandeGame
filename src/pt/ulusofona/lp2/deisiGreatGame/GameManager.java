package pt.ulusofona.lp2.deisiGreatGame;

//https://deisi.ulusofona.pt/drop-project/upload/lp2-2122-projecto-especial
//move() + react() + getCurrentPlayerID()
//Note: Um objeto é uma instância - Ocorrência - de uma Classe
//Note: Metódos static só podem referenciar vars ou outro metódo static (Não manipulam Vars do object)
//Note: Quem manipula os metodos da classe são metódos da classe ?
//create - apenas 1x
//em cada turno (por esta ordem):
//- getProgrammers() + getCurrentPlayerId() - para mostrar o jogador atual junto ao dado
//- move - pode retornar true ou false. o retorno só influencia a mensagem "Não é possível mover este jogador"
//- react - sempre chamado, quer o move dê true quer dê false. << aqui muda o turno
//- gameIsOver



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
    Programmer currentPlayer = new Programmer();


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

            // todos os programadores começam na posição 1
            programmer.setPos(1);
            //Iniciar a lista de posicoes
            List<Integer> firstPos = new ArrayList<>();
            firstPos.add(1);
            programmer.setPosicoes(firstPos);
            //Estado
            programmer.setEstado(true);
            //Add programmers to the list
            programmers.add(programmer);
            //Sorting the programmers
            Collections.sort(programmers, Comparator.comparing(Programmer::getId));
            //get the first position
            currentPlayer = programmers.get(0);
            //the first programmer gonna be call first
            currentPlayer.setHasTurn(true);

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
                        Abismo erroDeSintaxe = new ErroDeSintaxe("Erro de sintaxe", 0, position);
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
                        Abismo bsod = new BSOD("BlueScreenOfDeath", 7, position);
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
                        Ferramenta progF = new ProgramacaoFuncional("Programação Funcional", 1, position);
                        ferramentas.add(progF);
                        map.put(position,progF);
                    } else if (idDoTipo == 2) {
                        Ferramenta unitarios = new Unitarios("Testes unitários", 2, position);
                        ferramentas.add(unitarios);
                        map.put(position,unitarios);
                    } else if (idDoTipo == 3) {
                        Ferramenta tratEx = new TratamentoDeExcepcoes("Tratamento de Excepções", 3, position);
                        ferramentas.add(tratEx);
                        map.put(position,tratEx);
                    } else if (idDoTipo == 4) {
                        Ferramenta ide = new IDE("IDE", 4, position);
                        ferramentas.add(ide);
                        map.put(position, ide);
                    } else if (idDoTipo == 5) {
                        Ferramenta helpProf = new AjudaDoProfessor("Ajuda do Professor", 5, position);
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

        Event obj = (Event) map.get(position);
        if (map.get(position) != null) {
            switch (obj.nome) {
                case "Ajuda do Professor":
                    return "ajuda-professor.png";
                case "Herança":
                    return "inheritance.png";
                case "IDE":
                    return "IDE.png";
                case "Programação Funcional":
                    return "functional.png";
                case "Tratamento de Excepções":
                    return "catch.png";
                case "Testes unitários":
                    return "unit-tests.png";
                case "BlueScreenOfDeath":
                    return "bsod.png";
                case "CicloInfinito":
                    return "infinite-loop.png";
                case "Crash":
                    return "crash.png";
                case "DuplicatedCode":
                    return "duplicated-code.png";
                case "EfeitosSecundarios":
                    return "secondary-effects.png";
                case "Erro de Lógica":
                    return "logic.png";
                case "Erro de Sintaxe":
                    return "syntax.png";
                case "Exception":
                    return "exception.png";
                case "FileNotFoundException":
                    return "file-not-found-exception.png";
                case "SegmentationFault":
                    return "core-dumped.png";
                case "Glory":
                    return "glory.png";
            }
        }
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
      return currentPlayer.getId();
    }

    public Programmer changeTurn(){

        List<Programmer> activeProgrammers = getProgrammers(false);

        for (Programmer programmer: activeProgrammers){
            if (!programmer.isHasTurn()){
                programmer.setHasTurn(true);
                currentPlayer = programmer;

                return currentPlayer;
            }
        }

        for (Programmer programmer: activeProgrammers){
            programmer.setHasTurn(false);
        }

        currentPlayer = activeProgrammers.get(0);
        currentPlayer.setHasTurn(true);

        return currentPlayer;
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


        int pos = currentPlayer.getPos();
        int move = pos + nrSpaces;
        if (currentPlayer.estado == true) {
            if (move < worldSize) {
                currentPlayer.setPos(move);
                currentPlayer.addPosicoes(move);
            } else {
                int spacesBack = worldSize - currentPlayer.getPos() - nrSpaces;
                int newPos = worldSize + spacesBack;
                currentPlayer.setPos(newPos);
                currentPlayer.addPosicoes(newPos);
            }
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

       int programmerActualPos = currentPlayer.getPos();
        if (map.get(programmerActualPos) != null){
            Event obj = (Event) map.get(programmerActualPos);
            if(obj.isAbismo()){
                int newPos = obj.getReact(programmerActualPos, currentPlayer);
                currentPlayer.setPos(newPos);
                currentPlayer.addPosicoes(newPos);
                changeTurn();
                return "trap";
            }else{
                //currentPlayer.getFerramentas();
                currentPlayer.ferramentas.add((Ferramenta)obj);
                changeTurn();
                return "you got a tool";
            }
        }

        changeTurn();
        return null;
    }


    public boolean gameIsOver() {
        if (getProgrammers(false).size() < 2){
            return true;
        }
        if (currentPlayer.getPos() == worldSize){
            return true;
        }
        //BSOD
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
        String resultado = "";
        String tool = "";

        for (Programmer programmer : getProgrammers(false)) {
            if (!programmer.getFerramentas().isEmpty()) {
                for(Ferramenta ferramenta: programmer.getFerramentas()){
                    if (programmer.getFerramentas().size() == 1){
                        tool = ferramenta.getNome();
                    }else {
                        tool += ferramenta.getNome() + ";";
                    }
                }
                resultado += "" + programmer.getName() + " : " + tool + " | ";
            }else {
                resultado += "" + programmer.getName() + " : No tools | ";
            }
        }

        return resultado;
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
