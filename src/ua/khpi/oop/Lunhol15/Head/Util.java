package ua.khpi.oop.Lunhol15.Head;

import ua.khpi.oop.Lunhol15.Container.Container;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//параметрез. методы
public class Util {
    public static <T extends HDR1> void sortPassport(Container obj) {
        HDR1[] array = new HDR1[obj.size()];
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
        }
        Arrays.sort(array, HDR1.compareByPassport);
        obj.clear();
        for (int i = 0; i < array.length; i++) {
            obj.add(( array[i]));
        }
    }

    public static <T extends HDR1> void sortMarks(Container obj) {
        HDR1[] array = new HDR1[obj.size()];
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
        }
        Arrays.sort(array, HDR1.compareByMarks);
        obj.clear();
        for (int i = 0; i < array.length; i++) {
            obj.add(array[i]);
        }
    }

    public static <T extends HDR1> void sortPayment(Container obj) {
        HDR1[] array = new HDR1[obj.size()];
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
        }
        Arrays.sort(array, HDR1.compareByPayment);
        obj.clear();
        for (int i = 0; i < array.length; i++) {
            obj.add(array[i]);
        }

    }

//    public static <T extends HDR1> void search(Container obj) {
//        if (obj.notEmpty()) {
//            int count = 0;
//            for (HDR1 s : obj) {
//                Pattern p1 = Pattern.compile("[0-9]+[8][0-9]+[6][0-9]+");
//                Matcher m1 = p1.matcher(String.valueOf(s.getNumberPassport()));
//                if (m1.find()) {
//                    Pattern p2 = Pattern.compile("[a-z]+[r]", Pattern.CASE_INSENSITIVE);
//                    Matcher m2 = p2.matcher(s.getPosition());
//                    if (m2.find()) {
//                        Pattern p3 = Pattern.compile("[0-9]{2}:[0-9]{2}:[0][7]");
//                        Matcher m3 = p3.matcher(s.getData());
//                        if (m3.find()) {
//                            System.out.println("Selection:");
//                            System.out.println("#" + (++count));
//                            System.out.println(s);
//                        }
//                    }
//                }
//            }
//        }
//    }


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
        System.out.println("10. Search.");
        System.out.println("0. End of work.");
        System.out.print("Write your choose there: ");
    }
}
