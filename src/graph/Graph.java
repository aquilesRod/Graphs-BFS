package graph;
import java.util.Scanner;

public class Graph {

    private Scanner file;
    private int [][] adjacencyMatrix;
    private int edgesQuantity;
    private int verticesQuantity;

    public Graph(Scanner file) {
        this.file = file;
        this.startGraph();
    }

    private void startGraph(){
        this.verticesQuantity = Integer.parseInt(this.file.nextLine());
        this.edgesQuantity = Integer.parseInt(this.file.nextLine());
        this.adjacencyMatrix = new int [this.verticesQuantity][this.edgesQuantity];

        this.adjacencyMatrix = setAdjacencyMatrixValues(this.adjacencyMatrix, this.file);
    }

    private int [][] setAdjacencyMatrixValues(int [][] adjacencyMatrix, Scanner file) {
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String [] array = line.split(" ");
            int originVertice = Integer.parseInt(array[0]);
            int destineVertice = Integer.parseInt(array[1]);
            adjacencyMatrix[originVertice][destineVertice] = 1;
        }
        return adjacencyMatrix;
    }

    public int[][] getAdjacencyMatrix() {
        return this.adjacencyMatrix;
    }

    public int getEdgesQuantity() {
        return this.edgesQuantity;
    }

    public int getVerticesQuantity() {
        return this.verticesQuantity;
    }

}
