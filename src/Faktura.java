class Faktura implements Betalning {
    @Override
    public boolean betala(double belopp) {
        // Här kan man lägga till logik för att skapa en faktura.
        System.out.println("Faktura skapad");
        return true;  // Anta att faktura skapades framgångsrikt
    }
}

