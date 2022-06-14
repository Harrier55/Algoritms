package lesson7;

//Урок 7. Графы
//        1. Реализовать программу, в которой задается граф из 10 вершин.
//        Задать ребра и найти кратчайший путь с помощью поиска в ширину.

public class main {
    public static void main(String[] args) {

        Graf graf = new Graf();

        graf.addVertex('0');
        graf.addVertex('1');
        graf.addVertex('2');
        graf.addVertex('3');
        graf.addVertex('4');
        graf.addVertex('5');
        graf.addVertex('6');
        graf.addVertex('7');
        graf.addVertex('8');
        graf.addVertex('9');


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

    public Graf(){
        counterVertex = 0;
        vertexList = new Vertex[MAX_VERTEX_SIZE];         // создаем массив для хранения вершин
        matrix = new int[MAX_VERTEX_SIZE][MAX_VERTEX_SIZE];// создаем матрицу смежности
        for (int i = 0; i < MAX_VERTEX_SIZE; i++) {   // и заполняем ее значениями бесконечность
            for (int j = 0; j < MAX_VERTEX_SIZE; j++) {
                matrix[i][j] = INFINITY;
            }
        }
    }

    public void addVertex(char label) {// задание новых вершин
        vertexList[counterVertex++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        matrix[start][end] = weight; // задание ребер между вершинами, с весом между ними
    }
}

class Vertex{
    private char label;
    private boolean isInTree;

    public Vertex(char label) {
        this.label = label;
        this.isInTree = false;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isInTree() {
        return isInTree;
    }

    public void setInTree(boolean inTree) {
        isInTree = inTree;
    }
}