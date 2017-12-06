package com.example.recursion.single.model.recursion;

import java.util.LinkedList;
import java.util.List;

public class Main {
    private List<Event> events = new LinkedList<>();

    public static void main(String[] args) {
        Event e1 = new Event("e1");
        Event e2 = new Event("e2");
        Event e3 = new Event("e3");
        e1.setNextEvent(e2);
        e2.setNextEvent(e3);
        e2.setPreviousEvent(e1);
        e3.setPreviousEvent(e2);

        Main m = new Main();
        m.findAllNextEvents(e1);
        System.out.println(m.getEvents());
    }

    void findAllNextEvents(Event event){
        events.add(event);
        if (event.getNextEvent() != null){
            findAllNextEvents(event.getNextEvent());
        }
    }

    public List<Event> getEvents() {
        return events;
    }
}
