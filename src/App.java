import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import extesion_search.ExtensionSearch;
import graph.Graph;

public class App {

    public static void main(String[] args) throws Exception {
        Graph graph = new Graph(readFile());
        ExtensionSearch bfs;

        int [][] adjacencyMatrix = graph.getAdjacencyMatrix();
        int fontVertice, destineVertice;
        char op;

        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("Insert a font vertice: ");
            fontVertice = scanner.nextInt();
            bfs = new ExtensionSearch(adjacencyMatrix, fontVertice);
            System.out.print("Insert a destine vertice: ");
            destineVertice = scanner.nextInt();
            bfs.showResults(destineVertice);
            System.out.println();

            System.out.print("You want to finish the program? [y] [n]: ");
            op = scanner.next().charAt(0);
        } while (op != 'y' && op != 'Y');

        scanner.close();
    }

    private static Scanner readFile() throws FileNotFoundException{
        String file = "src\\utils\\pequenoG.txt";
        FileReader reader = new FileReader(file);
        return new Scanner(reader).useDelimiter("\\n");
    }

}
