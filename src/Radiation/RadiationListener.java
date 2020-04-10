public class RadiationListener implements RadiationInterface{
    @Override
    public void radiation(RadiationEvent re) {
        re.displayDate();
        re.displayImportance();
        re.displatTaux();
        System.out.println("Biibib alarme raddiaiton");
        System.out.println("======================");
    }
}
