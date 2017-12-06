package com.example.recursion.db.recursion;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static List<Object> staffObjects = new LinkedList<>();

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("recursionUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Object o1 = new Object("Polska");
        Object o2 = new Object("Armed Forces");
        Object o3 = new Object("Ground Forces");
        Object o4 = new Object("B1");
        Object o5 = new Object("B2");

        //*set staff*//*
        o1.setStaff(Stream.of(o2).collect(Collectors.toList()));
        o2.setStaff(Stream.of(o3).collect(Collectors.toList()));
        o3.setStaff(Stream.of(o4, o5).collect(Collectors.toList()));

        //*set chefs*//*
        o5.setChefs(Stream.of(o3).collect(Collectors.toList()));
        o4.setChefs(Stream.of(o3).collect(Collectors.toList()));
        o3.setChefs(Stream.of(o2).collect(Collectors.toList()));
        o2.setChefs(Stream.of(o1).collect(Collectors.toList()));

        em.persist(o1);

        /*Recursion after search in DB*/
        Object findObject = em.find(Object.class, 1L);
        findAllStaff(findObject);
        System.out.println("All staff of "+findObject.getName()+" are: "+getStaffObjects());

        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    /*Recursion*/
    static void findAllStaff(Object object){
        if(object.getStaff() == null){
            return;
        }
        for(Object o : object.getStaff()){
            staffObjects.add(o);
            findAllStaff(o);
        }
    }

    public static List<Object> getStaffObjects() {
        return staffObjects;
    }
}
