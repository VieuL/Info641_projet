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
}

