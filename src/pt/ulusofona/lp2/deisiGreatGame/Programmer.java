package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class Programmer {
    String name;
    int id;
    List<Language> linguagens;
    ProgrammerColor color;
    int pos;
    List<Ferramenta> ferramentas;
    boolean estado;

    Programmer() {
        this.linguagens = new ArrayList<>();
        this.ferramentas = new ArrayList<>();
    }

    Programmer(int id, String name, int pos, List<Ferramenta> ferramentas, List<Language> linguagens, ProgrammerColor color){
        this.id = id;
        this.name = name;
        this.ferramentas = ferramentas;
        this.linguagens = linguagens;
        this.color = color;
        this.pos = pos;

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

    public List<Language> getLinguagens() {
        return linguagens;
    }

    public void setLinguagens(ArrayList<Language> linguagens) {
        this.linguagens = linguagens;
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
        for(Language language: linguagens){
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
        //TODO: Ferramentas are now Null, not instantiated
        if (ferramentas == null) {
            return "" + id +" | "+ name +" | "+ pos +" | "+ "No tools " +" | "+ converteArrayParaString(linguagens) + "|" + estado;
        } else {
            return "" + id +" | "+ name +" | "+ pos +" | "+ ferramentas +" | "+ converteArrayParaString(linguagens) + "|" + estado;
        }
    }
}
