package ua.khpi.oop.Lunhol01;

public class Main {
		final short Book=0x4666;
		final long phone=380989568786L;
		final byte binaryLastNum=0b1010110;
		final short octalLastNum=21122;
		final byte numG=10;
		final int number=(numG-1)%26+1;
        final char eng=(char)number+65;
        System.out.println(eng);
        
        int buf = Book;
        int num = 0;
        int count_parny = 0;
        int count_no_parny = 0;
        while(buf != 0) {
        	num = buf % 10;
        	if(num % 2 == 0) {
        		count_parny++;
        	}
        	else {
        		count_no_parny++;
        	}
        	
        	buf /= 10;
        }
        
        System.out.println("Nmber: " + Book + ", Parny: " + count_parny + ", Not parny: " + count_no_parny);
        
//        int a = Book;
//        int[] b = new int[50];
//        for (int i = 0; i < 50; i++) {
//            b[i] = a % 10;
//            a = a / 10;
//        }
//        for (int i=0 ; i<50;i++) {
//        if (b[i]%2 == 0) { even++;}
//        else { odd++; }
//        }
        System.out.println("Even: " + even + " " + "Odd: " + odd);
        
		}
	}