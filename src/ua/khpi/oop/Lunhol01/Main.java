package ua.khpi.oop.Lunhol01;

public class Main {
	public static int count_parny(long number) {
		long buf=number;
		long num=0;
	int count_parny = 0;
		while(buf != 0) {
        	num = buf % 10;
        	if(num % 2 == 0) {
        		count_parny++;
        	}
        	buf /= 10;
        }
		return count_parny;
	}
	public static int count_no_parny(long number) {
		long buf=number;
		long num=0;
	int count_no_parny = 0;
		while(buf != 0) {
        	num = buf % 10;
        	if(num % 2 != 0) {
        		count_no_parny++;
        	}
        	buf /= 10;
        }
		return count_no_parny;
	}
	public static int count_odin(long one) {
		 String bin = Long.toBinaryString(one);
	       
	        
	        int count_bin = 0;
	        
	        for(int i = 0; i < bin.length(); i++) {
	        	if(bin.charAt(i) == '1') {
	        		count_bin++;
	        	}
	        }
	       return count_bin;
	}
	
	public static void main(String[] args) {
		final short Book=0x4665;   //0х для считывания числа в 16 системе
		final long Phone=380989568786L;  //L для типа  long
		final byte binaryLastNum=0b1010110;  //0b двоичный литерал
		final short octalLastNum=021122;  //0 в начале для восьмиричного литерала
		final byte numG=10;
		final int number=(numG-1)%26+1;
        final char eng=(char)number+65;
//        System.out.println(eng);
       
       
        System.out.println("Numer: " + Book + ", Parny: " + count_parny(Book) + ", Not parny: " + count_no_parny(Book)+", BinaryNum: "+Long.toBinaryString(Book)+",BinaryCount: "+count_odin(Book));
        System.out.println("Numer: " + Phone + ", Parny: " + count_parny(Phone) + ", Not parny: " + count_no_parny(Phone)+", BinaryNum: "+Long.toBinaryString(Phone)+",BinaryCount: "+count_odin(Phone));
        System.out.println("Numer: " + binaryLastNum + ", Parny: " + count_parny(binaryLastNum) + ", Not parny: " + count_no_parny(binaryLastNum)+", BinaryNum: "+Long.toBinaryString(binaryLastNum)+",BinaryCount: "+count_odin(binaryLastNum));
        System.out.println("Numer: " + octalLastNum + ", Parny: " + count_parny(octalLastNum) + ", Not parny: " + count_no_parny(octalLastNum)+", BinaryNum: "+Long.toBinaryString(octalLastNum)+",BinaryCount: "+count_odin(octalLastNum));
        System.out.println("Numer: " + numG + ", Parny: " + count_parny(numG) + ", Not parny: " + count_no_parny(numG)+", BinaryNum: "+Long.toBinaryString(numG)+",BinaryCount: "+count_odin(numG));
        System.out.println("Numer: " + number + ", Parny: " + count_parny(number) + ", Not parny: " + count_no_parny(number)+", BinaryNum: "+Long.toBinaryString(number)+",BinaryCount: "+count_odin(number));

		}
	}