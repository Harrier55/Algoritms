package lesson5;

//Урок 5. Рекурсия
//        1. Написать программу по возведению числа в степень с помощью рекурсии.
//        2. *** Написать программу обхода шахматным конём доски (рекурсивно)

public class main {
    public static void main(String[] args) {
        System.out.println("Hello Recursion");
        int result = Recursion.arifmetic(2,3);
        System.out.println("результат  = " + result);
    }
}

 class Recursion{

    public static int arifmetic(int number, int stepen){  // задача 1

        int result = 1;
        if( stepen > 0){
            result = number * arifmetic(number,--stepen);
            System.out.println(result);
        }
            return result;
    }


}
