import java.util.ArrayList;
/**
 * generation des alertes de type gaz
 */
public class GazGenerator {

    ArrayList<AtypeInterface> myListeners2 = new ArrayList<>();
    ArrayList<BtypeInterface> myListeners3 = new ArrayList<>();


    public void addAtypeListener(AtypeInterface gl){
        this.myListeners2.add(gl);
    }
    public void addBtypeListener(BtypeInterface gl){
        this.myListeners3.add(gl);
    }
    /**
     * methode qui ajoute l'evenement a chaques ecouteurs
     * @param location
     * batiment de provenance de l'alerte
     * @param level
     * niveau de l'alerte
     * @param typeGaz
     * type de gaz associe a l'alerte
     */
    public void generateGazEvent(Batiment location,int level,String typeGaz){
        GazEvent event = new GazEvent(this,location,level,typeGaz);

        for(AtypeInterface ai: myListeners2){
            ai.Atype(event);
        }
        for(BtypeInterface ai: myListeners3){
            ai.Btype(event);
        }
    }

}