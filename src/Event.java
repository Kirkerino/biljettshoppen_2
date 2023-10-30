import java.util.*;

public class Event {
    private String name;
    private Arena arena;
    private List<Plats> platsTyp;

    public Event(String name, Arena arena) {
        this.name = name;
        this.arena = arena;
        this.platsTyp = new ArrayList<>();
    }

    public void addPlatsTyp(Plats plats) {
        platsTyp.add(plats);
    }

    public List<Plats> getPlatsTyp() {
        return platsTyp;
    }

    public void bokaPlats(Plats plats, int count) {

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " - " + ((arena != null) ? arena.toString() : "Ingen arena");

}}

