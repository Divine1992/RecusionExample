package com.example.recursion.db.recursion;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "chefs", joinColumns = @JoinColumn(name = "object_id"), inverseJoinColumns = @JoinColumn(name = "chefs_id"))
    private List<Object> chefs;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "staff", joinColumns = @JoinColumn(name = "object_id"), inverseJoinColumns = @JoinColumn(name = "staff_id"))
    private List<Object> staff;

    public Object() {
    }

    public Object(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getChefs() {
        return chefs;
    }

    public void setChefs(List<Object> chefs) {
        this.chefs = chefs;
    }

    public List<Object> getStaff() {
        return staff;
    }

    public void setStaff(List<Object> staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Object{" +
                "id=" + id +
                ", name='" + name + '\'';
    }
}
