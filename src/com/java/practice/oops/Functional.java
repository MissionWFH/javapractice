package com.java.practice.oops;

import java.util.List;

/*
 * Child Functional interface can override the method of parent functional interface
 * and also override the methods from object class
 */

@FunctionalInterface
interface Functional1 {

    List<?> getData();

    boolean equals(Object o);

    String toString();
}

@FunctionalInterface
public interface Functional extends Functional1 {

    List<?> getData();

    boolean equals(Object o);

    String toString();
}
