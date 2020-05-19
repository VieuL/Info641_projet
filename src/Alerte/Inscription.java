import java.util.ArrayList;

public class Inscription {
    private String type;
    private String nom;
    public static ArrayList<Inscription> aType = new ArrayList<>();
    public static ArrayList<Inscription> bType = new ArrayList<>();

    public Inscription(){}

    public void isBtype(){

        this.type = "B";
        bType.add(this);
    }

    public void isAtype(){
        this.type = "A";
        aType.add(this);
    }

    public void desinscription(){
        if(this.type == "A"){
            aType.remove(this);
        }

        if(this.type == "B"){
            bType.remove(this);
        }
    }

    public String getNom() {
        return nom;
    }

}
