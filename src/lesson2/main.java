package lesson2;

//Задание
//        Урок 2. Массивы и сортировка
//        1. boolean deleteAll(int value);
//        2. boolean deleteAll()
//        3. void insert(int idx, int value); // shift the tail
//        4.0. подсчитать количество действий для каждой сортировки и сравнить со сложностью О-большое
//        4. улучшить пузырьковую сортировку
//        5.** реализовать сортировку подсчётом.


import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        MassiveTestOperation massiveTestOperation = new MassiveTestOperation();

        int[] array = {3, 25, 458, 2, 5, 8, 9, 215, 559, 147, 721}; // test massive

        System.out.println("Первоначальный массив");
        System.out.println(Arrays.toString(array));

        massiveTestOperation.deleteAll(array, 9);       // задача 1
        massiveTestOperation.deleteAll(array);                // задача 2
        massiveTestOperation.insert(array, 5, 111111);// задача 3
        massiveTestOperation.bubbleSort();                      // задача 4 - обычный алгоритм пузырька
        massiveTestOperation.bubbleSortSuper();                 // задача 4 - усовершенствованый  алгоритм пузырька
                                                                // количество итераций сократилось с 25 до 19
    }
}

class MassiveTestOperation {

    // todo Сложность O(n)

    boolean deleteAll(int[] array, int search) {
        int size = array.length;
        int counter = 0;
        for (int i = 0; i < size; i++) {
            counter ++;
            if (array[i] == search) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                --size;
                System.out.println("массив с выбранным удаленным значением");
                System.out.println(Arrays.toString(array));
                System.out.println("количество итераций = " + counter);
                return true;
            }
        }
        return false;
    }

    // Уважемый преподаватель, возможно здесь я не понял, что от меня требуется
    // решил, что нужно просто обнулить массив

    // todo Сложность O(n)
    void deleteAll(int[] array) {
        int size = array.length;
        int counter = 0;

        for (int i = 0; i < size; i++) {
            counter ++;
            array[i] = 0;
        }
        System.out.println("массив с удаленными занчениями");
        System.out.println(Arrays.toString(array));
        System.out.println("количество итераций = " + counter);
    }

    // todo Сложность O(n)
    void insert(int[] array, int idx, int value) {
        int size = array.length;
        int counter = 0;

        //  проверить чтобы индекс был в пределах
        if ((idx >= 0) && (idx <= size)) {

        //  создаем новый массив размером n + 1

            int newarray[] = new int[size + 1];

        //  вставляем элементы из сторого массива в новый до заданного индекса
            for (int i = 0; i < idx; i++) {
                counter ++;
                newarray[i] = array[i];
            }
        // вставляем элемент по индексу
            newarray[idx] = value;
            counter ++;

        // добавляем оставшиеся
            for (int i = idx + 1; i < size + 1; i++) {
                counter ++;
                newarray[i] = array[i - 1];
            }

        // возвращаем ссылку на массив
        array = newarray;

            System.out.println("вставка числа " + value + " в массив");
            System.out.println(Arrays.toString(array));
            System.out.println("количество итераций = " + counter);
        } else {
            System.out.println("число не входи в диапазон массива");
        }
    }

    void bubbleSort(){
        int[] array = {35, 25, 458, 888, 2, 5, 8, 9, 215, 559, 147, 721}; // test massive
        int size = array.length;
        int counter = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i +1; j < size; j++) {
                if(array[i] > array[j]) {
                    int a = array[i]; // a - значение, которое больше
                    array[i] = array[j];
                    array[j] = a;
                    counter ++;
                }
            }
        }
        System.out.println(" Отсортированый массив обычным пузырьком");
        System.out.println(Arrays.toString(array));
        System.out.println("количество итераций = " + counter);
    }


    // todo более совершенный алгоритм пузырьком
    void bubbleSortSuper(){
        int[] array = {35, 25, 458, 888, 2, 5, 8, 9, 215, 559, 147, 721}; // test massive
        int size = array.length;
        int counter = 0;

        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i ; j--) {
                if(array[i] > array[j]) {
                    int a = array[i]; // a - значение, которое больше
                    array[i] = array[j];
                    array[j] = a;
                    counter ++;
                }
            }
        }
        System.out.println(" Отсортированый массив усовершенствованным  пузырьком");
        System.out.println(Arrays.toString(array));
        System.out.println("количество итераций = " + counter);
    }

}