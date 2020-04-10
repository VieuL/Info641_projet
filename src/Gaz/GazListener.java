public class GazListener implements GazInterface {
    @Override
    public void Gaz(GazEvent ge) {
        ge.displayDate();
        ge.displayImportance();
        ge.displayType();
        System.out.println("Bibibi alarme Gaz");
        System.out.println("======================");
    }
}
