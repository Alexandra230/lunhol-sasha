package ua.khpi.oop.Lunhol09.Tests;

import java.io.IOException;

import ua.khpi.oop.Lunhol09.Container.Container;
import ua.khpi.oop.Lunhol09.Head.HDR1;

public class Lab09 {
	public static void main(String[] args) throws IOException {
	Container<HDR1> container = new Container<>();
	HDR1 temp = new HDR1();
	temp.generateVacancy();
	
	
    System.out.println(container.size());
    container.add(temp);
    System.out.println(container.size());
    container.readRec();
    System.out.println("==================");
  
    int counter = 0;
    for (HDR1 s : container) {
    	System.out.println("#" + ++counter);
        System.out.println(s);
    }
    System.out.println("==================");
    System.out.println(container.size());
    System.out.println("==================");
    container.saveIn(container);
    System.out.println(container.getElementByIndex(0));
    container.clear();
    System.out.println(container.size());
	}
	

}
