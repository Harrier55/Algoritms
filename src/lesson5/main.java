package lesson5;

//Урок 5. Рекурсия
//        1. Написать программу по возведению числа в степень с помощью рекурсии.
//        2. *** Написать программу обхода шахматным конём доски (рекурсивно)

public class main {
    public static void main(String[] args) {
        System.out.println("Hello Recursion");
        int result = Recursion.arifmetic(2, 3);
        System.out.println("результат  = " + result);

        Recursion.hanoy(4, 1, 3, 2);
    }
}

class Recursion {

    public int counter = 0;

    public static int arifmetic(int number, int stepen) {  // задача 1

        int result = 1;
        if (stepen > 0) {
            result = number * arifmetic(number, --stepen);
            System.out.println(result);
        }
        return result;
    }

    /**ханойская башня*/

    public static void hanoy(int n, int i, int p, int v) { // где i- источник, p-приемник, v-временная

        if (n > 0) {
            hanoy(n - 1, i, v, p);
            System.out.println(i + "->" + p);
            hanoy(n - 1, v, p, i);
        }
    }

}
