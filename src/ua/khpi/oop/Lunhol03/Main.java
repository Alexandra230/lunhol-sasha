package ua.khpi.oop.Lunhol03;
/**
 * This is my Main class,here I will write my code
 * */
public class Main {
	/**
	  * @author ALEXANDRA
	  * @version 3.0
	  * Here start point of the program
	  * @param args command line values
	  * @param str help us to create our string
	  * @param str1 empty string
	  * This function uses class Helper  in which the count function Alphabet
	  * **/
	public static void main(String[] args) {
		String str=new String("Shooting videos is prohibited.Turn off the camera.");
		String str1 = new String();
		int index1=str.indexOf('.');
		str1 = str.substring(index1+1);
		str = str.substring(0, index1+1);
		Helper.Alphabet(str);
		Helper.Alphabet(str1);
	}


}
