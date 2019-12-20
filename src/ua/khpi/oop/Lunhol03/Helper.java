package ua.khpi.oop.Lunhol03;
/**
 * This is my Helper class,here I will write my function
 * */
public class Helper {
	/**
	 *  Function Alphabet counts the number of vowels and consonants in each sentence
	 *  This function displays the result of the calculation of vowels and consonants
	 *  @param str transmitted parameter
	 *  @param v variable of type int in which will be stored the number of counted vowels 
	 * **/
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
}
