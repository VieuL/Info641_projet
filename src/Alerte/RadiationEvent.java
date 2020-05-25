/**
 * classe pour les alertes aux radiations
 */
public class RadiationEvent extends EventAbstract{
    private int radiation;

    /**
     *
     * @param source
     * source de l'alerte
     * @param location
     * batiment provoquant l'alerte
     * @param level
     * niveau d'importance de l'alerte
     * @param radiation
     * entier définissant le niveau de radiation
     */

    public RadiationEvent(Object source, Batiment location, int level, int radiation) {
        super(source,location,level);
        if( radiation>=1 && radiation<=100){
            this.radiation=radiation;
        } else {
            throw new ExceptionInInitializerError();
        }
    }

    /**
     * Cette fonction permet de faire une affichage de l'objet
     */
    public  String toString(){
        return "événement produit à : "+ super.getDate().getTime()
                +"\nsitué dans le  "+super.getLocation().getNom()
                +"\n de niveau "+ super.getLevel()
                +" et de radioactivité : "+this.getRadiation();
    }

    //! ---- Définition des accesseurs (getter/setter) ----
    public String getType(){
        return "Radiation";
    }

    public int getRadiation() {
        return radiation;
    }
}

