import java.util.ArrayList;
/**
 * generation des alertes de type incendie
 */

public class IncendieGenerator {
    ArrayList<AtypeInterface> myListeners2 = new ArrayList<AtypeInterface>();

    public void addAtypeListener(AtypeInterface gl){
        this.myListeners2.add(gl);
    }

    public void generateIncendieEvent(Batiment location,int level){
        IncendieEvent event = new IncendieEvent(this,location, level);

        for(AtypeInterface ai: myListeners2){
            ai.Atype(event);
        }
    }
}