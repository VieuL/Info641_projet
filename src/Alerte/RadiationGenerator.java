import java.util.ArrayList;

public class RadiationGenerator {
    ArrayList<BtypeInterface> myListeners3 = new ArrayList<BtypeInterface>();

    public void addBtypeListener(BtypeInterface gl){
        this.myListeners3.add(gl);
    }


    public void generateRadiationEvent(String location, int level, int radiation){
        RadiationEvent event = new RadiationEvent(this,location, level, radiation);

        for(BtypeInterface ai: myListeners3){
            ai.Btype(event);
        }
    }
}
