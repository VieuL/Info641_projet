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

    /**
     * Cette fonction permet de faire une display de l'objet
     */
    public  String toString(){
        return "événement produit à : "+ this.getDate().getTime()
                +"\nsitué dans le  "+this.getLocation().getNom()
                +" et de niveau "+ this.getLevel();
    }

    //! ---- Définition des accesseurs (getter/setter) ----
    public Batiment getLocation() {
        return location;
    }


    public GregorianCalendar getDate() {
        return date;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    public String getType(){
        return "";
    }

}