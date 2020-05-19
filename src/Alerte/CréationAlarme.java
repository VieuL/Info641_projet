/**
 * Cette classe sert à créer les 3 grands type d'alarme (gaz/incendie/radio)
 * elle met aussi a disposition de getteurs
 */
public class CréationAlarme {
    public static GazGenerator gazG = new GazGenerator();
    public static IncendieGenerator IncendieG = new IncendieGenerator();
    public static RadiationGenerator radiationG = new RadiationGenerator();

    public CréationAlarme(){
        AtypeListener listA = new AtypeListener();
        BtypeInterface listB = new BtypeListener();
//        AtypeListener moi = new AtypeListener();

        gazG.addAtypeListener(listA);
        IncendieG.addAtypeListener(listA);
//
//        gazG.addAtypeListener(moi);
//        IncendieG.addAtypeListener(moi);

        gazG.addBtypeListener(listB);
        radiationG.addBtypeListener(listB);
    }

    //! ---- Définition des accesseurs (getter/setter) ----
    public GazGenerator getGazG() {
        return gazG;
    }

    public IncendieGenerator getIncendieG() {
        return IncendieG;
    }

    public RadiationGenerator getRadiationG() {
        return radiationG;
    }

}