package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class Programmer {
    String name;
    int id;
    ArrayList<Language> linguagens;
    ProgrammerColor color;
    int pos;
    List<Ferramenta> ferramentas;
    boolean estado;

    Programmer() {
        this.linguagens = new ArrayList<>();
    }

    /*Programmer(String nome, int id, ProgrammerColor color, int pos){
        this.nome = nome;
        this.linguagens = new ArrayList<>();
        this.id = id;
        this.color = color;
        this.pos = pos;
    }*/


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

    public ArrayList<Language> getLinguagens() {
        return linguagens;
    }

    public void setLinguagens(ArrayList<Language> linguagens) {
        this.linguagens = linguagens;
    }

    public ProgrammerColor getColor() {
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

    public void setFerramentas(List<Ferramenta> ferramentas) {
        this.ferramentas = ferramentas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String converteArrayParaString(List<Language> languages){
        String lang = "";
        for(Language language: languages){
            if(languages.size() == 1) {
                lang += language.nome;
            }else{
                lang += language.nome + ";";
            }
        }
        return lang;
    }

    @Override
    public String toString() {
        Ferramenta ferramenta = new Ferramenta() {
            @Override
            public String toolName() {
                return null;
            }
        };

        Programmer programmer = new Programmer();

        if (estado && !ferramentas.isEmpty()) {
            return "" + id +" | "+ name +" | "+ programmer.pos +" | "+ "No tools " +" | "+ converteArrayParaString(linguagens) + "|" + programmer.color;
        } else {
            return "" + id +" | "+ name +" | "+ programmer.pos +" | "+ ferramenta.toolName() +" | "+ converteArrayParaString(linguagens) + "|" + programmer.color;
        }
    }
}
