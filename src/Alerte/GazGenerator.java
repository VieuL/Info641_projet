import java.util.ArrayList;

public class GazGenerator {

    ArrayList<AtypeInterface> myListeners2 = new ArrayList<AtypeInterface>();
    ArrayList<BtypeInterface> myListeners3 = new ArrayList<BtypeInterface>();


    public void addAtypeListener(AtypeInterface gl){
        this.myListeners2.add(gl);
    }
    public void addBtypeListener(BtypeInterface gl){
        this.myListeners3.add(gl);
    }

    public void generateGazEvent(Batiment location,int level,String typeGaz){
        GazEvent event = new GazEvent(this,location,level,typeGaz);

        for(AtypeInterface ai: myListeners2){
            ai.Atype(event);
        }
        for(BtypeInterface ai: myListeners3){
            ai.Btype(event);
        }
    }

}