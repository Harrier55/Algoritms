package lesson2;

//Задание
//        Урок 2. Массивы и сортировка
//        1. boolean deleteAll(int value);
//        2. boolean deleteAll()
//        3. void insert(int idx, int value); // shift the tail
//        4.0. подсчитать количество действий для каждой сортировки и сравнить со сложностью О-большое
//        4. улучшить пузырьковую сортировку
//        5.** реализовать сортировку подсчётом.

import java.lang.reflect.Array;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        MassiveTestOperation massiveTestOperation = new MassiveTestOperation();

        int[] array = {3, 25, 458, 2, 5, 8, 9, 215, 559, 147, 721}; // test massive
        System.out.println("Первоначальный массив");
        System.out.println(Arrays.toString(array));

        massiveTestOperation.deleteAll(array, 9);
        massiveTestOperation.deleteAll(array);
    }
}

class MassiveTestOperation {

    boolean deleteAll(int[] array, int search) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            if (array[i] == search) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                --size;
                System.out.println("массив с выбранным удаленным значением");
                System.out.println(Arrays.toString(array));
                return true;
            }
        }
        return false;
    }

    boolean deleteAll(int[]array){
        int size = array.length;
        for (int i = 0; i < size; i++) {
            System.arraycopy(array,0,array,i,size - i);
        }
        System.out.println(Arrays.toString(array));
        return false;
    }

}