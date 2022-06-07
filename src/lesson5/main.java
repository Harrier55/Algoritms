package lesson5;

//Урок 5. Рекурсия
//        1. Написать программу по возведению числа в степень с помощью рекурсии.
//        2. *** Написать программу обхода шахматным конём доски (рекурсивно)

public class main {
    public static void main(String[] args) {
        System.out.println("Hello Recursion");
        int result = Recursion.arifmetic(2, 3);
        System.out.println("результат  = " + result);

//        System.out.println("Tower");

//        Recursion.hanoy(4, 1, 3, 2); // ханойская башня

        System.out.println("Horse");

        HorseGo horseGo = new HorseGo(4);// задаем размер доски
        horseGo.print_desk();

    }
}

class HorseGo {
    int x;
    int y;
    int[][] variki = {};

    public HorseGo(int size){  // задаем размер доски
        this.x = size;
        this.y = size;
    }

    public  void print_desk(){  // печатаем доску
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print("0 ");
            }
            System.out.println("");
        }
    }
}

class Recursion {

    public static int arifmetic(int number, int stepen) {  // задача 1

        int result = 1;
        if (stepen > 0) {
            result = number * arifmetic(number, --stepen);
            System.out.println(result);
        }
        return result;
    }

    /**ханойская башня*/

    public static void hanoy(int size, int from, int to, int temp) { // где from- источник, to-приемник, temp-временная

//        System.out.println("итерация");

        if (size > 0) {
            hanoy(size - 1, from, temp, to);
            System.out.println(from + "->" + to);
            hanoy(size - 1, temp, to, from);
        }
    }



}
