package Lesson6;

//Урок 6. Деревья
//        1. Создать и запустить программу для построения двоичного дерева.
//        В цикле построить двести деревьев из 100 элементов.
//        Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
//        Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
//        2. Проанализировать, какой процент созданных деревьев являются несбалансированными.

import java.util.Stack;

public class main {
    public static void main(String[] args) {
        int balanceCounter = 0;
        int capacity = 200; // количество создаваемых деревьев
        Tree tree = new Tree();

        for (int trees = 0; trees < capacity; trees++) {

            // создаем дерево из случайных чисел от - 100 до 100
            for (int i = 0; i < 100; i++) {
                int data = Generate.generate(-100, 100);
                tree.insert(data);
            }

             // анализируем дерево на сбалансированность
            /**Сбалансированное дерево – это дерево, на котором  максимальное расстояние от корня до любого листа
             * различается не более чем на один , чем минимальное расстояние от корня до любого листа**/

            int min = tree.isMin();  // находим глубину до минимального узла
            int max = tree.isMax();  // находим глубину до максимального узла

            // вносим результат в  кэш
            if (Math.abs(max - min) > 1) balanceCounter++;
        }

        // Анализируем кэш

        int balanceTree = balanceCounter / capacity + 100;
        System.out.println("Процент сбалансированного дерева =  " + balanceTree);

    }
}

class Tree {
    public Node root;

    public int isMin() {
        Node current;
        int min = 0;
        current = root;
        while (current != null) {
            current = current.leftChild;
            min++;
        }
        return min;
    }

    public int isMax() {
        Node current;
        int max = 0;
        current = root;
        while (current != null) {
            current = current.rightChild;
            max++;
        }
        return max;
    }

    public void insert(int value) {
        Node newNode = new Node();
        newNode.data = value;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (value < current.data) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void printTree() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(root);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.data); // выводим его значение в консоли
                    localStack.push(temp.leftChild); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');

            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }
}


class Node {
    public int data;
    public Node leftChild;
    public Node rightChild;
}

class Generate {
    public static int generate(int min, int max) {
        max -= min;
        return (int) ((Math.random() * ++max) + min);
    }
}
