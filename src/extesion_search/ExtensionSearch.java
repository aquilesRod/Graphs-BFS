package extesion_search;
import Queue.Queue;

public class ExtensionSearch {

    private int [][] adjacencyMatrix;
    private int fontVertice;
    private EnumColor [] color;
    private long [] distance;
    private Integer [] antecedent;
    private Queue queue;

    public ExtensionSearch(int[][] adjacencyMatrix, Integer vertice) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.fontVertice = vertice;
        startExtesionSearchProperties();
    }

    private void startExtesionSearchProperties() {
        this.queue = new Queue(adjacencyMatrix.length);
        this.color = new EnumColor [adjacencyMatrix.length];
        this.distance = new long [adjacencyMatrix[0].length];
        this.antecedent = new Integer[adjacencyMatrix.length];

        for (int i = 0; i < distance.length; i++) {
            color[i] = EnumColor.WHITE;
            distance[i] = 922337203685477580L;
            this.antecedent[i] = null;
        }
    }

    public void showResults(Integer v) throws Exception {
        search(adjacencyMatrix);

        if(v == this.fontVertice){
            System.out.print(this.fontVertice);
        } else {
            if(this.antecedent[v] == null) {
                System.out.println("There's no way!");
            } else {
                this.showResults(antecedent[v]);
                System.out.print(" -> "+v);
            }
        }
    }
    
    private void search(int[][] adjacencyMatrix) throws Exception {
        this.color[this.fontVertice] = EnumColor.GRAY;
        this.distance[this.fontVertice] = 0;
        this.queue.enqueue(this.fontVertice);

        while(!this.queue.isEmpty()) {
            Integer adjacencyVertice = this.queue.dequeue();
            for (int v = 0; v < adjacencyMatrix.length; v++) {
                if(adjacencyMatrix[v][adjacencyVertice] == 1 || adjacencyMatrix[adjacencyVertice][v] == 1) {
                    if(this.color[v] == EnumColor.WHITE){
                        this.color[v] = EnumColor.GRAY;
                        this.distance[v] = distance[adjacencyVertice] + 1;
                        this.antecedent[v] = adjacencyVertice;
                        this.queue.enqueue(v);
                    }
                }
            }
            this.color[adjacencyVertice] = EnumColor.BLACK;
        }
    }
    
}
