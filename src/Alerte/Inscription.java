import java.util.ArrayList;
/**
 * Classe facilitant la création des écouteurs
 */
public class Inscription {
    private String type;
    private String nom;
    public static ArrayList<BtypeListener> bType = new ArrayList<>();

    public static ArrayList<AtypeListener> aType = new ArrayList<>();
    public Inscription(){}

    /**
     * Inscription aux alarmes de type B (Gaz et Radio)
     */
    public void isBtype(){

        this.type = "B";
        BtypeListener listA = new BtypeListener();
        CréationAlarme.gazG.addBtypeListener(listA);
        CréationAlarme.radiationG.addBtypeListener(listA);
        bType.add(listA);
    }

    /**
     * Inscription aux alarmes de type A (Gaz et Incendie)
     */
    public void isAtype(){
        this.type = "A";
        AtypeListener listA = new AtypeListener();
        CréationAlarme.gazG.addAtypeListener(listA);
        CréationAlarme.IncendieG.addAtypeListener(listA);
        aType.add(listA);
    }


    public String getNom() {
        return nom;
    }

}
