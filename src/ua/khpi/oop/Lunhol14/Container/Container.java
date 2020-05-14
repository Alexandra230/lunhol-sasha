package ua.khpi.oop.Lunhol14.Container;

import ua.khpi.oop.Lunhol14.Head.HDR1;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Container<T extends HDR1> implements Linked<T>, Serializable {

    //конструктор инициализации
    public Container() {
        head = new Node<>(null, null, tail);
        tail = new Node<>(null, head, null);
        head = new Node<>(null, null, tail);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public T next() {
                if (this.hasNext()) {
                    return getElementByIndex(position++);
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    @Override
    public boolean notEmpty() {
        return size > 0;
    }

    @Override
    public void clear() {
        for (Node<T> x = head; x != null; ) {
            Node<T> next = x.nextElem;
            x.currentElem = null;
            x.nextElem = null;
            x.prevElem = null;
            x = next;
        }
        head = null;
        tail = null;
        tail = new Node<>(null, head, null);
        head = new Node<>(null, null, tail);
        size = 0;
    }

    @Override
    public void add(final T obj) {
        addLast(obj);
    }

    @Override
    public void saveAll() {
        try {
            File file = new File("save.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            System.out.println();
            pw.println(size);
            for (int i = 0; i < size; i++) {
                pw.println(getElementByIndex(i));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }
    
    public void saveIn(Linked<T> obj) throws IOException {
        FileOutputStream file = new FileOutputStream("save.sasha");
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(obj);
        object.close();
    }
    
    @Override
    public void saveRec() {
        try {
            File file = new File("save.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            HDR1 temp;
            System.out.println();
            pw.println(size);
            for (int i = 0; i < size; i++) {
                temp = (HDR1) getElementByIndex(i);
                pw.println(temp.getNumberPassport());
                pw.println(temp.getEducation());
                pw.println(temp.getPayment());
                pw.println(temp.getData());
                pw.println(temp.getPosition());
                pw.println(temp.getDepartment());
                pw.println(temp.getWorkingConditions());
                pw.println(temp.getMarks());  
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    @Override
    public void readAll() {
        try (BufferedReader br = new BufferedReader(new FileReader("save.txt"))) {
            Object temp;
            String line;
            line = br.readLine();
            int count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                line = br.readLine();
                temp = line;
                add((T) temp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void readRec() throws IOException {
    	BufferedReader br = null;
        HDR1 temp = new HDR1();
        try {
            br = new BufferedReader(new FileReader("save.txt"));
            String line;
            line = br.readLine();
            int count = Integer.parseInt(line);
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
                add((T) new HDR1(temp));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            br.close();
        }
    }
        
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> temp = head; i < size; temp = temp.nextElem) {
            result[i++] = temp.currentElem;
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private Node<T> head; //первый элемент
    private Node<T> tail; //последний элемент
    private int size = 0; //размер списка



    @Override
    public void addLast(final T obj) {
        Node<T> prev = tail; //сохранение данных хвоста
        prev.setCurrentElem(obj); //установка значения
        tail = new Node<>(null, prev, null); //изменение указателя хвоста
        prev.setNextElem(tail); //установка указателя на хвост
        size++; //увелечение размера списка

    }

    @Override
    public void addFirst(final T obj) {
        Node<T> next = head;
        next.setCurrentElem(obj);
        head = new Node<>(null, null, next);
        next.setPrevElem(head);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getElementByIndex(final int index) {
        Node<T> target = head.getNextElem(); //след элемент первого узла
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElem();
    }

    private Node<T> getNextElement(final Node<T> index) {
        return index.getNextElem();
    }

    // head -> null & tail -> null
    // null <- prevElem [head(t = null)] nextElem-> & <- prevElem [head(t = null)] nextElem -> null
    private class Node<T> implements Serializable {
        private T currentElem;
        private Node<T> prevElem;
        private Node<T> nextElem;


        Node(final T currentElem, final Node<T> prevElem, final Node<T> nextElem) {
            this.currentElem = currentElem;
            this.prevElem = prevElem;
            this.nextElem = nextElem;
        }


        public T getCurrentElem() {
            return currentElem;
        }

        public void setCurrentElem(final T currentElem) {
            this.currentElem = currentElem;
        }

        public Node<T> getPrevElem() {
            return prevElem;
        }

        public void setPrevElem(final Node<T> prevElem) {
            this.prevElem = prevElem;
        }

        public Node<T> getNextElem() {
            return nextElem;
        }

        public void setNextElem(final Node<T> nextElem) {
            this.nextElem = nextElem;
        }
    }
}
