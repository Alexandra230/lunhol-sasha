package ua.khpi.oop.Lunhol08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;

class Container implements Serializable {

    /**
     * First size for array.
     */
    private final int size = 10;
    /**
     * Array contains all data.
     */
    private int count = 0;

    private HDR1[] massik = new HDR1[size];


    void add(final HDR1 temp){
    	HDR1 buff = new HDR1(temp);
        if (count == massik.length) {
            massik = Arrays.copyOf(massik, massik.length * 2);
            massik[count++] = buff;
        } else {
            massik[count++] = buff;
        }
    }

    void show() {	
        if (count == 0) {
            System.out.println("Ошибка! Массив пустой!");
        } else {
            System.out.println();
            for (int i = 0; i < count; i++) {
                System.out.println("Кандидат №" + (i+1));
                System.out.println("Паспорт: " + massik[i].getNumberPassport());
                System.out.println("Образование: " + massik[i].getEducation());
                System.out.println("Оклад: " + massik[i].getPayment());
                System.out.println("Дата трудоустройства: " + massik[i].getData());
                System.out.println("Должность: " + massik[i].getPosition());
                System.out.println("Отдел: " + massik[i].getDepartment());
                System.out.println("Набор качеств: " + massik[i].getWorkingConditions());
                System.out.println("Оценка кандидата: " + massik[i].getMarks());
            }
        }
    }

    void clear() {
        for (int i = 0; i < count; i++) {
            massik[i] = null;
        }
        count = 0;
    }

    public void remove(int index) {
        for (int i = index; i < count; i++) {
            massik[index++] = massik[i + 1];
        }
        count--;
    }
    

    int size() {
        return count;
    }
    
    void save() {
        try {
            File file = new File("save.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            System.out.println();
            for (int i = 0; i < count; i++) {
                pw.println(count);
                pw.println(massik[i].getNumberPassport());
                pw.println(massik[i].getEducation());
                pw.println(massik[i].getPayment());
                pw.println(massik[i].getData());
                pw.println(massik[i].getPosition());
                pw.println(massik[i].getDepartment());
                pw.println(massik[i].getWorkingConditions());
                pw.println(massik[i].getMarks());
                }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    void save(final String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            System.out.println();
            for (int i = 0; i < count; i++) {
                pw.println(count);
                pw.println(massik[i].getNumberPassport());
                pw.println(massik[i].getEducation());
                pw.println(massik[i].getPayment());
                pw.println(massik[i].getData());
                pw.println(massik[i].getPosition());
                pw.println(massik[i].getDepartment());
                pw.println(massik[i].getWorkingConditions());
                pw.println(massik[i].getMarks());
                }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    void read() throws IOException {
        BufferedReader br = null;
        HDR1 temp = new HDR1();
        try {
            br = new BufferedReader(new FileReader("save.txt"));
            String line;
            line = br.readLine();
            count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                line = br.readLine();
                temp.setNumberPassport(Integer.parseInt(line));
                line = br.readLine();
                temp.setEducation(line);
                line = br.readLine();
                temp.setPayment(Integer.parseInt(line));
                line = br.readLine();
                temp.setData(line);
                line = br.readLine();
                temp.setPosition(line);
                line = br.readLine();
                temp.setDepartment(line);
                line = br.readLine();
                temp.setWorkingConditions(line);
	            line = br.readLine();
	            temp.setMarks(Integer.parseInt(line));
     
                massik[i] = new HDR1(temp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            br.close();
        }
    }
}
