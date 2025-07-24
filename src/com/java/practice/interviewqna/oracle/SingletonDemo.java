package com.java.practice.interviewqna.oracle;

import java.util.concurrent.*;

public class SingletonDemo {

    private  static volatile SingletonDemo singletonDemo;
    private SingletonDemo(){}

    public synchronized static SingletonDemo getInstance(){
        if(singletonDemo == null){
            singletonDemo = new SingletonDemo();
        }
        return singletonDemo;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(SingletonDemo::getInstance);
        Thread t2 = new Thread(SingletonDemo::getInstance);

        t1.start();
        t2.start();

        System.out.println(t1 == t2);
        System.out.println(t1.hashCode() == t2.hashCode());

        ExecutorService executor = Executors.newFixedThreadPool(5);
//        executor.submit(()-> new A().run());
        Future<String> submit = executor.submit(() -> new B().call());
        String s = submit.get();
        System.out.println(s);


    }
}

class A implements Runnable{
    public void run(){
        System.out.println("running");
    }
}

class B implements Callable<String>{
    public String call(){
        return "completed";
    }
}

