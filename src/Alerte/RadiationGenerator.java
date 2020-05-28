import java.util.ArrayList;
/**
 * generation des alertes de type radiation
 */
public class RadiationGenerator {
    ArrayList<BtypeInterface> myListeners3 = new ArrayList<BtypeInterface>();

    public void addBtypeListener(BtypeInterface gl){
        this.myListeners3.add(gl);
    }

    /**
     * methode qui ajoute l'evenement a chaques ecouteurs
     * @param location
     * batiment de provenance de l'alerte
     * @param level
     * niveau de l'alerte
     * @param radiation
     * niveau de radiation
     */
    public void generateRadiationEvent(Batiment location, int level, int radiation){
        RadiationEvent event = new RadiationEvent(this,location, level, radiation);

        for(BtypeInterface ai: myListeners3){
            ai.Btype(event);
        }
    }
}
