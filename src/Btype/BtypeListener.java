import java.util.EventObject;

public class BtypeListener implements BtypeInterface{

    @Override
    public void Btype(EventObject eo) {
        if(eo instanceof GazEvent){
            System.out.println("B type gaz");
        }
        if (eo instanceof RadiationEvent){
            System.out.println("B type radio");
        }
    }
}
