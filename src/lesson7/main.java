package lesson7;

//Урок 7. Графы
//        1. Реализовать программу, в которой задается граф из 10 вершин.
//        Задать ребра и найти кратчайший путь с помощью поиска в ширину.

public class main {
    public static void main(String[] args) {



    }
}

class Graf{
    private final int MAX_VERTS = 10; // коичество вершин графа
    private final int INFINITY = 1_000_000_000; // бесконечность
    private Vertex vertexList[]; // массив вершин
    private int matrixGraf[][]; // матрица связей графа

    public Graf(){
        vertexList = new Vertex[MAX_VERTS];         // создаем массив для хранения вершин
        matrixGraf = new int[MAX_VERTS][MAX_VERTS];// создаем матрицу смежности
        for (int i = 0; i < MAX_VERTS; i++) {   // и заполняем ее значениями бесконечность
            for (int j = 0; j < MAX_VERTS; j++) {
                matrixGraf[i][j] = INFINITY;
            }
        }


    }
}

class Vertex{
    private char label;
    private boolean isInTree;

    public Vertex(char label, boolean isInTree) {
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