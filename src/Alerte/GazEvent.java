/**
 * classe pour les alertes de type gaz
 */
public class GazEvent extends EventAbstract{
    private String typeGaz ;

    /**
     *
     * @param source
     * source de l'alerte
     * @param location
     * batiment provoquant l'alerte
     * @param level
     * niveau d'importance de l'alerte
     * @param typeGaz
     * type de gaz de l'alerte
     */
    public GazEvent(Object source,Batiment location,int level,String typeGaz) {
        super(source,location,level);
        this.typeGaz=typeGaz;
    }

    public String getTypeGaz() {
        return typeGaz;
    }


    /**
     * Cette fonction permet de faire une affichage de l'objet
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
