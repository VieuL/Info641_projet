import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Création des generator
        GazGenerator gazG = new GazGenerator();
        IncendieGenerator IncendieG = new IncendieGenerator();
        RadiationGenerator radiationG = new RadiationGenerator();

        // Création des listener
        AtypeListener listA = new AtypeListener();
        BtypeInterface listB = new BtypeListener();

        // On ajoute les listener dans le générator
        gazG.addAtypeListener(listA);
        IncendieG.addAtypeListener(listA);

        gazG.addBtypeListener(listB);
        radiationG.addBtypeListener(listB);

        // Création des batiments
        Batiment A = new Batiment("Batiment A", 10);
        Batiment B = new Batiment("Batiment B", 10);


        // Création d'évènement
        gazG.generateGazEvent(A,3, "CO");
        IncendieG.generateIncendieEvent(A, 3);
        IncendieG.generateIncendieEvent(A,1);
        radiationG.generateRadiationEvent(A,2,90);
        ArrayList<Batiment> a = Batiment.liste;
        System.out.println(a);
        Fenetre fen = new Fenetre();
    }
}
