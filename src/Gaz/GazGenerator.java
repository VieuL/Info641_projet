import java.util.ArrayList;

public class GazGenerator {

    ArrayList<GazInterface> myListeners = new ArrayList<GazInterface>();
    ArrayList<AtypeInterface> myListeners2 = new ArrayList<AtypeInterface>();
    ArrayList<BtypeInterface> myListeners3 = new ArrayList<BtypeInterface>();


    public void addGazListener(GazListener gl){
        this.myListeners.add(gl);
    }
    public void addAtypeListener(AtypeInterface gl){
        this.myListeners2.add(gl);
    }
    public void addBtypeListener(BtypeInterface gl){
        this.myListeners3.add(gl);
    }

    public void generateGazEvent(int importance, String type){
        GazEvent event = new GazEvent(this,importance, type);
        for(GazInterface ge: myListeners){
            ge.Gaz(event);
        }
        for(AtypeInterface ai: myListeners2){
            ai.Atype(event);
        }
        for(BtypeInterface ai: myListeners3){
            ai.Btype(event);
        }
    }

}

