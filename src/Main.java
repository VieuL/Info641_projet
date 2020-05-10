import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Création des batiments
        Batiment A = new Batiment("Batiment A", 10);
        Batiment B = new Batiment("Batiment B", 10);


        // Création d'évènement
        CréationAlarme alarme = new CréationAlarme();
        alarme.getIncendieG().generateIncendieEvent(B,3);
        alarme.getRadiationG().generateRadiationEvent(A,1,50);
        alarme.getGazG().generateGazEvent(A,1, "CO");
        alarme.getGazG().generateGazEvent(A,2, "CO");
        alarme.getGazG().generateGazEvent(A,3, "CO");
        //Creation de la fenetre
        Fenetre fen = new Fenetre();
    }
}