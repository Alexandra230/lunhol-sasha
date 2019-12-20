package ua.khpi.oop.Lunhol06;
import java.util.Scanner;
/*
 * class Function in which all used functions are stored
 *
	  * @author ALEXANDRA
	  * @version 5.0
	  * Here start point of the program
	  * */
public class Function {
		/*
		 * Function that show user point of menu that he can choose
		 * */
		static void chooseMenu() {
	        System.out.println("\n\nChoose the right variant:");
	        System.out.println("1. Create and add string in container");
	        System.out.println("2. Show elements in container");
	        System.out.println("3. Calculating");
	        System.out.println("4. Clear container");
	        System.out.println("5. Show container to string");
	        System.out.println("6. Deleting element from container");
	        System.out.println("7. Check contains in container");
	        System.out.println("8. Execute string");
	        System.out.println("9. Sort elements in container");
	        System.out.println("10. Search elements in container");
	        System.out.println("11. Compression two elements in container");
	        System.out.println("12. Save elements in file");
	        System.out.println("13. Read elements from file");
	        System.out.println("0. The End");
	        System.out.print("Write:");
	    }
		/*
		 * Function show our string that we wrote
		 * @param str is our string
		 * */
		
		public static void ShowString(String str){
			System.out.println("Your string:");
			
	            System.out.println(str);
	    }
		/*
		 * function alphabet counting vowel and other 
		 * @param v our vowels
		 * */
		public static void Alphabet (String str) {
			int v = 0;
			int sign = 0;
			char[] vowels = {'a','e','i','o','u'};
			char [] sentence = str.toLowerCase().toCharArray();
		    for (char letter : sentence) {
		    	if(letter == ' ' || letter == '.' || letter == ',')
		    		sign++;
		        for (char vowel : vowels) {
		            if (letter == vowel) {
		                v++;
		            }
		        }
		    }
		    System.out.println(str);
		    System.out.print("\tVowels:"+ v);
		    System.out.print("\tConsonants:" + (sentence.length -v-sign));
		    System.out.println();
		    System.out.println();
	    }
		/*
		 * Function reads input string
		 * @return str1 as our used string
		 * */
		public static String InitializeString(){
	        Scanner scan = new Scanner(System.in);
	        System.out.print("Enter text whith dots: ");
	        String str1 = new String();
	        str1 = scan.nextLine();
	        return str1;
			}
		/*
		 * Function truncates a string to a point and show the first sentence
		 * @param index1 looking for dot
		 * @return str 
		 * */
		public static String CutText (String str) {
			int index1=str.indexOf('.');
			str = str.substring(index1+1);
			return str;
		}
		/*
		 * Function truncates a string to a point and show the second sentence
		 * @param index1 looking for dot
		 * @return str 
		 * */
		public static String CutText2 (String str) {
			int index1=str.indexOf('.');
			str = str.substring(0, index1+1);
			return str;
		}
		
		
		
	}

