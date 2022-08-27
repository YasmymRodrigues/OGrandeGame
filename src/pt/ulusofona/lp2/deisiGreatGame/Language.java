package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;

public class Language {
    String nome;

    public Language(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(String s) {
        return nome;
    }

    @Override
    public String toString() {
        return "" + nome;
    }


}
