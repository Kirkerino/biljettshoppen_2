import java.util.*;

class Bokning {
    private String customer;
    private Betalning betalning;
    private Event event;
    private Timer timer;
    private boolean isPaid = false;
    private boolean isConfirmed = false;

    public Bokning(String customer, Betalning betalning, Event event) {
        this.customer = customer;
        this.betalning = betalning;
        this.event = event;
        startTimer();
    }

    //Timer på 10 minuter
    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isPaid) {
                    System.out.println("\nBokningstiden har gått ut för " + customer + ". Bokning avbruten!\n");
                }
            }
        }, 10 * 60 * 1000);  // 10 minuter i millisekunder
    }

    //För att genomföra bokning och avsluta timer
    public void genomforBokning(double biljettPris) {
        if (!isPaid) {
            isPaid = betalning.betala(biljettPris);
            if (isPaid) {
                timer.cancel();  // Avbryt timern när betalningen är genomförd
                System.out.println("Bokning genomförd för " + customer + "\n");
            } else {
                System.out.println("Betalningen misslyckades för " + customer + "\n");
            }
        } else {
            System.out.println("Bokningen har redan betalats eller avbrutits.\n");
        }
    }

    public void valideraBokning() {
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
    public boolean isValiderad() {
        return this.isConfirmed;
    }
}