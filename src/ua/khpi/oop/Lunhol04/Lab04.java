package ua.khpi.oop.Lunhol04;
import java.util.Arrays;
import java.util.Scanner;

import static ua.khpi.oop.Lunhol04.Function.*;

public class Lab04 {
	/**
	  * @author ALEXANDRA
	  * @version 4.0
	  * Here start point of the program
	  * Function in which menu actions are performed
	  * until the user presses exit program does not end
	  * 
	  * */
	public static void main(String[] args) {
        ArgsCMD Arguments = new ArgsCMD(args);
        if (!Arguments.isEmpty()) {
            Arguments.arguments();
        }
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        int choose;
        String str1 = null;
        String str2 = null;
        while (loop) {
            ChooseMenu();
            choose = scan.nextInt();
            switch (choose) {
                case 1:
                    if (str1 != null){
                        if (ArgsCMD.DBG)
                            System.out.println("You choose 1. But string has been already created");
                        System.out.println("Error! String has been already created.");
                        break;
                    }
                    else {
                        if(ArgsCMD.DBG)
                            System.out.println("You choose 1. Creating string");
                        str1 = InitializeString();
                        break;
                    }
                case 2:
                    if (str1 == null){
                        if(ArgsCMD.DBG) {
                            System.out.println("You choose 2. But your string is empty");
                        }
                        System.out.println("Error! String is empty!");
                        break;
                    }
                    else {
                        if (ArgsCMD.DBG) {
                            System.out.println("You choose 2. Showing your string");
                        }
                        
                        ShowString(str1);
                        break;
                    }
                case 3:
                    if (str1 == null){
                        if(ArgsCMD.DBG)
                            System.out.println("You choose 3. But your string is empty");
                        System.out.println("Error! String is empty!");
                        break;
                    }
                    else {
                        if (ArgsCMD.DBG)
                            System.out.println("You choose 3. Split text");
                        System.out.println("\nSplit on sentences:");
                       str2 = CutText(str1);
                       str1 = CutText2(str1);
                        System.out.println("Successfully!");
                        break;
                    }
                case 4:
                    if (str1 == null){
                        if (ArgsCMD.DBG)
                            System.out.println("You choose 4. But your string is empty");
                        System.out.println("Error! String is empty!");
                        break;
                    }
                    else {
                        if (ArgsCMD.DBG)
                            System.out.println("You choose 4. Counting now");
                        System.out.println("\nEnter 1 for first or 2 for second: ");
                        int choice = scan.nextInt();
                        System.out.println("\nCount: ");
                        while(true) {
                        if(choice == 1) {
                        	Alphabet(str1);
                        	break;
                        }
                        else if(choice == 2) {
                        	Alphabet(str2);
                        	break;
                        }
                        else
                        	System.out.println("Error. Repeat choose: ");
                        }
                        System.out.println("Successfully!");
                        break;
                    }
                case 0:
                    if (ArgsCMD.DBG)
                        System.out.println("You choose 0. End of Work");
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

