import java.util.EventObject;

public class AtypeListener implements AtypeInterface {
    @Override
    public void Atype(EventObject eo) {
        if(eo instanceof GazEvent){
            System.out.println("A type Gaz");
            ((GazEvent) eo).getLocation().addEvent((GazEvent)eo);
        }
        if(eo instanceof IncendieEvent){
            System.out.println(("A type Incendie"));
            ((IncendieEvent) eo).getLocation().addEvent((IncendieEvent)eo);
        }

    }
}