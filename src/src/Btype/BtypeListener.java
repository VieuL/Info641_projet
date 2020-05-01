import java.util.EventObject;

public class BtypeListener implements BtypeInterface{

    @Override
    public void Btype(EventObject eo) {
        if(eo instanceof GazEvent){
            System.out.println("B type Gaz");
            ((GazEvent) eo).getLocation().addEvent((GazEvent)eo);
        }
        if (eo instanceof RadiationEvent){
            System.out.println("B type RAD");
            ((RadiationEvent) eo).getLocation().addEvent((RadiationEvent)eo);
        }
    }
}
