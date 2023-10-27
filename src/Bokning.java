import java.util.Timer;
import java.util.TimerTask;

class Bokning {
    private String customer;
    private Betalning betalning;
    private Biljett biljett;
    private Timer timer;
    private boolean isPaid = false;
    private boolean isConfirmed = false;

    public Bokning(String customer, Betalning betalning, Biljett biljett) {
        this.customer = customer;
        this.betalning = betalning;
        this.biljett = biljett;
        startTimer();
    }

    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isPaid) {
                    System.out.println("Bokningstiden har gått ut för " + customer + ". Bokningen avbruten.\n");
                    // Här kan du lägga till ytterligare logik för att hantera avbruten bokning
                }
            }
        }, 10 * 60 * 1000);  // 10 minuter i millisekunder
    }

    public void genomforBokning(double biljettPris) {
        if (!isPaid) {
            isPaid = betalning.betala(biljettPris);
            if (isPaid) {
                timer.cancel();  // Avbryt timern när betalningen är genomförd
                System.out.println("Bokning genomförd för " + customer+ "\n");
            } else {
                System.out.println("Betalningen misslyckades för " + customer+ "\n");
            }
        } else {
            System.out.println("Bokningen har redan betalats eller avbrutits.\n");
        }
    }

    public void bekreftaBokning() {
        // Kontrollera om bokningen redan har betalats
        if (this.isPaid) {
            // Om bokningen redan är betald, kan vi bekräfta den
            this.isConfirmed = true;
            System.out.println("Bokningen har bekräftats för " + this.customer);

            // Här kan man lägga till ytterligare åtgärder som behövs efter bekräftelse av bokningen,
            // till exempel att skicka en bekräftelse via e-post, uppdatera databasen, etc.

        } else {
            // Om bokningen inte är betald, kan vi inte bekräfta den och informerar kunden
            System.out.println("Bokningen kan inte bekräftas eftersom betalningen inte har genomförts.");
        }
    }

    // metod för att kontrollera om bokningen har bekräftats
    public boolean isBekräftad() {
        return this.isConfirmed;
    }
}