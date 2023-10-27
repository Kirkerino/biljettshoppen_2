import java.util.Random;

public class Plats {
    private double pris;
    private String platsTyp; // Exempelvis "Staplats", "Handikappanpassad", "Fallstol"

    public Plats(double pris, String platsTyp) {
        this.pris = pris;
        this.platsTyp = platsTyp;
    }

    public double getPris() {
        return pris;
    }

    public String getPlatsTyp() {
        return platsTyp;
    }

    public boolean platsUpptagen() {
        Random random = new Random();
        // Genererar ett slumpmässigt booleskt värde
        return random.nextBoolean();
    }

    public void boka() {
        // Bokningslogik här
    }

    public void avboka() {
        // Avbokningslogik här
    }

    // Om det finns specifika funktioner beroende på platsTyp, kan du lägga till dem här och använda villkorliga uttalanden (if-satser) beroende på platsTyp.
}
