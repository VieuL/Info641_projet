public class RadiationEvent extends EventAbstract{
    private int radiation;

    public RadiationEvent(Object source, Batiment location, int level, int radiation) {
        super(source,location,level);
        if( radiation>=1 && radiation<=100){
            this.radiation=radiation;
        } else {
            throw new ExceptionInInitializerError();
        }
    }
    public String getType(){
        return "Radiation";
    }

    public int getRadiation() {
        return radiation;
    }

    public  String toString(){
        return "événement produit à : "+ super.getDate().getTime()
                +"\nsitué dans le  "+super.getLocation().getNom()
                +"\n de niveau "+ super.getLevel()
                +" et de radioactivité : "+this.getRadiation();
    }

}

