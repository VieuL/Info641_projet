public class CréationAlarme {
    GazGenerator gazG = new GazGenerator();
    IncendieGenerator IncendieG = new IncendieGenerator();
    RadiationGenerator radiationG = new RadiationGenerator();

    public CréationAlarme(){
        AtypeListener listA = new AtypeListener();
        BtypeInterface listB = new BtypeListener();

        gazG.addAtypeListener(listA);
        IncendieG.addAtypeListener(listA);

        gazG.addBtypeListener(listB);
        radiationG.addBtypeListener(listB);
    }

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