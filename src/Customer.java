class Customer extends User {
    private int ticketsBought = 0;

    public Customer(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login() {
        System.out.println("Kund inloggad.");
        return false;
    }
    public boolean buyTicket(Event event) {
        if (ticketsBought < 5) {
            ticketsBought++;
            System.out.println("Biljett köpt till " + event.getName());
            return true;
        } else {
            System.out.println("Max antal biljetter köpta.");
            return false;
        }
    }
}
