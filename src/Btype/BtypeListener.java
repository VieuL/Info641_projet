import java.util.ArrayList;
import java.util.EventObject;

public class BtypeListener implements BtypeInterface{
    public  ArrayList<EventAbstract> events= new ArrayList<>();//liste des evenements de typeB




    @Override
    public void Btype(EventObject eo) {
        if(eo instanceof GazEvent){
            events.add((GazEvent) eo);
            if(!(((GazEvent) eo).getLocation().getEvents().contains(eo))) {
                System.out.println("B type Gaz");
                ((GazEvent) eo).getLocation().addEvent((GazEvent) eo);
            }
        }
        if (eo instanceof RadiationEvent){
            events.add((RadiationEvent) eo);
            System.out.println("B type RAD");
            ((RadiationEvent) eo).getLocation().addEvent((RadiationEvent)eo);
        }
    }


}
