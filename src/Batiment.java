public class Batiment {
    private String nom;
    private int taille;

    public Batiment(String nom, int taille){
        this.nom = nom;
        this.taille = taille;
    }

    public int getTaille() {
        return taille;
    }

    public String getNom() {
        return nom;
    }
}

