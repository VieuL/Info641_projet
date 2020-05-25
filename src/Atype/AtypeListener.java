import java.util.ArrayList;
import java.util.EventObject;

/**
 * classe d'écouteur de type A soit gaz et incendie
 */
public class AtypeListener implements AtypeInterface {
    public  ArrayList <EventAbstract> events= new ArrayList<>();

    /**
     *
     * @param eo
     * evenement entrant de Type A
     */
    @Override
    public void Atype(EventObject eo) {
        if(eo instanceof GazEvent){
            events.add((GazEvent) eo);
            if(!(((GazEvent) eo).getLocation().getEvents().contains(eo))) {
                System.out.println("A type Gaz");
                ((GazEvent) eo).getLocation().addEvent((GazEvent) eo);
            }


        }
        if(eo instanceof IncendieEvent){
            System.out.println(("A type Incendie"));
            ((IncendieEvent) eo).getLocation().addEvent((IncendieEvent)eo);
            events.add((IncendieEvent) eo);

        }

    }

}
