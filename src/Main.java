
public class Main {
    public static void main(String[] args) {




                // Je crée rentre la valeur de mon capteur
                GazGenerator gazG = new GazGenerator();

                // Je crée une personne qui écoute mon capteur
//        GazListener list1 = new GazListener();

                //J'ajoute cette personne dans mes écouteur
//        gazG.addGazListener(list1);

                //J'envoie mon inforamation a toute les personne qui m'écoute



//        //------------------------------------------------------------------------------------------------------------------
                IncendieGenerator IncendieG = new IncendieGenerator();
//        IncendieListener list2 = new IncendieListener();
//        g.addIncendieListener(list2);
//        g.generateIncendieEvent();
//
//        // ------------------------------------------------------------------------------------------------------------------
                RadiationGenerator radiationG = new RadiationGenerator();
//        RadiationListener rl = new RadiationListener();
//        rg.addRadiationListener(rl);
//        rg.generateRadiationEvent();
//
//        //-----
                AtypeListener listA = new AtypeListener();
                BtypeInterface listB = new BtypeListener();

                gazG.addAtypeListener(listA);
                IncendieG.addAtypeListener(listA);

                gazG.addBtypeListener(listB);
                radiationG.addBtypeListener(listB);


                gazG.generateGazEvent("ChezMoi",3, "CO");
                IncendieG.generateIncendieEvent("chez moi", 3);
                IncendieG.generateIncendieEvent("chez toi",1);
                radiationG.generateRadiationEvent("Chez moi",2,90);
            }
        }
