package ua.khpi.oop.Lunhol11.Head;

import ua.khpi.oop.Lunhol11.Container.Container;

import java.util.Arrays;

//параметрез. методы
public class Util {
	public static <T extends HDR1> void sortPassport(Container<T> obj) {
		HDR1[] array = new HDR1[obj.size()];
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
        }
        Arrays.sort(array, HDR1.compareByPassport);
        obj.clear();
        for (int i = 0; i < array.length; i++) {
            obj.add((T) array[i]);
        }
    }

    public static <T extends HDR1> void sortMarks(Container<T> obj) {
    	HDR1[] array = new HDR1[obj.size()];
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
        }
        Arrays.sort(array, HDR1.compareByMarks);
        obj.clear();
        for (int i = 0; i < array.length; i++) {
            obj.add((T) array[i]);
        }
    }

    public static <T extends HDR1> void sortPayment(Container<T> obj) {
    	HDR1[] array = new HDR1[obj.size()];
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
        }
        Arrays.sort(array, HDR1.compareByPayment);
        obj.clear();
        for (int i = 0; i < array.length; i++) {
            obj.add((T) array[i]);
        }
        
    }
    

    public static void chooseMenu() {
        System.out.println();
        System.out.println("1. Add candidat.");
        System.out.println("2. Show all candidats.");
        System.out.println("3. Clear container.");
        System.out.println("4. Check elements in container.");
        System.out.println("5. Size of container.");
        System.out.println("6. Get element by index.");
        System.out.println("7. Save data to file.");
        System.out.println("8. Read data from file.");
        System.out.println("9. Sorting data in container.");
        System.out.println("0. End of work.");
        System.out.print("Write your choose there: ");
    }
}
