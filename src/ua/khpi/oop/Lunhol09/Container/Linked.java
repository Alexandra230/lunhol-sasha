package ua.khpi.oop.Lunhol09.Container;

import java.io.IOException;
import java.io.Serializable;
//создаем интерфейс линкд
//обьявление прототипов функций 
// Т джунерик (обобщение)

public interface Linked<T> extends Serializable, Iterable<T> {
    void addLast(T obj);
    void addFirst(T obj);
    int size();
    T getElementByIndex(int index);
    void saveAll();
    void saveRec();
    void add(T obj);
    void clear();
    boolean notEmpty();
    void readRec() throws IOException;
    void readAll();
}
