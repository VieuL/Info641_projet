public class Salle {
    private String nom;
    private Batiment batiment;

    public Salle(String nom, Batiment batiment){
        this.nom = nom;
        this.batiment = batiment;
        this.batiment.addSalle(this);
    }

    public Batiment getBatiment() {
        return batiment;
    }

    public String getNom() {
        return nom;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
