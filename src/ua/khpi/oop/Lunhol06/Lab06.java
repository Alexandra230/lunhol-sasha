 package ua.khpi.oop.Lunhol06;

 import java.io.FileInputStream;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.io.ObjectInputStream;
 import java.io.ObjectOutputStream;
 import java.util.Scanner;

import ua.khpi.oop.Lunhol06.Container;

 final class Lab06 {
     private Lab06() {
         //default constructor
     }
     /**
      * @param args  - ggg.
      * @throws IOException -ggg.
      * @throws ClassNotFoundException -ggg.
      */
     public static void main(final String[] args) throws IOException, ClassNotFoundException {

    	 Container container = new Container();
         Scanner scan = new Scanner(System.in);
         boolean loop = true;
         int choose;
         int choose2;
         String str1;
         String str2;
         int temp = 0;
         while (loop) {
             Function.chooseMenu();
             choose = scan.nextInt();
             switch (choose) {
                 case 1:
                     str1 = Function.InitializeString();
                     container.addBack(str1);
                     break;
                 case 2:
                     System.out.println("Your container:");
                     container.showArray();
                     break;
                 case 3:
                     System.out.println("\nCalculate:");
                     temp = container.getSize();
                     System.out.println("Enter number from 1 to " + temp);
                     choose2 = scan.nextInt();
                     container.Alphabet2(choose2);
                     System.out.println("Successfully!");
                     break;
                 case 4:
                     container.clearArray();
                     System.out.println("Clear container successfully!");
                     break;
                 case 5:
                     System.out.println("Container to String: ");
                     System.out.println(container.arrayToStr());
                     break;
                 case 6:
                     str2 = Function.InitializeString();
                     if (container.remove(str2)) {
                         System.out.println("Successfully");
                         break;
                     } else {
                         System.out.println("This string is absent");
                         break;
                     }
                 case 7:
                     str2 = Function.InitializeString();
                     if (container.contains(str2)) {
                         System.out.println("This string contains in container");
                         break;
                     } else {
                         System.out.println("This string is absent");
                         break;
                     }
                 case 8:
                     container.helperSanchez();
                     break;
                 case 9:
                     System.out.println("Sorting elements in container");
                     container.sortContainer();
                     System.out.println("Successfully");
                     break;
                 case 10:
                     str2 = Function.InitializeString();
                     int temper = container.search(str2);
                     if (temper == 0) {
                         System.out.println("This element is not abs");
                         break;
                     } else {
                         System.out.print("This elements contains in index: " + (temper - 1));
                         break;
                 }
                 case 11:
                     if(container.compression()) {
                         System.out.println("Elements are equal");
                         break;
                     } else {
                         System.out.println("Elements are not equal");
                         break;
                     }
                 case 12:
                     System.out.println("Saving to file");
                     FileOutputStream file = new FileOutputStream("tempFile.txt");
                     ObjectOutputStream object = new ObjectOutputStream(file);
                     object.writeObject(container);
                     object.close();
                     System.out.println("Successfully");
                     break;
                 case 13:
                     System.out.println("Read from file");
                     FileInputStream fileInput = new FileInputStream("tempFile.txt");
                     ObjectInputStream objectInput = new ObjectInputStream(fileInput);
                     container = (Container) objectInput.readObject();
                     objectInput.close();
                     System.out.println("Successfully");
                     break;
                 case 0:
                     System.out.println("\n\nThanks for working!");
                     loop = false;
                     break;
                 default:
                     System.out.println("Error. Mistake number!");
                     break;
             }
         }
       }
     }
