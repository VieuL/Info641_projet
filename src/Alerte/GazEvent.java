public class GazEvent extends EventAbstract{
    private String typeGaz ;
    public GazEvent(Object source,Batiment location,int level,String typeGaz) {
        super(source,location,level);
        this.typeGaz=typeGaz;
    }

    public String getTypeGaz() {
        return typeGaz;
    }


    /**
     * Cette fonction permet de faire une display de l'objet
     */
    public  String toString(){
        return "événement produit à : "+ super.getDate().getTime()
                +"\nsitué dans le  "+super.getLocation().getNom()
                +"\n de niveau "+ super.getLevel()
                +" de type : "+this.getTypeGaz();
    }

    //! ---- Définition des accesseurs (getter/setter) ----
    public String getType(){
        return "Gaz";
    }
}
