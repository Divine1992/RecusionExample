package com.example.recursion.single.model.recursion;

public class Event {
    private String name;
    private Event nextEvent;
    private Event previousEvent;

    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getNextEvent() {
        return nextEvent;
    }

    public void setNextEvent(Event nextEvent) {
        this.nextEvent = nextEvent;
    }

    public Event getPreviousEvent() {
        return previousEvent;
    }

    public void setPreviousEvent(Event previousEvent) {
        this.previousEvent = previousEvent;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                '}';
    }
}
