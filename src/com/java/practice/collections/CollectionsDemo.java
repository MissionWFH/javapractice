package com.java.practice.collections;

import java.util.*;

public class CollectionsDemo {

    public static void main(String args[]) {

        //List<Integer> al=new ArrayList<>();
        // List<Integer> al=new LinkedList<>();

        // Set<Integer> al=new TreeSet<>();
        // Set<Integer> al=new HashSet<>();
        // Set<Integer> al=new LinkedHashSet<>();

        Map<Integer, String> al = new HashMap<>();
        //Map<Integer, String> al = new LinkedHashMap<>();
        //Map<Integer, String> al = new TreeMap<>();

        System.out.println(al.getClass().getSimpleName() + " initial size: " + al.size());

        //al.add(null);
		/*al.add(1);
		al.add(123);
		al.add(1123);
		al.add(13);
		al.add(13);
		al.add(16);
		al.add(16);
		al.add(17);
		al.add(0);
		al.add(-1);*/
        //al.add(null);

        al.put(1, null);
        al.put(2, "4");
        al.put(2, "45656");
        al.put(3, "avi");
        al.put(3, "Amit");
        al.put(4, null);
        al.put(5, "5");
        al.put(6, "Vijay");
        al.put(7, "Kumar");
        al.put(8, "Sachin");
        //al.put(null, "5");
        //al.put(null, "123");

        System.out.println(al);
        System.out.println(al.getClass().getSimpleName() + " after inserting values size: " + al.size() + "\n");

        /*
         * for(Object o: al){
         * 		System.out.println(o);
         * }
         */

        for (Map.Entry m : al.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }
}