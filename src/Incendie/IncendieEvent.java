import java.util.EventObject;
import java.util.GregorianCalendar;

public class IncendieEvent extends EventObject {
    GregorianCalendar date;
    int importance;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public IncendieEvent(Object source, int importance) {
        super(source);
        this.date = new GregorianCalendar();
        this.importance = importance;

    }

    public void displayDate(){
        System.out.println("\nDate :\n" + this.date.getTime());
    }
    public void displayImportance(){
        System.out.println(this.importance);
    }




}
