package pt.ulusofona.lp2.deisiGreatGame;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

public class Programmer {
    String nome;
    int id;
    ArrayList<Language> linguagens;
    ProgrammerColor color;
    int pos;
    List<Ferramenta> ferramentas;

    Programmer(){}
    Programmer(String nome, int id, ProgrammerColor color){
        this.nome = nome;
        this.id = id;
        this.color = color;
        this.linguagens = new ArrayList<>();
    }

    public Programmer(String nome, int id, ArrayList<Language> languages, ProgrammerColor cor, List<Ferramenta> ferramentas) {
        this.nome = nome;
        this.id = id;
        this.linguagens = languages;
        this.color = cor;
        this.ferramentas = ferramentas;
    }
    /*Programmer(String nome, int id, ProgrammerColor color, int pos){
        this.nome = nome;
        this.linguagens = new ArrayList<>();
        this.id = id;
        this.color = color;
        this.pos = pos;
    }*/


    public void getProgrammers(String nome){
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Language> getLinguagens() {
        return new ArrayList<Language>();
    }

    public int getId(){return this.id;}
    public String getName(){ return this.nome;}
    public ProgrammerColor getColor(){ return color;}

    @Override
    public String toString() {
        return "Programmer{" +
                "nome='" + nome + '\'' +
                ", linguagens=" + linguagens +
                ", id=" + id +
                ", color=" + color +
                ", pos=" + pos +
                ", ferramentas=" +ferramentas+
                '}';
    }
}
