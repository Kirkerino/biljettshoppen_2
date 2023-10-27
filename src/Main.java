import java.util.*;

public class Main {
    static String forsatta="Yes";
    static String kommando;
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

    {
        List<Plats> platser = new ArrayList<>();
        platser.add(new Plats(200.0, "Staplats"));
        platser.add(new Plats(300.0, "Sittplats"));
        platser.add(new Plats(150.0, "Handikappanpassad"));
        Plats valdPlats = platser.get(0);

        // Skapa arenor
        Arena avicii = new Arena("Avicii Arena");
        Arena globen = new Arena("Globen Arena");

        // Skapa event
        Event musikkonsert = new Event("Musikkonsert", avicii);
        Event hockey = new Event("Hockey - Falun vs Borlänge", globen);
        /* Skapa arraylist för event */
        
        // Skapa biljetter
        Biljett biljettMusikkonsert = new Biljett(musikkonsert, valdPlats);
        Biljett biljettHockey = new Biljett(hockey, valdPlats);
        /* Skapa arraylist för biljetter */


       System.out.println("Välkommen till biljettsystemet!");
       System.out.print("Ange ditt användarnamn: ");
       String username = scanner.nextLine();

       System.out.print("Ange ditt lösenord: ");
       String password = scanner.nextLine();

        Customer customer = new Customer(username, password);



        while (!forsatta.equalsIgnoreCase("Q")){

        System.out.println("""
                 \s
                 Vad vill du göra?\s
                 1 - Visa event\s
                 2 - Visa platser\s
                 3 - Boka och betala\s
                 4 - Admin\s
                 Q - För att avsluta""");
        kommando = scanner.nextLine();


        switch (kommando) {

            case "1": // Visa Event
                System.out.println("Du vill se vilka event som pågår: \n");
                System.out.println(musikkonsert + "\n");
                System.out.println(hockey + "\n");

                break;

            case "2":
                // Visa tillgängliga platser
                System.out.println("Tillgängliga platser:");
                for (Plats plats : platser) {
                    int slumpmassigtAntalLediga = random.nextInt(250) + 1;
                    System.out.println("Typ: " + plats.getPlatsTyp() + ", Antal lediga: " + slumpmassigtAntalLediga+ " av 250");
                }
                break;

            case "3": // Boka och betala
                int antalBiljetter = 0;

                System.out.println("Du har valt att boka biljetter.");

                while (true) {
                    System.out.println("Ange antal biljetter du vill boka (max 5):");
                    try {
                        antalBiljetter = Integer.parseInt(scanner.nextLine());

                        if (antalBiljetter > 0 && antalBiljetter <= 5) {
                            break; // om antalet är inom tillåtna gränser, bryt while-loopen
                        } else {
                            System.out.println("Du kan bara boka upp till 5 biljetter.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ogiltigt antal. Vänligen ange ett nummer.");
                        // loopen fortsätter så att användaren kan försöka igen
                    }}

                // Antag att vi har ett fast pris per biljett. Detta vara dynamiskt.
                double prisPerBiljett = 500.0; // Exempelpris
                double totalPris = antalBiljetter * prisPerBiljett;

                // Informera användaren om den totala kostnaden och fråga om de vill fortsätta
                System.out.println("Total kostnad för " + antalBiljetter + " biljetter är: " + totalPris + " kr.");

            System.out.println("Välj betalningsmetod (1 för Direktbetalning, 2 för Faktura): ");
            int choice = scanner.nextInt();
            Betalning betalning;

            if (choice == 1) {
                betalning = new Direktbetalning();
            } else {
                betalning = new Faktura();
            }

            Bokning nyBokning = new Bokning(username, betalning, biljettMusikkonsert);
                System.out.println("Bekräfta din bokning? (Ja/Nej)");
                     String bekreftelse = scanner.next();

                  if (bekreftelse.equalsIgnoreCase("Ja")) {
                      double biljettPris = 500.0;// Exempelpris
                      nyBokning.genomforBokning(biljettPris);

                      // Efter att bokningen är genomförd kan man ge användaren en bekräftelse
                      System.out.println("Tack, " + username + "! Din bokning har genomförts och betalats.");
                  } else {
                      System.out.println("Bokning avbruten.");
                  }
                     break;

            case "4": //Admin
                System.out.print("Ange ditt användarnamn: ");
                String AdminUsername = scanner.nextLine();

                System.out.print("Ange ditt lösenord: ");
                String AdminPassword = scanner.nextLine();

                Admin admin = new Admin(AdminUsername, AdminPassword);

                // Anropa login-metoden för att försöka logga in
                boolean inloggad = admin.login();
                break;


            case "Q":
                forsatta="Q";
                break;
    }
}}
        scanner.close();}

}