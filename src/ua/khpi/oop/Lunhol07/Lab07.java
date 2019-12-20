package ua.khpi.oop.Lunhol07;

public class Lab07 {
	public static void main(String[] args) {
        Container contains = new Container();
        HDR rec1 = new HDR();
        HDR rec2 = new HDR();
        rec1.generateVacancy();
        contains.add(rec1);
        System.out.println("\n");
        contains.add(rec1);
        System.out.println("\n");
        contains.add(rec1);
        System.out.println("\n");
        rec2.generateVacancy();
        contains.add(rec2);
        contains.show();
    }
}
