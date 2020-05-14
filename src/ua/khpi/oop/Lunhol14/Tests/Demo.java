package ua.khpi.oop.Lunhol14.Tests;

import ua.khpi.oop.Lunhol14.Container.Container;
import ua.khpi.oop.Lunhol14.Container.Threads;
import ua.khpi.oop.Lunhol14.Head.HDR1;

import java.io.IOException;
import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        //Lab13.main(new String[]{"-auto"});
        // Lab13.main(args);

        Container<HDR1> linkedContainer = new Container<>();
        HDR1 rec1 = new HDR1();
        HDR1 rec2 = new HDR1();
        HDR1 rec3 = new HDR1();

        rec1.setPayment(2600);
        rec2.setPayment(3700);
        for (int i = 0; i < 10000; i++) {
            linkedContainer.add(rec1);
            linkedContainer.add(rec2);
        }
        rec3.setPayment(600);
        for (int i = 0; i < 500; i++) {
            linkedContainer.add(rec3);
        }
        rec2.setPayment(2500);
        linkedContainer.add(rec2);
        rec2.setPayment(500);
        linkedContainer.add(rec2);
        Threads.MyTread1 myTread1 = new Threads.MyTread1();
        myTread1.set(linkedContainer);
        Threads.MyTread2 myTread2 = new Threads.MyTread2();
        myTread2.set(linkedContainer);
        Threads.MyTread3 myTread3 = new Threads.MyTread3();
        myTread3.set(linkedContainer);
        System.out.println("++++++++multithreading++++++++++");
        long start2 = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> future = executorService.submit(myTread1);
        Future<Boolean> future1 = executorService.submit(myTread2);
        Future<Boolean> future2 = executorService.submit(myTread3);
        future.get();
        future1.get();
        future2.get();
        future.cancel(true);
        future1.cancel(true);
        future2.cancel(true);
        executorService.shutdown();
        long finish2 = System.currentTimeMillis();
        long result2 = finish2 - start2;
        System.out.println("++++++++single threadingd+++++++");
        long start = System.currentTimeMillis();
        myTread1.call();
        myTread2.call();
        myTread3.call();
        long finish = System.currentTimeMillis();
        long result = finish - start;
        System.out.println("single threading time: " + result / 1000.0 + " seconds.");
        System.out.println("multithreading time: " + result2 / 1000.0 + " seconds.");

    }
}

