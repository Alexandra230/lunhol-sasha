package ua.khpi.oop.Lunhol05;
import java.util.Arrays;
import java.util.Scanner;

import ua.khpi.oop.Lunhol05.Container.IteratorMine;

import static ua.khpi.oop.Lunhol04.Function.*;
/**
 * Our main class
 * Class show our containers
 * */
public class Lab05 {
	/**
	  * @author ALEXANDRA
	  * @version 4.0
	  * Here start point of the program
	  * Function in which menu actions are performed
	  * until the user presses exit program does not end
	  * 
	  * */
	public static void main(String[] args) {
		Container container = new Container();
        String str1;
        str1 = Function.InitializeString();
        Function.ShowString(str1);
        String str2 = "Hello world. Its me.";
        System.out.println();
        container.addBack(str1);
        container.addBack(str2);
        container.addBack(str1);
        container.addBack(str2);
        container.addBack(str1);
        container.addBack(str2);
        System.out.println("\n\n\n");
        container.showArray();
        System.out.println("\n\n\n");
        container.Alphabet2(3);
        
        System.out.println(container.arrayToStr());
        System.out.println("\nWrite with iterator: ");
        IteratorMine iter = (IteratorMine) container.iterator();//перемещаться по элементам
        for (String s : container) {
            System.out.println(s);
        }
            iter.next();
            iter.remove();
        System.out.println();
        container.showArray();
        int size=container.getSize();
        System.out.println("\n");
        System.out.println("Размер: "+ size);
      
	}
}