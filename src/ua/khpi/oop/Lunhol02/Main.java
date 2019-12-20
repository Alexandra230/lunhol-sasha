package ua.khpi.oop.Lunhol02;
import java.util.Random;
/**
 * This is my Main class,here I will write my code
 * */
public class Main {
/**
 * This function will return count_bin
 * @param bin converts a number to a binary number
 * @return count_bin
 * */	
public static int combination01(long zero_one) {
		 String bin = Long.toBinaryString(zero_one);
	       int count_bin = 0;
	       for(int i = 0; i < bin.length()-1; i++) {
	       	if(bin.charAt(i) == '0' && bin.charAt(i+1) == '1') {
	       		count_bin++;
	       	}
	       }
	      return count_bin;
	}
/**
 * This function will return count_bin
 * @param bin converts a number to a binary number
 * @return count_bin
 * */	
public static int combination10(long zero_one) {
		 String bin = Long.toBinaryString(zero_one);
	       int count_bin = 0;
	       for(int i = 0; i < bin.length()-1; i++) {
	       	if(bin.charAt(i) == '1' && bin.charAt(i+1) == '0') {
	       		count_bin++;
	       	}
	       }
	      return count_bin;
	}
 /**
  * @author ALEXANDRA
  * @version 2.0
  * Here start point of the program
  * @param args command line values
  * @param rnd generates random numbers
  * @param number int value that randomly selects numbers in the specified interval
  * **/
	public static void main(String[] args) {
		Random rnd= new Random(System.currentTimeMillis());
		for(int i=1;i<=10;i++) {
		int number = 50 + rnd.nextInt(170 - 50 + 1);
		System.out.println(i+".Number: " + number + ", BinaryNumber:"+Long.toBinaryString(number)+ ", Combination_01: "+combination01(number)+" ,Combination_10: "+combination10(number) );
		}
	}
}