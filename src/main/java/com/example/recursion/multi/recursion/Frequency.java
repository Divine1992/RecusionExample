package com.example.recursion.multi.recursion;

import java.util.List;

public class Frequency {
    private Integer value;
    private List<Frequency> subFrequencies;

    public Frequency(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Frequency> getSubFrequencies() {
        return subFrequencies;
    }

    public void setSubFrequencies(List<Frequency> subFrequencies) {
        this.subFrequencies = subFrequencies;
    }

    @Override
    public String toString() {
        return "Frequency{" +
                "value=" + value +
                '}';
    }
}

