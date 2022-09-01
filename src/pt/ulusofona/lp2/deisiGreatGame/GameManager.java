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
import pt.ulusofona.lp2.deisiGreatGame.abismos.FileNotFoundException;
import pt.ulusofona.lp2.deisiGreatGame.tools.*;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
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

    public void createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) throws InvalidInitialBoardException {

        Set<Integer> progId = new HashSet<>();
        Set<ProgrammerColor> progColor = new HashSet<>();
        InvalidInitialBoardException ex = new InvalidInitialBoardException("Erro");

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
            String[] arrayLanguage = nomesLanguage.split("[;,]");
            List<Language> arrLang = new ArrayList<>();
            for (String lang : arrayLanguage) {
                Language language1 = new Language(lang);
                arrLang.add(language1);
            }
            programmer.setLanguages(arrLang);

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
            //the first programmer going to be call first
            currentPlayer.setHasTurn(true);

        }

        for (Programmer pro : programmers) {
            if (progId.add(pro.id) || pro.id <= 0) {      // não pode ter dois programadores com o mesmo ID
                throw new InvalidInitialBoardException("Erro"); // id smaller than 0
            }
            if ((pro.name == null) || (pro.name.isEmpty())) { //name == null
                throw new InvalidInitialBoardException("Erro");     //name.isEmpty()
            }
            if (pro.color != BLUE && pro.color != PURPLE && pro.color != BROWN && pro.color != GREEN) {  //color be different of the 4 types
                throw new InvalidInitialBoardException("Erro");
            }
            if (!progColor.add(pro.color)) { // add new colar means
                throw new InvalidInitialBoardException("Erro");
            }
            //DONE: Number of players
            if ((programmers.size() > 4) || programmers.size() < 2) {
                throw new InvalidInitialBoardException("Número de jogadores inválido.");
            }
            //DONE:Validation worldSize
            if ((worldSize < (programmers.size() * 2))){
                throw new InvalidInitialBoardException("Tamanho inválido.");
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
                        Abismo erroDeSintaxe = new ErroDeSintaxe(0, position);
                        abismos.add(erroDeSintaxe);
                        map.put(position, erroDeSintaxe);
                    } else if (idDoTipo == 1) {
                        Abismo erroDeLogica = new ErroDeLogica(1, position);
                        abismos.add(erroDeLogica);
                        map.put(position, erroDeLogica);
                    } else if (idDoTipo == 2) {
                        Abismo exception = new Exception( 2, position);
                        abismos.add(exception);
                        map.put(position, exception);
                    } else if (idDoTipo == 3) {
                        Abismo fileNotFoundException = new FileNotFoundException( 3, position);
                        abismos.add(fileNotFoundException);
                        map.put(position, fileNotFoundException);
                    } else if (idDoTipo == 4) {
                        Abismo crash = new Crash(4, position);
                        abismos.add(crash);
                        map.put(position, crash);
                    } else if (idDoTipo == 5) {
                        Abismo duplicatedCode = new DuplicatedCode( 5, position);
                        abismos.add(duplicatedCode);
                        map.put(position, duplicatedCode);
                    } else if (idDoTipo == 6) {
                        Abismo efeitosSecundarios = new EfeitosSecundarios( 6, position);
                        abismos.add(efeitosSecundarios);
                        map.put(position, efeitosSecundarios);
                    } else if (idDoTipo == 7) {
                        Abismo bsod = new BSOD( 7, position);
                        abismos.add(bsod);
                        map.put(position, bsod);
                    } else if (idDoTipo == 8) {
                        Abismo cicloInfinito = new CicloInfinito( 8, position);
                        abismos.add(cicloInfinito);
                        map.put(position, cicloInfinito);
                    } else if (idDoTipo == 9) {
                        Abismo segF = new SegmentationFault(9, position);
                        abismos.add(segF);
                        map.put(position, segF);
                    } else if (idDoTipo == 10) {
                        Abismo vamosFazerContas = new VamosFazerContas(10, position);
                        abismos.add(vamosFazerContas);
                        map.put(position, vamosFazerContas);
                    }
                }
                if (type == 1) {
                    if (idDoTipo == 0) {
                        Ferramenta heranca = new Heranca(0, position);
                        ferramentas.add(heranca);
                        map.put(position, heranca);
                    } else if (idDoTipo == 1) {
                        Ferramenta progF = new ProgramacaoFuncional( 1, position);
                        ferramentas.add(progF);
                        map.put(position, progF);
                    } else if (idDoTipo == 2) {
                        Ferramenta unitarios = new Unitarios( 2, position);
                        ferramentas.add(unitarios);
                        map.put(position, unitarios);
                    } else if (idDoTipo == 3) {
                        Ferramenta tratEx = new TratamentoDeExcepcoes( 3, position);
                        ferramentas.add(tratEx);
                        map.put(position, tratEx);
                    } else if (idDoTipo == 4) {
                        Ferramenta ide = new IDE( 4, position);
                        ferramentas.add(ide);
                        map.put(position, ide);
                    } else if (idDoTipo == 5) {
                        Ferramenta helpProf = new AjudaDoProfessor( 5, position);
                        ferramentas.add(helpProf);
                        map.put(position, helpProf);
                    }
                }

                    //DONE: Validation ofAoA
                    if ((arr[0] == null)) {
                        throw new InvalidInitialBoardAbyssException("Primeira posição a null", Integer.parseInt(arr[0]));
                    }
                    if (type != 0 && type != 1) {
                        throw new InvalidInitialBoardToolException("Erro no tipo: Abismo ou Ferramenta", type);
                    }
                    if (type == 0) {
                        if (idDoTipo < 0 || idDoTipo > 10) {
                            throw new InvalidInitialBoardToolException("Erro no tipo de Abismo", type);
                        }
                    } else {
                        if (idDoTipo < 0 || idDoTipo > 5) {
                            throw new InvalidInitialBoardException("Erro no tipo de Ferramenta ");
                        }
                    }
                    // DONE: posicao do tabuleiro onde se encontra o Abismo ou a Ferramenta
                    if ((worldSize < position) || (arr[2] == null) || (position < 0)) {
                        throw new InvalidInitialBoardException("Erro no tamanho do mapa");
                    }
                }
            }
        }


    public void createInitialBoard(String[][] playerInfo, int worldSize) throws InvalidInitialBoardException {
        createInitialBoard(playerInfo, worldSize, null);
    }

    public String getImagePng(int position) {

        Event obj = (Event) map.get(position);
        if (map.get(position) != null) {
            if(obj.isAbismo()){
                switch (obj.id){
                    case 0:
                        return "syntax.png";
                    case 1:
                        return "logic.png";
                    case 2:
                        return "exception.png";
                    case 3:
                        return "file-not-found-exception.png";
                    case 4:
                        return "crash.png";
                    case 5:
                        return "duplicated-code.png";
                    case 6:
                        return "secondary-effects.png";
                    case 7:
                        return "bsod.png";
                    case 8:
                        return "infinite-loop.png";
                    case 9:
                        return "core-dumped.png";
                    case 10:
                        return "unknownPiece.png";
                  }
            }else {
                switch (obj.id) {
                    case 0:
                        return "inheritance.png";
                    case 1:
                        return "functional.png";
                    case 2:
                        return "unit-tests.png";
                    case 3:
                        return "catch.png";
                    case 4:
                        return "IDE.png";
                    case 5:
                        return "ajuda-professor.png";
                }
            }
        }
        if(position == worldSize) {
            return "glory.png";
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
            programmer.setWasATrap(false);
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
                currentPlayer.setWasATrap(true);
                changeTurn();
                return "trap";
            }else{
                //currentPlayer.getFerramentas();
                currentPlayer.addFerramenta((Ferramenta)obj);
                //currentPlayer.ferramentas.add((Ferramenta)obj);
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
        String player = "";

        for (Programmer programmer : getProgrammers(false)) {
            if (!programmer.getFerramentas().isEmpty()) {
                resultado += "" + programmer.getName() + " : " + programmer.getStringFerramentas() + " | ";
            }else {
                resultado += "" + programmer.getName() + " : No tools | ";
            }
        }
        return resultado;
    }


        public String getTitle (int position){

        for(Ferramenta ferramenta: ferramentas){
            if(ferramenta.getPos() == position){
                return ferramenta.toString();
            }
        }
        for(Abismo abismo: abismos){
            if (abismo.getPos()== position){
                return abismo.toString();
            }
        }
        return null;
    }
        public boolean saveGame (File file){

                try { //note: make validations
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        for (Programmer programmer : getProgrammers(true)) {
                            List<Language> languages = programmer.getLanguages();
                            String lang = programmer.converteArrayParaString(languages);
                            writer.write(programmer.getId() + "," +
                                    programmer.getName() + "," +
                                    programmer.getPos() + "," +
                                    lang + "," +
                                    programmer.getColor() + "," +
                                    programmer.getStatus() + "," +
                                    programmer.getStringFerramentas() + "," +
                                    programmer.getStringPosicoes() + "," +
                                    programmer.isHasTurn() + "\n");
                        }
                        /*writer.write("PlayersTools" + "\n");
                        for (Programmer programmer: getProgrammers(false)){
                            List<Ferramenta> ferramentas = programmer.getFerramentas();
                        }*/


                        writer.write("Abismos"+ "\n");
                        for (Abismo abismo : abismos) {
                            writer.write("" + "0" + "," + abismo.getId() + "," + abismo.getPos() + "\n");
                        }
                        writer.write("Ferramentas"+ "\n");
                        for (Ferramenta ferramenta : ferramentas) {
                            writer.write("" + "1" + "," + ferramenta.getId() + "," + ferramenta.getPos() + "\n");
                        }
                        writer.write("WorldSize" + "\n");
                        writer.write(Integer.toString(worldSize));
                        writer.close();
                } catch (IOException e) {
                    return false;
                }
            return true;
        }


        public boolean loadGame (File file){
        List<Programmer> programmersLoad = new ArrayList<>();
        List<Ferramenta> ferramentasLoad = new ArrayList<>();
        List<Abismo> abismosLoad = new ArrayList<>();
        HashMap<Integer, Object> mapLoad = new HashMap<>(); // array com os espaços do mapa
        int worldSizeLoad = 0;

                try {
                    Scanner reader = new Scanner(file);
                    String line = "";
                    while((line = reader.nextLine()) != null && !"Abismos".equals(line)){
                        String[] strSplit = line.split(",");
                        Programmer programmer = new Programmer();
                        int id = Integer.parseInt(strSplit[0]);
                        programmer.setId(id);
                        String nome = strSplit[1];
                        programmer.setName(nome);
                        int pos = Integer.parseInt(strSplit[2]);
                        programmer.setPos(pos);
                        String lang = strSplit[3];
                        String[] arrLang = lang.split(";");
                        for (String arr: arrLang){
                            Language language = new Language(arr);
                            programmer.getLanguages().add(language);
                        }
                        if (strSplit[4].equals("Blue")) {
                            programmer.setColor(BLUE);
                        } else if (strSplit[4].equals("Purple")) {
                            programmer.setColor(PURPLE);
                        } else if (strSplit[4].equals("Brown")) {
                            programmer.setColor(BROWN);
                        } else if (strSplit[4].equals("Green")) {
                            programmer.setColor(GREEN);
                        }
                        boolean status = programmer.setStatus(strSplit[5]);
                        programmer.setEstado(status);

                        String[] ferr = strSplit[6].split(";");
                        for (String str: ferr){
                            if (str.equals("Herança")){
                                Ferramenta herança = new Heranca(0, 0);
                                programmer.addFerramenta(herança);
                            }
                            else if (str.equals("Programação Funcional")){
                                Ferramenta programacaoFuncional = new ProgramacaoFuncional(1, 0);
                                programmer.addFerramenta(programacaoFuncional);
                            }
                            else if (str.equals("Testes unitários")){
                                Ferramenta testesUnitários = new Unitarios(2, 0);
                                programmer.addFerramenta(testesUnitários);
                            }
                            else if (str.equals("Tratamento de Excepções")){
                                Ferramenta tratamento = new TratamentoDeExcepcoes(3, 0);
                                programmer.addFerramenta(tratamento);
                            }
                            else if (str.equals("IDE")){
                                Ferramenta IDE = new IDE(4, 0);
                                programmer.addFerramenta(IDE);
                            }
                            else if (str.equals("Ajuda do Professor")){
                                Ferramenta ajudaDoProfessor = new AjudaDoProfessor(5, 0);
                                programmer.addFerramenta(ajudaDoProfessor);
                            }
                        }
                        String[] posList = strSplit[7].split(";");
                        List<Integer> posicoes = new ArrayList<>();
                        for (String str: posList){
                            int valuePos = Integer.parseInt(str);
                            posicoes.add(valuePos);
                        }
                        programmer.setPosicoes(posicoes);
                        if (strSplit[8].equals("true")){
                            programmer.setHasTurn(true);
                            currentPlayer = programmer;
                        }else if(strSplit[8].equals("false")) {
                            programmer.setHasTurn(false);
                        }
                        programmersLoad.add(programmer);

                    }
                    programmers = programmersLoad;
                    //Collections.sort(programmers, Comparator.comparing(Programmer::getId));
                    //get the first position
                    //currentPlayer = programmers.get(0);
                    //the first programmer going to be call first
                    //currentPlayer.setHasTurn(true);
                    while((line = reader.nextLine()) != null && !"Ferramentas".equals(line)){
                        String[] strSplit = line.split(",");
                        int type = Integer.parseInt(strSplit[0]);
                        int idDoTipo = Integer.parseInt(strSplit[1]);
                        int position = Integer.parseInt(strSplit[2]);
                        if (type == 0) {
                            if (idDoTipo == 0) {
                                Abismo erroDeSintaxe = new ErroDeSintaxe(0, position);
                                abismosLoad.add(erroDeSintaxe);
                                mapLoad.put(position, erroDeSintaxe);
                            } else if (idDoTipo == 1) {
                                Abismo erroDeLogica = new ErroDeLogica(1, position);
                                abismosLoad.add(erroDeLogica);
                                mapLoad.put(position, erroDeLogica);
                            } else if (idDoTipo == 2) {
                                Abismo exception = new Exception( 2, position);
                                abismosLoad.add(exception);
                                mapLoad.put(position, exception);
                            } else if (idDoTipo == 3) {
                                Abismo fileNotFoundException = new FileNotFoundException( 3, position);
                                abismosLoad.add(fileNotFoundException);
                                mapLoad.put(position, fileNotFoundException);
                            } else if (idDoTipo == 4) {
                                Abismo crash = new Crash(4, position);
                                abismosLoad.add(crash);
                                mapLoad.put(position, crash);
                            } else if (idDoTipo == 5) {
                                Abismo duplicatedCode = new DuplicatedCode( 5, position);
                                abismosLoad.add(duplicatedCode);
                                mapLoad.put(position, duplicatedCode);
                            } else if (idDoTipo == 6) {
                                Abismo efeitosSecundarios = new EfeitosSecundarios( 6, position);
                                abismosLoad.add(efeitosSecundarios);
                                mapLoad.put(position, efeitosSecundarios);
                            } else if (idDoTipo == 7) {
                                Abismo bsod = new BSOD( 7, position);
                                abismosLoad.add(bsod);
                                mapLoad.put(position, bsod);
                            } else if (idDoTipo == 8) {
                                Abismo cicloInfinito = new CicloInfinito( 8, position);
                                abismosLoad.add(cicloInfinito);
                                mapLoad.put(position, cicloInfinito);
                            } else if (idDoTipo == 9) {
                                Abismo segF = new SegmentationFault(9, position);
                                abismosLoad.add(segF);
                                mapLoad.put(position, segF);
                            } else if (idDoTipo == 10) {
                                Abismo vamosFazerContas = new VamosFazerContas(10, position);
                                abismosLoad.add(vamosFazerContas);
                                mapLoad.put(position, vamosFazerContas);
                            }
                        }
                   }
                    abismos = abismosLoad;

                    while((line = reader.nextLine()) != null && !"WorldSize".equals(line)){
                        String[] strSplit = line.split(",");
                        int type = Integer.parseInt(strSplit[0]);
                        int idDoTipo = Integer.parseInt(strSplit[1]);
                        int position = Integer.parseInt(strSplit[2]);
                        if (type == 1) {
                            if (idDoTipo == 0) {
                                Ferramenta heranca = new Heranca(0, position);
                                ferramentasLoad.add(heranca);
                                mapLoad.put(position, heranca);
                            } else if (idDoTipo == 1) {
                                Ferramenta progF = new ProgramacaoFuncional( 1, position);
                                ferramentasLoad.add(progF);
                                mapLoad.put(position, progF);
                            } else if (idDoTipo == 2) {
                                Ferramenta unitarios = new Unitarios( 2, position);
                                ferramentasLoad.add(unitarios);
                                mapLoad.put(position, unitarios);
                            } else if (idDoTipo == 3) {
                                Ferramenta tratEx = new TratamentoDeExcepcoes( 3, position);
                                ferramentasLoad.add(tratEx);
                                mapLoad.put(position, tratEx);
                            } else if (idDoTipo == 4) {
                                Ferramenta ide = new IDE( 4, position);
                                ferramentasLoad.add(ide);
                                mapLoad.put(position, ide);
                            } else if (idDoTipo == 5) {
                                Ferramenta helpProf = new AjudaDoProfessor( 5, position);
                                ferramentasLoad.add(helpProf);
                                mapLoad.put(position, helpProf);
                            }
                        }
                    }
                    ferramentas = ferramentasLoad;
                    while(reader.hasNextLine() && (line = reader.nextLine()) != null){
                        worldSizeLoad = Integer.parseInt(line);
                    }
                    worldSize = worldSizeLoad;
                    reader.close();
                } catch (IOException e) {
                    return false;
                }
            return true;
        }
    }
