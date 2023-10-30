class Direktbetalning implements Betalning {
    @Override
    public boolean betala(double belopp) {
        // Här kan man lägga till för att genomföra direktbetalning, t.ex. kontakta en betalningstjänst.
        System.out.println("Betalning genomförd");
        return true;  // Anta att betalningen lyckades.
    }
}