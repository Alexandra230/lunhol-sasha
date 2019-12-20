package ua.khpi.oop.Lunhol05;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Contain elements in program.
 */
class Container implements Iterable<String> {
    /**
     * First size for array.
     */
    private final int size = 10;
    /**
     * Array contains all data.
     */
    private String[] array = new String[size];
    /**
     * Counter of number elements.
     */
    private int count = 0;


    /**
     * Showing array`s data.
     */
    void showArray() {
        if (count == 0) {
            System.out.println("Empty mass");
        } else {
            System.out.println();
            for (int i = 0; i < count; i++) {
                System.out.println(array[i]);
            }
        }
    }


    /**
     * First size for array.
     * @param str1 
     */
    void addBack(final String str1) {
        if (count == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
            array[count++] = str1;
        } else {
            array[count++] = str1;
        }
    }
/**
 * function translates an array to a string
 * @param str1 our future string
 * **/

    String arrayToStr() {
        StringBuilder str1 = new StringBuilder("");
        if (count != 0) {
            str1 = new StringBuilder(array[0]);
            str1.append(" ");
        for (int i = 1; i < count; i++) {
          str1.append(array[i]);
          str1.append(" ");
            }
        }
        return str1.toString();
    }



    void clearArray() {
        array = null;
        count = 0;
    }



    int getSize() {
        return count;
    }
/**
 * the function checks if the element that is being passed is contained in the container
 * **/
    boolean contains(final String str) {
        boolean cont = false;
        for (int i = 0; i < count; i++) {
            if (cont) {
                return cont;
            } else {
                String str1;
                str1 = array[i];
                cont = str.equals(str1);
                if (i == count - 1) {
                    return cont;
                }
            }
        }
        return cont;
    }

/**
 * removal of any element from the container
 * **/

    boolean remove(final String str) {
        boolean remov = false;
        int coun = 0;
        for (int i = 0; i < count; i++) {
            if (remov) {
                break;
            } else {
                remov = str.equals(array[i]);
                coun++;
                if (i == count - 1) {
                    break;
                }
            }
        }
        array[coun - 1] = null;
        for (int i = 0; i < count; i++) {
            array[coun - 1] = array[coun++];
        }
        count--;
        return remov;
    }

    public Object[] toArray() {
        if (array == null) {
            return null;
        }
        return Arrays.copyOf(array, count);
    }

    String elementByIndex(final int index) {
        return array[index];
    }
    /*
	 * function alphabet counting vowel and other 
	 * @param v our vowels
	 * */
    void Alphabet2(final int index) {
    	String str2 = new String();
    	String str1 = new String();
    	str1 = Function.CutText(array[index - 1]);
    	str2 = Function.CutText2(array[index - 1]);
    	System.out.println("==============================");
    	Function.Alphabet(str2);
    	System.out.println("==============================");
    	Function.Alphabet(str1);
    }

    

    boolean containsAll(final Container container) {
        boolean result;
        if (container.getSize() != count) {
            return false;
        }
        for (int i = 0; i < count; i++) {
           result = array[i].equals(container.elementByIndex(i));
           if (!result) {
               return false;
           }
        }
        return true;
    }

    @Override
    public Iterator<String> iterator() {
        return new IteratorMine();

    }

    public  class IteratorMine implements Iterator<String> {
        /**
         * вложеный клас
         * унаследованый от интерфейса Iterator<String>
         */
        private int position = 0;

    @Override
    public boolean hasNext() {
        return position < count;
    }

    @Override
    public String next() {
        if (this.hasNext()) {
            return array[position++];
        } else {
            throw new NoSuchElementException();
        }
    }

        @Override
        public void remove() {
        int temp = position;
        for (int i = position; i < count; i++) {
            array[temp++] = array[i + 1];
        }
        count--;
        }
}
}
