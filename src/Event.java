class Event {
    private String name;
    private Arena arena;

    public Event(String name, Arena arena) {
        this.name = name;
        this.arena = arena;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " - " + ((arena != null) ? arena.toString() : "Ingen arena");

}}

