import java.util.*;

public class Graph {
    public static void addEdge(int [][] mat, int i, int j){
        mat[i][j] = 1;
        mat[j][i] = 1; // since the graph is undirected

    }
    public static void displayMatrix(int [][] mat){
        for(int [] row: mat){
            //System.out.printf("the mat value and row value" + Arrays.toString(row) + " " + mat);
            for( int val: row){
                System.out.printf(val + " ");
            }
            System.out.println();
        }
    }

    /*
    BFS: breadth first graph

    Algo logic: we are going to have 2 array list and one queue.
    visited = [], res = [], queue
    you start from one node - put it into queue.
    then mark visited = true,
    pop the queue and insert its adjacent element into queue and add the popped element into res.

    and do this process until queue is not empty

    input = List<List<integer>> adj
    {{1,2}, {0}, {2,3}} - so here 1 and 2 are its adjacent and 0 doesn't have adjacent.
    But here we are talking about connected graph
     */

    public List<Integer> breadthFirstSearch(List<List<Integer>> input){
        List<Integer> res = new ArrayList<>();


        Queue<Integer> q = new LinkedList<>();

        int totalNodes = input.size();
        boolean [] visited = new boolean[totalNodes];

        int s = 0;
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()){
            int temp = q.poll();
            res.add(temp);
            for(int i=0; i<input.get(temp).size(); i++){
                int x = input.get(temp).get(i);
                if(!visited[x]){
                    visited[x] = true;
                    q.add(x);
                }
            }

        }
        return res;
    }



    public static void main(String[] args){
        List<List<Integer>> bfslist = new ArrayList<>();
        bfslist.add(new ArrayList<>(Arrays.asList(1,2)));
        bfslist.add(new ArrayList<>(Arrays.asList(0,2,3)));
        bfslist.add(new ArrayList<>(Arrays.asList(0,4)));
        bfslist.add(new ArrayList<>(Arrays.asList(1,4)));
        bfslist.add(new ArrayList<>(Arrays.asList(2,3)));
        Graph graph = new Graph();
        List<Integer> list = graph.breadthFirstSearch(bfslist);
        System.out.println("BFS output");
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }




        int V =3;
        int [][] mat = new int [V][V];
        addEdge(mat, 0, 1);
        addEdge(mat, 0, 2);
        addEdge(mat, 1, 2);
        addEdge(mat, 1, 0);
        addEdge(mat, 2, 0);
        addEdge(mat, 2, 1);
        System.out.println("the display of graph in matrix form is ");
        displayMatrix(mat);
        int v = 3;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        addEdgeLL(adj, 0, 1);
        addEdgeLL(adj, 0, 2);
        //addEdgeLL(adj, 1, 0);
        addEdgeLL(adj, 1, 2);
       // addEdgeLL(adj, 2, 1);
       // addEdgeLL(adj, 3, 1);
        displayGraphLL(adj);
    }


    public static void addEdgeLL(List<List<Integer>> adj, int i, int j){
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    public static void displayGraphLL(List<List<Integer>> adj){
        for(int i=0; i<adj.size(); i++){
            System.out.print(i + ": ");
            for(int j: adj.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
