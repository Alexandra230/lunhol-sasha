package ua.khpi.oop.Lunhol14.Container;

import ua.khpi.oop.Lunhol14.Head.HDR1;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Threads {

    public static class MyTread1 implements Callable<Boolean> {
        Container<HDR1> container;

        @Override
        public Boolean call() throws InterruptedException {
            maxMinPayment();
            return true;
        }

        private void maxMinPayment() throws InterruptedException {
            //TimeUnit.MILLISECONDS.sleep(2);
            int max = container.getElementByIndex(0).getPayment();
            int min = container.getElementByIndex(0).getPayment();
            for (int i = 0; i < container.size(); i++) {
                if (container.getElementByIndex(i).getPayment() < min) {
                    min = container.getElementByIndex(i).getPayment();
                }
                if (container.getElementByIndex(i).getPayment() > max) {
                    max = container.getElementByIndex(i).getPayment();
                }
            }
            System.out.println("Max payment = " + max);
            System.out.println("Min payment = " + min);
        }

        public void set(Container<HDR1> container) {
            this.container = container;
        }


    }

    public static class MyTread2 implements Callable<Boolean> {
        Container<HDR1> container;


        private void sumAvgPayment() throws InterruptedException {
            //TimeUnit.MILLISECONDS.sleep(2);
            int sum = 0;
            int avg = 0;
            for (int i = 0; i < container.size(); i++) {
                sum += container.getElementByIndex(i).getPayment();
            }
            avg = sum / container.size();
            System.out.println("Sum payment = " + sum);
            System.out.println("Avg payment = " + avg);
        }

        public void set(Container<HDR1> container) {
            this.container = container;
        }

        @Override
        public Boolean call() throws Exception {
            sumAvgPayment();
            return true;
        }
    }

    public static class MyTread3 implements Callable<Boolean> {
        public static final int HIGHER_PAYMENT = 1000;
        Container<HDR1> container;

        @Override
        public Boolean call() throws Exception {
            countHigherPayment();
            return true;
        }

        private void countHigherPayment() throws InterruptedException {
            //TimeUnit.MILLISECONDS.sleep(2);
            int count = 0;
            for (int i = 0; i < container.size(); i++) {
                if (container.getElementByIndex(i).getPayment() >= HIGHER_PAYMENT) {
                    count++;
                }
            }
            System.out.println("Number of vacancies with higher payment: " + count);
        }

        public void set(Container<HDR1> container) {
            this.container = container;
        }
    }
}
