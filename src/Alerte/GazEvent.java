public class GazEvent extends EventAbstract{
    private String typeGaz ;
    public GazEvent(Object source,String location,int level,String typeGaz) {
        super(source,location,level);
        this.typeGaz=typeGaz;
    }

}
