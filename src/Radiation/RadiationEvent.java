import java.util.EventObject;
import java.util.GregorianCalendar;

public class RadiationEvent extends EventObject {
    GregorianCalendar date;
    int importance;
    int taux;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public RadiationEvent(Object source, int importance, int taux) {
        super(source);
        this.date = new GregorianCalendar();
        this.importance = importance;
        this.taux = taux;
    }

    public void displayDate(){
        System.out.println("\nDate :\n" + this.date.getTime());
    }
    public void displayImportance(){
        System.out.println(this.importance);
    }
    public void displatTaux(){
        System.out.println(this.taux);
    }

}
