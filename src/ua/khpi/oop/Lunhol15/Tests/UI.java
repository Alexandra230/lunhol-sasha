package ua.khpi.oop.Lunhol15.Tests;

import ua.khpi.oop.Lunhol15.Container.Container;
import ua.khpi.oop.Lunhol15.Head.HDR1;
import ua.khpi.oop.Lunhol15.Head.Util;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    public static void auto() throws IOException {
        HDR1 temp = new HDR1();
        Container container = new Container();


        System.out.println(container.size());
        container.add(temp);
        System.out.println(container.size());
        container.readRec();
        System.out.println("==================");

        int counter = 0;
        container.show();
        System.out.println("==================");
        System.out.println(container.size());
        System.out.println("==================");
        container.saveSerializable();
        container.search(new HDR1());
        System.out.println("==================");
        System.out.println(container.getElementByIndex(0));
        container.clear();
        System.out.println(container.size());
    }

    public static void menu() throws IOException {
        System.out.println("It is menu mode");
        Container linkedContainer = new Container();
        HDR1 rec1 = new HDR1();
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            Util.chooseMenu();
            int choose = scan.nextInt();
            switch (choose) {
                case 1:
                    try {
                        rec1.generateVacancy();
                        linkedContainer.add(rec1);
                        System.out.println("Done!");
                    } catch (InputMismatchException e) {
                        System.out.println("Error entering");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    if (linkedContainer.notEmpty()) {
                        linkedContainer.show();
                    } else {
                        System.out.println("Ошибка! Список пустой!");
                    }
                    break;
                case 3:
                    if (linkedContainer.notEmpty()) {
                        linkedContainer.clear();
                        System.out.println("Успешно!");
                    } else {
                        System.out.println("Ошибка! Массив пустой!");
                    }
                    break;
                case 4:
                    if (linkedContainer.notEmpty()) {
                        System.out.println("Your container have data.");
                    } else {
                        System.out.println("Your container doesn`t have data.");
                    }
                    break;
                case 5:
                    System.out.println("Size of container: " + linkedContainer.size());
                    break;
                case 6:
                    if (linkedContainer.notEmpty()) {
                        System.out.print("Entered index from 0 to " + (linkedContainer.size() - 1) + ": ");
                        int choose1 = scan.nextInt();
                        if (choose1 > (linkedContainer.size() - 1) || choose1 < 0) {
                            System.out.println("Repeat enter");
                        } else {
                            System.out.println(linkedContainer.getElementByIndex(choose1));
                        }
                        break;
                    }
                case 7:
                    if (linkedContainer.notEmpty()) {
                        linkedContainer.saveRec();
                    } else {
                        System.out.println("Your container is empty");
                    }
                    break;
                case 8:
                    if (linkedContainer.notEmpty()) {
                        linkedContainer.clear();
                    }
                    linkedContainer.readRec();
                    break;
                case 9:
                    if (linkedContainer.notEmpty()) {
                        System.out.println("What field do you want to sort by?");
                        System.out.println("1. Sort by passport");
                        System.out.println("2. Sort by marks");
                        System.out.println("3. Sort by payment");
                        int choose2 = scan.nextInt();
                        boolean loop2 = true;
                        while (loop2) {
                            switch (choose2) {
                                case 1:
                                    linkedContainer.sortByMarks();
                                    loop2 = false;
                                    break;
                                case 2:
                                    linkedContainer.sortByPayment();
                                    loop2 = false;
                                    break;
                                case 3:
                                    linkedContainer.sortByPassport();
                                    loop2 = false;
                                    break;
                                default:
                                    System.out.println("Ошибка. Неверное число!");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Your container is empty");
                    }
                    break;
                case 10:
                    if (linkedContainer.notEmpty()) {
                        linkedContainer.search(new HDR1());
                    } else {
                        System.out.println("Your container is empty");
                    }
                    break;
                case 0:
                    System.out.println("Thanks for working!");
                    loop = false;
                    break;
                default:
                    System.out.println("Ошибка. Неверное число!");
                    break;
            }
        }
    }
}
