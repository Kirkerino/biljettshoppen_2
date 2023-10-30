class Biljett {

    private Event event;
    private Plats plats;

    public Biljett(Event event, Plats plats) {
        this.event = event;
        this.plats = plats;
    }

    public Plats getPlats() {
        return plats;
    }

    public Event getEvent() {
        return event;
    }
}