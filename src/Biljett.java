class Biljett {
    private String customer;
    private Event event;
    private Plats plats;
    private int antalPlatser;

    public Biljett(String customer, Event event, Plats plats, int antalPlatser) {
        this.customer = customer;
        this.event = event;
        this.plats = plats;
        this.antalPlatser = antalPlatser;
    }

    public String getCustomer(){return customer;}
    public Plats getPlats() {return plats;}
    public Event getEvent() {return event;}
    public int getAntalPlatser() {return antalPlatser;}
}