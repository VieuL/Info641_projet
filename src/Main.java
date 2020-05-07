import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Création des batiments
        Batiment A = new Batiment("Batiment A", 10);
        Batiment B = new Batiment("Batiment B", 10);


        // Création d'évènement
        CréationAlarme alarme = new CréationAlarme();
        alarme.getGazG().generateGazEvent(A,3, "CO");
        alarme.getIncendieG().generateIncendieEvent(B,3);

        ArrayList<Batiment> a = Batiment.liste;
        System.out.println(a);
        Fenetre fen = new Fenetre();
    }
}