package com.java.practice.basics;

class Foo {

    private String attribute;

    public Foo(String a) {
        this.attribute = a;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}

public class CallByValueDemo {

    public static void main(String[] args) {

        Foo f = new Foo("f");
        System.out.println("Before changeReference(): " + f.getAttribute());

        changeReference(f); // It won't change the reference!
        System.out.println("After changeReference() It won't change the reference of f: " + f.getAttribute());

        modifyReference(f); // It will change the object that the reference variable "f" refers to!
        System.out.println("After modifyReference() It will change the object reference of f: " + f.getAttribute());
    }

    public static void changeReference(Foo a) {
        System.out.println("Inside changeReference() before creating Foo(): " + a.getAttribute());
        Foo b = new Foo("b");
        a = b;
        System.out.println("Inside changeReference(): " + b.getAttribute());
        System.out.println("Inside changeReference(): " + a.getAttribute());
    }

    public static void modifyReference(Foo c) {
        c.setAttribute("c");
        System.out.println("Inside modifyReference(): " + c.getAttribute());
    }
}
