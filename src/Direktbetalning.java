class Direktbetalning implements Betalning {
    @Override
    public boolean betala(double belopp) {
        // Här kan du lägga till logik för att genomföra direktbetalning, t.ex. kontakta en betalningstjänst.
        System.out.println("Betalning genomförd direkt för belopp: " + belopp+ "\n");
        return true;  // Anta att betalningen lyckades
    }
}