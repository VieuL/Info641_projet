import java.util.ArrayList;
/**
 * generation des alertes de type incendie
 */

public class IncendieGenerator {
    ArrayList<AtypeInterface> myListeners2 = new ArrayList<>();

    public void addAtypeListener(AtypeInterface gl){
        this.myListeners2.add(gl);
    }

    /**
     * methode qui ajoute l'evenement a chaques ecouteurs
     * @param location
     * batiment de provenance de l'alerte
     * @param level
     * niveau de l'alerte
     */
    public void generateIncendieEvent(Batiment location,int level){
        IncendieEvent event = new IncendieEvent(this,location, level);

        for(AtypeInterface ai: myListeners2){
            ai.Atype(event);
        }
    }
}