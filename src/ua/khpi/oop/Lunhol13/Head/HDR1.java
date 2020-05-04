package ua.khpi.oop.Lunhol13.Head;

import java.io.Serializable;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HDR1 implements Serializable {
    private long numberPassport;
    private String specialty;
    private String workingConditions;
    private int marks;
    private int payment;

    private String data;
    private String position;
    private String education;
    private String department;
    

    public HDR1() {
    	numberPassport = 0;
    	workingConditions = null;
    	marks = 0;
    	payment = 0;
    	data = null;
    	position = null;
    	education = null;
    	department = null;
    }
    
    public HDR1 (final HDR1 obj) {
    	numberPassport = obj.numberPassport;
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
        this.numberPassport = NumberPassport;
    }

    public void setWorkingConditions(String workingConditions) {
        if (checkWorkingConditions(workingConditions)) {
            this.workingConditions = workingConditions;
        } else {
            throw new InputMismatchException();
        }
    }

    //проверка на правильность ввода
    private boolean checkWorkingConditions(final String workingConditions) {
        //регулярное выражение соответсвующая набору символов латинского алфавита и знаков разделителя
        Pattern pattern = Pattern.compile("[\\s\\w%$+#@^()=!_\\\\-]*", Pattern.CASE_INSENSITIVE);
        //провверка переменной на совпадение с регулярным выражением
        Matcher matcher = pattern.matcher(workingConditions);
        //возврат совпало/несовпало
        return matcher.matches();
    }

    private boolean checkNumberPassport(final long NumberPassport) {
        Pattern pattern = Pattern.compile("^[0-9]{9}");
        Matcher matcher = pattern.matcher(String.valueOf(NumberPassport));
        return matcher.matches();
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
        if (checkPosition(position)) {
            this.position = position;
        } else {
            throw new InputMismatchException();
        }
	}

    private boolean checkPosition(final String position) {
        Pattern pattern = Pattern.compile("[a-z]*-?\\s?", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(position);
        return matcher.matches();
    }

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
        if (checkDepartment(department)) {
            this.department = department;
        } else {
            throw new InputMismatchException();
        }
	}

    private boolean checkDepartment(final String department) {
        //регулярное выражение соответсвующая набору символов латинского алфавита и знаков разделителя
        Pattern pattern = Pattern.compile("[\\s\\w%$+#@^()=!_\\\\-]*", Pattern.CASE_INSENSITIVE);
        //провверка переменной на совпадение с регулярным выражением
        Matcher matcher = pattern.matcher(department);
        //возврат совпало/несовпало
        return matcher.matches();
    }

	public void setNumberPassport(long numberPassport) {
        if (checkNumberPassport(numberPassport)) {
            this.numberPassport = numberPassport;
        } else {
            throw new InputMismatchException();
        }
	}

	public int getPayment() {
        return payment;
    }
    public String getWorkingConditions() {
        return workingConditions;
    }

    public long getNumberPassport() {
        return numberPassport;
    }

    public void generateVacancy() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int choose = 0;
        System.out.print("\nВведите номер паспорта: ");
        setNumberPassport(scan.nextLong());
        System.out.print("\nВведите образование: ");
        setEducation(scan2.nextLine());
        System.out.print("\nОплата: ");
        setPayment(scan.nextInt());
        System.out.print("\nДата взятия на должность: ");
        setData(scan2.nextLine());
        System.out.print("\nВведите должность: ");
        setPosition(scan2.nextLine());
        System.out.print("\nВведите отдел: ");
        setDepartment(scan2.nextLine());
        System.out.print("\nНабор свойств: ");
        setWorkingConditions(scan2.nextLine());
        System.out.println("\nОценка кандидата: ");
        setMarks(scan.nextInt());
    }


    

    public void setData(String data) {
        if (checkData(data)) {
            this.data = data;
        } else {
            throw new InputMismatchException();
        }
    }

    private boolean checkData(final String data) {
        Pattern pattern = Pattern.compile("[0-9]{2}:[0-9]{2}:[0-9]{2}");
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public String getData() {
        return data;
    }

    public void setEducation(String education) {
        if (checkEducation(education)) {
            this.education = education;
        } else {
            throw new InputMismatchException();
        }
    }

    private boolean checkEducation(final String education) {
        Pattern pattern = Pattern.compile("[a-z]*-?\\s?", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(education);
        return matcher.matches();
    }

    public String getEducation() {
        return education;
    }

	@Override
	public String toString() {
		return "NumberPassport = " + numberPassport + "\n" + "workingConditions = "
				+ workingConditions + "\n" +"marks = " + marks + "\n" +"payment = " + payment + "\n" + "data = " + data + "\n" + "position = "
				+ position + "\n" +"education = " + education + "\n" +"department =" + department;
	}
    //компоратор - это функция для сравнения обьектов по определённому полю в моем контейнере и
    //использованию в встроеном методе сорт

    public static final Comparator<HDR1> compareByPassport = new Comparator<HDR1>() {
        @Override
        public int compare(HDR1 o1, HDR1 o2) {
            return (int) (o1.getNumberPassport() - o2.getNumberPassport());
        }
    };
    public static final Comparator<HDR1> compareByPayment = new Comparator<HDR1>() {
        @Override
        public int compare(HDR1 o1, HDR1 o2) {
            return o1.getPayment() - o2.getPayment();
        }
    };
    public static final Comparator<HDR1> compareByMarks = new Comparator<HDR1>() {
        @Override
        public int compare(HDR1 o1, HDR1 o2) {
            return o1.getMarks() - o2.getMarks();
        }
    };
    
    
}
