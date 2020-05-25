/**
 * classe pour les alertes du au incendie
 */
public class IncendieEvent extends EventAbstract  {
    /**
     *
     * @param source
     * source de l'alerte
     * @param location
     * batiment provoquant l'alerte
     * @param level
     * niveau d'importance de l'alerte
     */
    public IncendieEvent(Object source,Batiment location,int level) {
        super(source,location,level);
    }

    public String getType(){
        return "Incendie";
    }
}
