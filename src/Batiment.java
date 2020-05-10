import java.util.ArrayList;

public class Batiment {

    private String nom;
    private int taille;
    public static ArrayList<Batiment> liste = new ArrayList<>();
    private  ArrayList<EventAbstract> events;


    public Batiment(String nom, int taille){
        this.nom = nom;
        this.taille = taille;
        liste.add(this);
        events=new ArrayList<>();
    }

    public int getTaille() {
        return taille;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Batiment{" +
                "nom='" + nom + '\'' +
                ", taille=" + taille +
                '}';
    }

    public ArrayList<EventAbstract> getEvents() {
        return events;
    }

    public void addEvent(EventAbstract e){
        events.add(e);
    }

    public static  void removeAllBatiment(EventAbstract e){
            for( Batiment batiment:liste){
                if(batiment.getEvents().contains(e)){
                    batiment.getEvents().remove(e);
                }
            }

    }

}

