package ua.khpi.oop.Lunhol08;

import java.util.Scanner;

class HDR1 {
    private long NumberPassport;
    private String specialty;
    private String workingConditions;
    private int marks;
    private int payment;

    private String data;
    private String position;
    private String education;
    private String department;
    

    HDR1() {
    	NumberPassport = 0;
    	specialty =  null;
    	workingConditions = null;
    	marks = 0;
    	payment = 0;
    	data = null;
    	position = null;
    	education = null;
    	department = null;
    }
    
    HDR1 (final HDR1 obj) {
    	NumberPassport = obj.NumberPassport;
    	specialty =  obj.specialty;
    	workingConditions = obj.workingConditions;
    	marks = obj.marks;
    	payment = obj.payment;
    	data = obj.data;
    	position = obj.position;
    	education = obj.education;
    	department = obj.department;
    }

    public void setFirm(long NumberPassport) {
        this.NumberPassport = NumberPassport;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setWorkingConditions(String workingConditions) {
        this.workingConditions = workingConditions;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setNumberPassport(long numberPassport) {
		NumberPassport = numberPassport;
	}

	int getPayment() {
        return payment;
    }
    String getWorkingConditions() {
        return workingConditions;
    }
    String getSpecialty() {
        return specialty;
    }
    long getNumberPassport() {
        return NumberPassport;
    }

    void generateVacancy() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int choose = 0;
        System.out.print("\nВведите номер паспорта: ");
        NumberPassport = scan.nextLong();
        System.out.print("\nВведите образование: ");
        education = scan2.nextLine();
        System.out.print("\nОплата: ");
        payment = scan.nextInt();
        System.out.print("\nДата взятия на должность: ");
        data = scan2.nextLine();
        System.out.print("\nВведите должность: ");
        position = scan2.nextLine();
        System.out.print("\nВведите отдел: ");
        department = scan2.nextLine();
        System.out.print("\nНабор свойств: ");
        workingConditions = scan2.nextLine();
        System.out.println("\nОценка кандидата: ");
        marks = scan.nextInt();
    }


    

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducation() {
        return education;
    }
    
    
}
