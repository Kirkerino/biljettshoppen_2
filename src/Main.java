import java.util.*;

public class Main {

    static String fortvara="Yes";
    static String kommando;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        {

        // Skapa arenor
        Arena avicii = new Arena("Avicii Arena");
        Arena globen = new Arena("Globen Arena");

        // Skapa event
        Event musikkonsert = new Event("Musikkonsert", avicii);
        Event hockey = new Event("Hockey, Falun vs Borlänge", globen);

        // Skapa arraylist för event
        List<Event> events = new ArrayList<>();
        events.add(musikkonsert);
        events.add(hockey);

        List<Plats> platser = new ArrayList<>();
        musikkonsert.addPlatsTyp(new Plats(200.0, "Ståplats", 500));
        musikkonsert.addPlatsTyp(new Plats(300.0, "Sittplats", 300));
        musikkonsert.addPlatsTyp(new Plats(200.0, "Bänk", 200));
        musikkonsert.addPlatsTyp(new Plats(150.0, "Handikapps anpassad", 50));
        hockey.addPlatsTyp(new Plats(250.0, "Ståplats", 600));
        hockey.addPlatsTyp(new Plats(350.0, "Sittplats", 400));
        hockey.addPlatsTyp(new Plats(250.0, "Bänk", 300));
        hockey.addPlatsTyp(new Plats(200.0, "Handikapps anpassad", 150));

        // Skapa biljetter
        //Biljett biljettMusikkonsert = new Biljett(musikkonsert, valdPlats);
        //Biljett biljettHockey = new Biljett(hockey, valdPlats);
        /* Skapa arraylist för biljetter */


        System.out.println("Välkommen till biljettsystemet!");
        System.out.print("Ange ditt användarnamn: ");
        String username = scanner.nextLine();

        System.out.print("Ange ditt lösenord: ");
        String password = scanner.nextLine();

        Customer customer = new Customer(username, password);



        while (!fortvara.equalsIgnoreCase("Q")){

            System.out.println("""
                  \s
                  Vad vill du göra?\s
                  1 - Visa event\s
                  2 - Visa bokade events\s
                  3 - Visa användarinformation\s
                  4 - Admin\s
                  Q - För att avsluta""");
            kommando = scanner.nextLine();


         switch (kommando) {

            case "1":

                // Visa Event
                System.out.println("\nPågående event");
                for (int i = 0; i < events.size(); i++) {
                    System.out.println((i+1) + ": " + events.get(i));
                }
                // Välja event
                System.out.println("\nVälj ett event genom att ange dess nummer, välj 0 för att gå tillbaka:");
                int eventChoice = Integer.parseInt(scanner.nextLine());

                if (eventChoice == 0) {
                    break;
                } else if (eventChoice > 0 && eventChoice <= events.size()) {
                    Event chosenEvent = events.get(eventChoice - 1);
                    System.out.println("Du har valt: " + chosenEvent + "\n");

                    // Visa platser för valt event
                    System.out.println("Tillgängliga platser:");
                    int index = 1;
                    for (Plats plats : chosenEvent.getPlatsTyp()) {
                        System.out.println(index++ + ". Platstyp: " + plats.getPlatsTyp() + " . Lediga platser: " + plats.getLedigaPlatser() + ". Pris: " + plats.getPris());
                    }

                    // Boka plats för valt event
                System.out.println("\nVill du boka biljetter för detta event? (Ja/Nej)");
                String bokaBiljett = scanner.nextLine();

                if (bokaBiljett.equalsIgnoreCase("Ja")) {
                    int antalBiljetter;
                    System.out.println("\nDu har valt att boka biljetter för event: " + chosenEvent);
                        System.out.println("Välj platstyp: ");
                        index = 1;
                        for (Plats plats : chosenEvent.getPlatsTyp()) {
                            System.out.println(index++ + ". Platstyp: " + plats.getPlatsTyp() + " . Lediga platser: " + plats.getLedigaPlatser() + ". Pris: " + plats.getPris());
                        }

                        int platsVal = scanner.nextInt();
                        scanner.nextLine(); //Consume the newline left-over
                        if (platsVal < 1 || platsVal > chosenEvent.getPlatsTyp().size()) {
                            System.out.println("Ogiltigt val, försök igen.");
                            break;
                        }

                        Plats chosenPlats = chosenEvent.getPlatsTyp().get(platsVal - 1);

                        System.out.println("Du har valt platstyp: " + chosenPlats.getPlatsTyp() + "\nAnge antal biljetter du vill boka (max 5):");
                        try {
                            antalBiljetter = Integer.parseInt(scanner.nextLine());
                            if (antalBiljetter <= 0 || antalBiljetter > 5) {
                                System.out.println("Antalet biljetter måste vara mellan 1 och 5.");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Ogiltig karaktär. Ange en siffra.");
                            break;
                        }

                        if (!chosenPlats.bokaPlats(antalBiljetter)) {
                            System.out.println("Inte tillräckligt med platser kvar.");
                            break;
                        }

                        double totalPris = antalBiljetter * chosenPlats.getPris();
                        System.out.println("\nTotal kostnad för " + antalBiljetter + " biljetter är: " + totalPris + " kr.");

                        System.out.println("Välj betalningsmetod (1 för Direktbetalning, 2 för Faktura): ");
                        int choice = scanner.nextInt();
                        Betalning betalning;
                        if (choice == 1) {
                           betalning = new Direktbetalning();
                        } else {
                            betalning = new Faktura();
                        }

                        Bokning nyBokning = new Bokning(username, betalning, chosenEvent);
                        System.out.println("\nBekräfta din bokning? (Ja/Nej)");
                        String konfirmera= scanner.next();
                        if (konfirmera.equalsIgnoreCase("Ja")) {
                            nyBokning.genomforBokning(totalPris);
                            // Efter att bokningen är genomförd kan man ge användaren en bekräftelse
                            System.out.println("Tack, " + username + "! Din bokning har genomförts och betalats för event: " + chosenEvent);
                            scanner.nextLine();
                            // Generera biljett ~
                        } else {
                        System.out.println("Bokning avbruten.");
                        }

                    break;
                }
                }

                break;

            case "2":
                break;

            case "3":
                break;

            case "4": //Admin
                System.out.print("Ange ditt användarnamn: ");
                String AdminUsername = scanner.nextLine();

                System.out.print("Ange ditt lösenord: ");
                String AdminPassword = scanner.nextLine();

                Admin admin = new Admin(AdminUsername, AdminPassword);

                // Anropa login-metoden för att försöka logga in
                boolean inloggad = admin.login();

                if (inloggad) {
                    boolean exitAdmin = false;
                    while (!exitAdmin) {
                        System.out.println("Välj ett alternativ:");
                        System.out.println("1 - Lägg till ny arena.");
                        System.out.println("2 - Lägg till nytt event.");
                        System.out.println("3 - Gå tillbaka.");
                        System.out.println("Q - Avsluta");
                        String adminVal = scanner.nextLine();
                        switch (adminVal) {
                             // Lägga till ny arena
                            case "1":
                                 System.out.println("Ange namnet på den nya arenan: ");
                                 String arenaNamn = scanner.nextLine();
                                 Arena newArena = new Arena(arenaNamn);
                                 System.out.println("Ny arena tillagd: " + arenaNamn + "\n");
                                 break;
                             // Lägg till nytt event
                            case "2":
                                 System.out.println("Ange namnet på det nya eventet: ");
                                 String eventNamn = scanner.nextLine();
                                 System.out.println("Ange arenan för det nya eventet: ");
                                 String eventArena = scanner.nextLine();
                                 Event newEvent = new Event(eventNamn, new Arena(eventArena));
                                 newEvent.addPlatsTyp(new Plats(200.0, "Sittplats", 500));
                                 newEvent.addPlatsTyp(new Plats(150.0, "Ståplats", 250));
                                 newEvent.addPlatsTyp(new Plats(100.0, "Bänk", 100));
                                 newEvent.addPlatsTyp(new Plats(100.0, "Handikapps anpassad", 25));
                                 events.add(newEvent);
                                 System.out.print("Nytt event tillagt: " + eventNamn + " - " + eventArena + "\n");
                                 break;
                            case "3":
                                 exitAdmin = true;
                                 break;
                            case "Q":
                                break;
                            default:
                                System.out.println("\nOgiltigt val.\n");
                        }
                    }
                }
            break;
            case "q":
            case "Q":
                fortvara="Q";
                break;
            default:
                System.out.println("\nOgiltigt val.\n");

         }//Avslutar switch

        }// Avslutar While loopen
        }
        scanner.close(); // Avslutar scanner
    }// End Main
}// End MainClass