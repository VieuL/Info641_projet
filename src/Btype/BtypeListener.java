import java.util.ArrayList;
import java.util.EventObject;

public class BtypeListener implements BtypeInterface{
    public static ArrayList<EventAbstract> events;



    @Override
    public void Btype(EventObject eo) {
        if(eo instanceof GazEvent){

            if(!(((GazEvent) eo).getLocation().getEvents().contains(eo))) {
                System.out.println("B type Gaz");
                ((GazEvent) eo).getLocation().addEvent((GazEvent) eo);
            }
        }
        if (eo instanceof RadiationEvent){

            System.out.println("B type RAD");
            ((RadiationEvent) eo).getLocation().addEvent((RadiationEvent)eo);
        }
    }


}
