import java.util.ArrayList;

public class RadiationGenerator {
    ArrayList<RadiationInterface> myListeners = new ArrayList<RadiationInterface>();
    ArrayList<BtypeInterface> myListeners3 = new ArrayList<BtypeInterface>();

    public void addRadiationListener(RadiationListener rl){
        this.myListeners.add(rl);
    }
    public void addBtypeListener(BtypeInterface gl){
        this.myListeners3.add(gl);
    }


    public void generateRadiationEvent(int importance, int taux){
        RadiationEvent event = new RadiationEvent(this,importance, taux);
        for(RadiationInterface ri: myListeners){
            ri.radiation(event);
        }
        for(BtypeInterface ai: myListeners3){
            ai.Btype(event);
        }
    }
}
