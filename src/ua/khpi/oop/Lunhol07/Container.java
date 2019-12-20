package ua.khpi.oop.Lunhol07;

import java.util.Arrays;

class Container {

    /**
     * First size for array.
     */
    private final int size = 10;
    /**
     * Array contains all data.
     */
    private int count = 0;

    private HDR[] massik = new HDR[size];


    void add(final HDR temp){
        if (count == massik.length) {
            massik = Arrays.copyOf(massik, massik.length * 2);
            massik[count++] = temp;
        } else {
            massik[count++] = temp;
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
                System.out.println("Оценка кандидата: " + massik[i].getEducation());
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
}
