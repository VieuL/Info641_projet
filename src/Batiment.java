import java.util.ArrayList;

public class Batiment {
    private String nom;
    private int taille;
    public static ArrayList<Batiment> liste = new ArrayList<>();
    public Batiment(String nom, int taille){
        this.nom = nom;
        this.taille = taille;
        liste.add(this);
    }

    public int getTaille() {
        return taille;
    }

    public String getNom() {
        return nom;
    }
}

