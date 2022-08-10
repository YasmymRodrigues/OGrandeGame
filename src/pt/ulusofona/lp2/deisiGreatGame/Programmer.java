package pt.ulusofona.lp2.deisiGreatGame;

import pt.ulusofona.lp2.deisiGreatGame.tools.Ferramenta;

import java.util.ArrayList;
import java.util.List;

public class Programmer {
    String name;
    int id;
    List<Language> languages;
    ProgrammerColor color;
    int pos;
    List<Ferramenta> ferramentas;
    boolean estado;
    List<Integer> posicoes;
    boolean hasTurn = false;

    Programmer() {
        this.languages = new ArrayList<>();
        this.ferramentas = new ArrayList<>();
    }

    Programmer(int id, String name, int pos, List<Ferramenta> ferramentas, List<Language> languages, ProgrammerColor color, List<Integer> posicoes){
        this.id = id;
        this.name = name;
        this.ferramentas = ferramentas;
        this.languages = languages;
        this.color = color;
        this.pos = pos;
        this.posicoes = new ArrayList<>();

    }

    public ArrayList<Programmer> programmers() {
        return new ArrayList<Programmer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<Language> languages) {
        this.languages = languages;
    }

    public ProgrammerColor getColor(){
            return color;
    }

    public void setColor(ProgrammerColor color) {
        this.color = color;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public List<Ferramenta> getFerramentas() {
        return ferramentas;
    }

    public String getStringFerramentas(){
        String tool = "";
        for (Ferramenta ferramenta: ferramentas){
            tool += ferramenta.toString() + ";";
        }
        return tool;
    }

    public void setFerramentas(List<Ferramenta> ferramentas) {
        this.ferramentas = ferramentas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Integer> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(List<Integer> posicoes) {
        this.posicoes = posicoes;
    }

    public boolean isHasTurn() {
        return hasTurn;
    }

    public void setHasTurn(boolean hasTurn) {
        this.hasTurn = hasTurn;
    }

    public void addPosicoes(int num){
        this.posicoes.add(num);
    }


    public String converteArrayParaString(List<Language> languages){
        String lang = "";
        for(Language language: languages){
            if(languages.size() == 1) {
                lang += language.nome;
            }else{
                lang += language.nome + ";  ";
            }
        }
        return lang;
    }

    public String getStatus(){
        if(estado == true){
            return "Em Jogo";
        }else{
            return "Derrotado";
        }
    }

    @Override
    public String toString() {

        String tools = "";
        if (ferramentas.size() < 1) {
            return "" + id + " | " + name + " | " + pos + " | " + "No tools " + "| " + converteArrayParaString(languages) + " | " + getStatus();
        } else {
                for (Ferramenta ferramenta : ferramentas) {
                    tools += ferramenta.toString() + ";";
                }
                return "" + id + " | " + name + " | " + pos + " | " + tools + "| " + converteArrayParaString(languages) + " | " + getStatus();
            }
       }
}

//expected:<...tools | Common Lisp;[ ]PHP | Em Jogo>
// but was:<...tools | Common Lisp;[]PHP | Em Jogo>
