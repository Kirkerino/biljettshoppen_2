import java.util.*;

public class Main {
    static String forsatta="Yes";
    static String kommando;
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

    {

        // några exempelobjekt


        Arena arena = new Arena("Stora Arenan");
        Event event = new Event("Musikkonsert", arena);
        Biljett biljett = new Biljett(event);


                System.out.println("Välkommen till biljettsystemet!");
                System.out.print("Ange ditt användarnamn: ");
                String username = scanner.nextLine();

                System.out.print("Ange ditt lösenord: ");
                String password = scanner.nextLine();

                Customer customer = new Customer(username, password);
        List<Plats> platser = new ArrayList<>();
        platser.add(new Plats(200.0, "Staplats"));
        platser.add(new Plats(300.0, "Sittplats"));
        platser.add(new Plats(150.0, "Handikappanpassad"));


        while (!forsatta.equalsIgnoreCase("Q")){

        System.out.println("""
                 Vad vill du göra?\s
                 Visa platser\s
                 Event - För att se event)\s
                 Boka och betala - för att betala\s
                 Admin\s
                 V - För att visa hjältar\s
                 Q - För att avsluta""");
        kommando = scanner.nextLine();


        switch (kommando) {

            case "Event":
                System.out.println("Du vill se vilka event så pågår: \n");
                System.out.println(event + "\n");
                break;

            case "Visa platser":
            case "1":
                // Visa tillgängliga platser
                System.out.println("Tillgängliga platser:");
                for (Plats plats : platser) {
                    int slumpmassigtAntalLediga = random.nextInt(250) + 1;
                    System.out.println("Typ: " + plats.getPlatsTyp() + ", Antal lediga: " + slumpmassigtAntalLediga+ " av 250");
                }
                break;

            case "Boka och betala":
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

                // Antag att vi har ett fast pris per biljett. I en verklig applikation kan detta vara dynamiskt.
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

            Bokning nyBokning = new Bokning(username, betalning, biljett);
                System.out.println("Bekräfta din bokning? (Ja/Nej)");
                     String bekreftelse = scanner.next();

                  if (bekreftelse.equalsIgnoreCase("Ja")) {
                      double biljettPris = 500.0;// Exempelpris
                      nyBokning.genomforBokning(biljettPris);

                      // Efter att bokningen är genomförd kan du ge användaren en bekräftelse
                      System.out.println("Tack, " + username + "! Din bokning har genomförts och betalats.");
                  } else {
                      System.out.println("Bokning avbruten.");
                      break;
                  }




            case "Admin":
                System.out.print("Ange ditt administratörsanvändarnamn: ");
                String adminUsername = scanner.nextLine(); // Använd ett annat namn här

                System.out.print("Ange ditt administratörslösenord: ");
                String adminPassword = scanner.nextLine(); // Använd ett annat namn här

                Admin admin = new Admin(adminUsername, adminPassword);
                break;




            case "Q":
                forsatta="Q";
                break;
    }
}}
        scanner.close();}

}