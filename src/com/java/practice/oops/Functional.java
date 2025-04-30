package com.java.practice.oops;

import java.util.List;

@FunctionalInterface
public interface Functional {

    List<?> getData();

    boolean equals(Object o);

    String toString();
}
