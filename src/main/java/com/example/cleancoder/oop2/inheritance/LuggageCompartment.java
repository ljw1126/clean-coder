package com.example.cleancoder.oop2.inheritance;

import java.util.ArrayList;
import java.util.List;

public class LuggageCompartment {
    private List<Luggage> luggages = new ArrayList<>();
    private int restSpace;

    public LuggageCompartment(int restSpace) {
        this.restSpace = restSpace;
    }

    public boolean add(Luggage luggage) {
        this.restSpace -= luggage.size();
        return luggages.add(luggage);
    }

    public boolean canContain(Luggage luggage) {
        return this.restSpace > luggage.size();
    }

    public void extract(Luggage luggage) {
        this.restSpace += luggage.size();
        luggages.remove(luggage);
    }
}
