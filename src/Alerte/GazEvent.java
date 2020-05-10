public class GazEvent extends EventAbstract{
    private String typeGaz ;
    public GazEvent(Object source,Batiment location,int level,String typeGaz) {
        super(source,location,level);
        this.typeGaz=typeGaz;
    }

    public String getTypeGaz() {
        return typeGaz;
    }

    public  String toString(){
        return "événement produit à : "+ super.getDate().getTime()
                +"\nsitué dans le  "+super.getLocation().getNom()
                +"\n de niveau "+ super.getLevel()
                +" de type : "+this.getTypeGaz();
    }
    public String getType(){
        return "Gaz";
    }
}
