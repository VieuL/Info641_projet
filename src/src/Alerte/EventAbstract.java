import java.util.EventObject;
import java.util.GregorianCalendar;

abstract class EventAbstract extends EventObject {
    private GregorianCalendar date;
    private Batiment location;
    private int level;

    public EventAbstract(Object source,Batiment location,int level) {
        super(source);
        this.date = new GregorianCalendar();
        this.location=location;
        if( level>=1 && level<=3){
            this.level=level;
        } else {
            throw new ExceptionInInitializerError();
        }
    }
    public  String toString(){
        return "Event produit : "+String.valueOf(this.date.getTime())
                +"\nsitué à "+this.location.getNom()+" de niveau "+String.valueOf(level)+"\n";
    }

    public Batiment getLocation() {
        return location;
    }

}