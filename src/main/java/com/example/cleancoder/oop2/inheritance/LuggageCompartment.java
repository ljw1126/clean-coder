package com.example.cleancoder.oop2.inheritance;

import java.util.ArrayList;

public class LuggageCompartment extends ArrayList<Luggage> {
    private int restSpace;

    public LuggageCompartment(int restSpace) {
        this.restSpace = restSpace;
    }

    @Override
    public boolean add(Luggage luggage) {
        this.restSpace -= luggage.size();
        return super.add(luggage);
    }

    public boolean canContain(Luggage luggage) {
        return this.restSpace > luggage.size();
    }

    // super.remove()가 public이라서 노출됨 (상속 자체를 잘못 사용)(
    public void extract(Luggage luggage) {
        this.restSpace += luggage.size();
        super.remove(luggage);
    }
}
