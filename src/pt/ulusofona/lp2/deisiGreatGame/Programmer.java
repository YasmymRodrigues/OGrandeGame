package pt.ulusofona.lp2.deisiGreatGame;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class Programmer {
    String nome;
    int id;
    ArrayList<Language> linguagens;
    ProgrammerColor color;
    int pos;
    List<Ferramenta> ferramentas;
    boolean estado;

    Programmer() {
    }

    Programmer(String nome, int id, ProgrammerColor color) {
        this.nome = nome;
        this.id = id;
        this.color = color;
        this.linguagens = new ArrayList<>();
    }

    /*public Programmer(String nome, int id, ArrayList<Language> languages, ProgrammerColor cor, List<Ferramenta> ferramentas) {
        this.nome = nome;
        this.id = id;
        this.linguagens = languages;
        this.color = cor;
        this.ferramentas = ferramentas;
    }*/
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Language> getLinguagens() {
        return new ArrayList<Language>();
    }

    public void setLinguagens(ArrayList<Language> linguagens) {
        this.linguagens = linguagens;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.nome;
    }

    public ProgrammerColor getColor() {
        return color;
    }

    public void setColor(ProgrammerColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        Ferramenta ferramenta = new Ferramenta() {
            @Override
            public String toolName() {
                return null;
            }
        };
        Language language = new Language();

        if (estado == true && !ferramentas.isEmpty()) {
            return " | " + id +" | "+ nome +" | "+ pos +" | "+ "No tools " +" | "+ linguagens + "";
        } else {

            return " | " + id +" | "+ nome +" | "+ pos +" | "+ ferramenta.toolName() +" | "+ language.nome + "";
        }
    }
}
