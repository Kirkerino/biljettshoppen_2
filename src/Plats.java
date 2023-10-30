public class Plats {
    private double pris;
    private String platsTyp; // Exempelvis "Ståplats", "Handikappanpassad", "Fällstol", "Bänk"
    private int totalaPlatser;
    private int ledigaPlatser;

    public Plats(double pris, String platsTyp, int totalaPlatser) {
        this.pris = pris;
        this.platsTyp = platsTyp;
        this.totalaPlatser = totalaPlatser;
        this.ledigaPlatser = totalaPlatser;
    }

    public boolean bokaPlats(int antalPlatser) {
        if (antalPlatser <= ledigaPlatser) {
            ledigaPlatser -= antalPlatser;
            return true;
        }
        return false;
    }

    public double getPris() {return pris;}
    public String getPlatsTyp() {return platsTyp;}
    public int getTotalaPlatser() {return totalaPlatser;}
    public int getLedigaPlatser() {return ledigaPlatser;}
    // Om det finns specifika funktioner beroende på platsTyp, man kan lägga till dem här och använda villkorliga uttalanden (if-satser) beroende på platsTyp.
}
