package com.java.practice.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class TestCollection15 {
    @SuppressWarnings("rawtypes")
    public static void main(String args[]) {

        Map<Integer, String> hm = new TreeMap<Integer, String>();

        hm.put(102, "Amit");
        hm.put(104, "Ravi");
        hm.put(10, "Amit");
        hm.put(99, "Amit");

        hm.put(102, "Vijay");
        hm.put(103, "Rahul");
        hm.put(103, "Avi");

        Set s = hm.entrySet();
        System.out.println("Values of Map :: " + hm.values());
        System.out.println("keys of Map :: " + hm.keySet());

        Iterator itr = s.iterator();

        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
		 /* for(Map.Entry m:hm.entrySet()){
		   		System.out.println(m.getKey()+" "+m.getValue());
		  }*/
    }
}