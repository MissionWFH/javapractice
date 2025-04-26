package com.java.practice;

import java.util.List;

@FunctionalInterface
public interface Functional {

    List<?> getData();

    boolean equals(Object o);

    String toString();
}
