package com.example.recursion.multi.recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private List<Frequency> frequencies = new LinkedList<>();

    public static void main(String[] args) {
        Frequency f1 = new Frequency(1);
        Frequency f2 = new Frequency(2);
        Frequency f3 = new Frequency(3);
        Frequency f4 = new Frequency(4);
        Frequency f5 = new Frequency(5);
        f1.setSubFrequencies(Stream.of(f2,f3).collect(Collectors.toList()));
        f2.setSubFrequencies(Stream.of(f4,f5).collect(Collectors.toList()));
        Main m = new Main();
        m.findAllFreq(f1);
        System.out.println(m.getFrequencies());
    }

    void findAllFreq(Frequency frequency){
        System.out.println(frequency);
        if (frequency.getSubFrequencies() == null){
            return;
        }
        for(Frequency f : frequency.getSubFrequencies()){
            frequencies.add(new Frequency(200));   // спускається на нижчий рівень - DOWN
            frequencies.add(f);
            findAllFreq(f);
        }
        frequencies.add(new Frequency(400));  // вертається з нижчого вищий рівень - UP
    }

    public List<Frequency> getFrequencies() {
        return frequencies;
    }
}
