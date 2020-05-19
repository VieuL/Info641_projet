import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // ---- Création des batiments ----
        Batiment BatA = new Batiment("Batiment A", 10);
        Batiment batB = new Batiment("Batiment B", 10);

        // ---- Création des écouteurs ----
        Inscription batMan = new Inscription();
        batMan.isAtype();

        Inscription superMan = new Inscription();
        superMan.isBtype();

        // ---- Execution du programme ---
         new Fenetre();

    }

}