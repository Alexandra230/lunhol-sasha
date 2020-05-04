package ua.khpi.oop.Lunhol13.Tests;

import ua.khpi.oop.Lunhol13.Container.Container;
import ua.khpi.oop.Lunhol13.Container.Threads;
import ua.khpi.oop.Lunhol13.Head.HDR1;

import java.io.IOException;
import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) throws IOException {
        //Lab13.main(new String[]{"-auto"});
        // Lab13.main(args);

        Container<HDR1> container = new Container<>();
        HDR1 rec1 = new HDR1();
        HDR1 rec2 = new HDR1();
        HDR1 rec3 = new HDR1();

        rec1.setPayment(2600);
        rec2.setPayment(3700);
        for (int i = 0; i < 10000; i++) {
            container.add(rec1);
            container.add(rec2);
        }
        rec3.setPayment(600);
        for (int i = 0; i < 1200; i++) {
            container.add(rec3);
        }
        rec2.setPayment(2500);
        container.add(rec2);
        rec2.setPayment(500);
        container.add(rec2);
        Threads.MyTread1 myTread1 = new Threads.MyTread1();
        myTread1.set(container);
        Threads.MyTread2 myTread2 = new Threads.MyTread2();
        myTread2.set(container);
        Threads.MyTread3 myTread3 = new Threads.MyTread3();
        myTread3.set(container);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> future = executorService.submit(myTread1);
        Future<Boolean> future1 = executorService.submit(myTread2);
        Future<Boolean> future2 = executorService.submit(myTread3);
        try {
            future.get(2, TimeUnit.SECONDS);
            future1.get(2, TimeUnit.SECONDS);
            future2.get(2, TimeUnit.SECONDS);
        } catch (TimeoutException | InterruptedException | ExecutionException ex) {
            future.cancel(true);
            future1.cancel(true);
            future2.cancel(true);
        }
        executorService.shutdown();

    }
}

