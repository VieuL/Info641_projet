import java.util.EventObject;
import java.util.GregorianCalendar;

public class GazEvent extends EventObject{
    GregorianCalendar date;
    int importance;
    String type;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public GazEvent(Object source, int importance, String type) {
        super(source);
        this.date = new GregorianCalendar();
        this.importance = importance;
        this.type = type;
    }
    public void displayDate(){
        System.out.println("\nDate :\n" + this.date.getTime());
    }
    public void displayImportance(){
        System.out.println(this.importance);
    }

    public void displayType(){
        System.out.println(this.type);
    }

}
