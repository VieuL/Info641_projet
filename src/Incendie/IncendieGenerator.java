import java.util.ArrayList;


public class IncendieGenerator {
    ArrayList<IncendieInterface> myListeners = new ArrayList<IncendieInterface>();
    ArrayList<AtypeInterface> myListeners2 = new ArrayList<AtypeInterface>();

    public void addAtypeListener(AtypeInterface gl){
        this.myListeners2.add(gl);
    }
    public void addIncendieListener(IncendieListener il){
        this.myListeners.add(il);
    }

    public void generateIncendieEvent(int importance){
        IncendieEvent event = new IncendieEvent(this,importance);
        for(IncendieInterface ii: myListeners){
            ii.incendie(event);
        }
        for(AtypeInterface ai: myListeners2){
            ai.Atype(event);
        }
    }
}
