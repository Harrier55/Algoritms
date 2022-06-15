package lesson7;

//Урок 7. Графы
//        1. Реализовать программу, в которой задается граф из 10 вершин.
//        Задать ребра и найти кратчайший путь с помощью поиска в ширину.

import java.util.PriorityQueue;
import java.util.Queue;

public class main {
    public static void main(String[] args) {

        Graf graf = new Graf();
        initGraf(graf);

        graf.showGraf();
        System.out.println("____________________________");

        graf.bfc();

    }

    public static void initGraf(Graf graf){
        graf.addVertex('A');
        graf.addVertex('B');
        graf.addVertex('C');
        graf.addVertex('F');
        graf.addVertex('G');
        graf.addVertex('E');
        graf.addVertex('F');
        graf.addVertex('J');
        graf.addVertex('P');
        graf.addVertex('Q');


        graf.addEdge(0,1,1);
        graf.addEdge(0,2,2);
        graf.addEdge(0,3,3);
        graf.addEdge(1,3,2);
        graf.addEdge(1,4,6);
        graf.addEdge(2,5,7);
        graf.addEdge(3,5,3);
        graf.addEdge(3,6,2);
        graf.addEdge(4,7,7);
        graf.addEdge(5,9,8);
        graf.addEdge(5,6,5);
        graf.addEdge(6,7,4);
        graf.addEdge(6,9,10);
        graf.addEdge(7,8,11);
        graf.addEdge(7,9,15);
        graf.addEdge(8,9,6);
    }
}

class Graf{
    private final int MAX_VERTEX_SIZE = 10; // коичество вершин графа
    private final int INFINITY = 1_000_000_000; // имитируем бесконечность
    private Vertex vertexList[]; // массив вершин
    private int matrix[][]; // матрица связей графа
    private int counterVertex;  //счетчик для вершин
    private Queue<Integer>queue;

    // конструктор
    public Graf(){
        counterVertex = 0;
        queue = new PriorityQueue<>();
        vertexList = new Vertex[MAX_VERTEX_SIZE];         // создаем массив для хранения вершин
        matrix = new int[MAX_VERTEX_SIZE][MAX_VERTEX_SIZE];// создаем матрицу смежности
        for (int i = 0; i < MAX_VERTEX_SIZE; i++) {   // и заполняем ее значениями 0
            for (int j = 0; j < MAX_VERTEX_SIZE; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    // обход в ширину
    public void bfc(){
        vertexList[0].setVisited(true);        // говорим что вершина просмотрена
        vertexList[0].setMarkerVertex(0);       // устанавливаем маркер вершины = 0
        displayVertex(0);
        queue.add(0);
        int newVertex;

        while (!queue.isEmpty()) {       // пока очередь не пуста крутимся по циклу
            int v = queue.remove();     // достаем первый  элемент из очереди по принципу FIFO

            while ((newVertex = getVertexInMatrix(v)) != -1) {  // проходим все смежные вершины

                // логика подсчета
                int summ = matrix[v][newVertex];

                vertexList[newVertex].setVisited(true);     // говорим что вершина просмотрена

                displayVertex(v);

                displayVertex(newVertex);

                System.out.println("вес ребра " + summ   );
                queue.add(newVertex);
            }

        }


    }
    // проверяем, что к проверяемой вершине есть ребро (т.е вес > 0)
    // и вершина еще не была посещена
    private int getVertexInMatrix(int v) {
        for (int i = 0; i < MAX_VERTEX_SIZE; i++) {
            if (matrix[v][i] > 0 && vertexList[i].getIsVisited() == false) {
                return i;  // возвращаем индекс вершины
            }
        }
        return -1;  // если вершин не нашлось, возвращаем  -1
    }

    // добавить вершины в гарф
    public void addVertex(char label) {// задание новых вершин
        vertexList[counterVertex++] = new Vertex(label);
    }

    // создать матрицу смежности
    public void addEdge(int start, int end, int weight) {
        matrix[start][end] = weight; // задание ребер между вершинами, с весом между ними
    }
    // отобразить вершину
    public void displayVertex(int v) {
        System.out.println(vertexList[v].getLabel() + "  маркер  " + vertexList[v].getMarkerVertex());
    }

    public void showGraf(){
        for (int i = 0; i < vertexList.length; i++) {
            displayVertex(i);
        }
    }
}

class Vertex{
    private final int INFINITY = 1_000_000_000; // имитируем бесконечность
    private char label;         // обозначение вершины
    private boolean isVisited; // посещена ли вершина
    private int markerVertex;

    public Vertex(char label) {
        this.label = label;
        this.isVisited = false;
        this.markerVertex = INFINITY;
    }

    public int getMarkerVertex() {
        return markerVertex;
    }

    public void setMarkerVertex(int markerVertex) {
        this.markerVertex = markerVertex;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean getIsVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}