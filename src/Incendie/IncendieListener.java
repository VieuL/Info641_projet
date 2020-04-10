public class IncendieListener implements IncendieInterface {
    @Override
    public void incendie(IncendieEvent ie) {
        ie.displayDate();
        ie.displayImportance();
        System.out.println("pinpon pinpon alarme incendie");
        System.out.println("======================");
    }
}
