class Faktura implements Betalning {
    @Override
    public boolean betala(double belopp) {
        // Här kan du lägga till logik för att skapa en faktura.
        System.out.println("Faktura skapad för belopp: " + belopp + "\n");
        return true;  // Anta att faktura skapades framgångsrikt
    }
}

