package pt.ulusofona.lp2.deisiGreatGame;

public class Language {
    String nome;


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(String s) {
        return nome;
    }

    @Override
    public String toString() {
        return "Language{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
