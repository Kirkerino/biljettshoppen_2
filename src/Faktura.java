class Faktura implements Betalning {
    @Override
    public boolean betala(double belopp) {
        // Här kan man lägga till mer för att skapa en faktura som adress.
        System.out.println("Faktura skapad");
        return true;  // Anta att fakturan skapades framgångsrikt.
    }
}