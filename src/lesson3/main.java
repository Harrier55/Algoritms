package lesson3;

//        Задание
//
//        Урок 3. Стек и очередь
//        1. Создать класс для реализации дека (двухсторонняя очередь).
//        2. Создать класс для реализации приоритетной очереди (выбрать только один из вариантов)
//        3. описать метод проверки скобочной последовательности (см. код урока, комментарий под главным классом)

import java.lang.reflect.Array;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello in Lesson 3");

    }
}

/** ------------------  задача 1 Двухсторонняя очередь---------------**/

// * Двусторонняя очередь  – очередь, у которой нет явно выраженного конца и начала.
// * Она может расти и уменьшаться в обоих направлениях.

class Deque {
    int size;
    int head = -1;
    int tail = 0;
    int[] data;

    /** проверка что очередь  пустая , если head == -1, то она пуста */
    boolean isEmpty() {
        return head == tail;
    }

    /** проверка что очередь заполнена**/
    boolean isFull() {
        return ((head == 0 && tail == size - 1) || head == tail + 1);
    }

    /** добавить элемент в начало очереди **/
    void pushFront(int value) {
        if (isFull()) {                     // проверка, что в очереди есть место
            System.out.println("Переполнение");
            return;
        }

        if (head < 1) {           //если индекс на начало < 1, то
            head = size - 1;    //передвигаем его на последний эл-т массива
        } else {                // иначе
            head++;             // увеличиваем указатель на 1
            data[head] = value; // присваеваем значение в голову очереди
        }
    }

    /** вставка в конец очереди */
    void pushBack(int value) {

        if (isFull()) {                     // проверка, что в очереди есть место
            System.out.println("Переполнение");
            return;
        }

        if (head == -1) {               // если указатель на голову =-1, тогда
            head = 0;                   // тогда ставим указатели хвоста и головы равными 0, т.е в начало
            tail = 0;
        } else if (tail == size - 1) {   // или, если указатель на хвост = size - 1
            tail = 0;                    // тогда указатель на хвост устанавливаем = 0
        } else {
            tail = tail + 1;            // если все условия выше не выполнены, тогда tail = tail + 1
        }

        data[tail] = value;             // присваеваем значение в хвост очереди
    }

    /** получить элемент из начала очереди **/
    int popFront() {
        if (++head == size)             // если указатель головы указывает на конец массива,
            head = 0;                   // то переместить указатель головы в начало массива на 0
        return data[head];              // вернуть значение из головы
    }

    /** получить элемент из хвоста очереди **/
    int popBack() {
        int res = data[tail];
        if (--tail < 0)                 // если указатель хвоста указывает на начало массива, то после получения значения
            tail = size - 1;            // перемещаем указатель хвоста массива  на начало массива
        return res;
    }
}

/** ------------------  задача 2 Реализация приоритетной очереди ---------------**/

//        Очереди с приоритетом — разновидность очередей, в которой у каждого элемента есть свой приоритет.
//        Обслуживаются они в соответствии со своими приоритетом. Если у элементов одинаковый приоритет,
//        то обслуживаются они по их порядку в очереди.
//         Обычная очередь подчиняется принципу FIFO «первый вошел — первый вышел».
//        В очередях с приоритетом элементы удаляются в соответствии с их приоритетом.
//        То есть, элемент с самым высоким приоритетом удаляется из очереди в первую очередь.
//       У элемента с самым большим значением самый высокий приоритет( или наоборот - самый высокйи
//      приоритет может быть у минимального значения

class MyPriorityQueue{
    int[] queue;
    int size = queue.length;
    int head = 0;
    int tail = 0;

    boolean isEmpty(){                  // проверка массива на пустоту
        return (this.head == this.tail);
    }

    boolean isFull(){                   // проверка массива на переполненость
        return tail-1 == size;
    }

    void pushElement(int element){ // вставляем элемент в массив и сразу сортируем его по возрастанию
                                    // т.о. элемент с максимальным приоритетом окажется в начале массива

        if(isFull()){               // если массив переполнен, увеличиваем ему размер
            int array[]= new int [size*2];
            System.arraycopy(queue,0,array,0,size);
            queue = array;
        }

        if (isEmpty()){     // если массив пуст, то вставляем элемент в начало
            queue[0] = element;
        }else {             // если массив не пуст,начинаем заполнять массив
            for (int i = 0; i < this.size; i++) {
                if (queue[i]>element){      //если вставляемый элемент окажется больше текущего элемента массива
                                                    // , то вставляем его в это место
                                                    // и остаток массива сдвигаем вправо
                    int temp = queue[i];
                    queue[i] = element;
                    System.arraycopy(queue,i+1,queue,i,size - i - 1);
                    queue[i] = temp;
                    tail++;
                }
            }
        }
    }

    int popElement() {
        // получаем первый элемент из массива и сдвигаем оставшийся хвост влево
        int element = 0;
        if (isEmpty()) {
            System.out.println("Массив пуст");
        } else {
            element = queue[0];
            System.arraycopy(queue, 1, queue, 0, size - 1);
            tail--;
        }
        return element;
    }



}

/** ------------------  задача 3 Проверка скобочной последовательности---------------**/

class Check{
    Stack stack = new Stack();

    boolean balance = true;
    public void checker(String str){    // на вход метода приходит строка из скобок
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {       // если символ -открывающая скобка
                stack.push(str.charAt(i));  // то добавляем ее в стек
            } else if (str.charAt(i) == ')') {    // если символ - закрывающая скобка, то начинаем проверки

                if (!stack.isEmpty()) {           // проверка, если стэк не пустой, то

                    Character resultStackPop = (Character) stack.pop(); // достаем верхнее значение из стэка
                    if ((resultStackPop.equals('(') && str.charAt(i) != ')')) { // если сочетание скобок такое - (  )
                        stack.pop();                                            //удаляем последнее значение из стэка
                        balance = false;                                    // ставим флаг - не сбалансировано
                        break;                                              // выходим из цикла
                    }

                } else if (stack.isEmpty()) {            // если стэк пустой - выводим ошибку
                    System.out.println(" такая скобка ) не может быть начальной");
                    balance = false;
                    break;                               // выходим из цикла
                }
            }
        }
        // в итоге получится, что если условия не выполнены, то

        if(balance == true){
            System.out.println("Скобки сбалансированы");
        }else {
            System.out.println("Скобки не сбалансированы");
        }
    }


}
