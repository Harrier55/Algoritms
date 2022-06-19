package lesson8;

//  Создать программу, реализующую метод цепочек.

//Метод цепочек является наиболее простым методом разрешения коллизий.
//        В ячейке массива мы будем хранить не элементы, а связанный список данных элементов

public class main {
    public static void main(String[] args) {

        HashMap myHashMap = new HashMap();

        myHashMap.insert(20);
        myHashMap.insert(558);
        myHashMap.insert(12);
        myHashMap.insert(8);
        myHashMap.insert(22);

        myHashMap.showHashMap();

    }
}

class HashMap {
    private static final int SIZETABLE = 25;
    private static final int HASHPARAMETER = 25;
    private Node hashTableNode[];
    private Node top[];

    // constructor
    public HashMap() {
        hashTableNode = new Node[SIZETABLE];
        top = new Node[SIZETABLE];
        for (int i = 0; i < SIZETABLE; i++) {
            hashTableNode[i] = null;
            top[i] = null;
        }

    }

    // insert
    public void insert(int value) {
        int index = hashFunction(value);
        System.out.println("value = " + value + " hash = " + index);
        Node newNode = new Node();// создаем новую Ноду

        if (hashTableNode[index] == null) {   // если место в массиве еще не занято
            hashTableNode[index] = newNode;   //
            newNode.next = null;
            newNode.value = value;

        } else {
            Node currentNode = hashTableNode[index]; // если место в массиве занято, то добавляем новый узел в список
            hashTableNode[index] = newNode;
            newNode.next = currentNode;
            newNode.value = value;
        }
    }

    public void showHashMap() {
        for (int i = 0; i < SIZETABLE; i++) {
            if (hashTableNode[i] != null) {


                int value = hashTableNode[i].value;
                System.out.println("  " + value);
            }
        }
    }

    //remove

    // find


    private int hashFunction(int key) {
        return key % HASHPARAMETER;
    }

}

class Node {
    Node next;
    Node tail;
    int value;
    int key;
}
