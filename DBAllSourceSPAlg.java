
package GraphFrameWork;

/*DBAllSourceSPAlg class is a subclass or a child class for the ShortestPathAlgorithm class
and it inherents all of its methods and attributes
and overrides some of its methods
*/
public class DBAllSourceSPAlg extends ShortestPathAlgorithm {
    
    //Methods:
    /*
    ComputrDijkstraBasedSPAlg method is a method that executes the Dijkstra algorithm 
    to compute the shortest paths from each vertex to the rest of the vertices 
    it also claculates the total running time 
    */
    public void ComputrDijkstraBasedSPAlg(Graph g){
        //Start time to calculate the total running time   
        double startTime = System.currentTimeMillis();
        //a for loop used to compute the single shortest path for each vertex of the graph 
        for (int i = 0; i < g.vertices.size(); i++) {
            //call the ComputeDijkstraAlg method from the SingleSourceSPAlg class to compute the paths 
            SingleSourceSPAlg.ComputeDijkstraAlg(g.vertices.get(i), g);
        }//end of for
        //end time to calculate the total running time  
        double ftime = System.currentTimeMillis();
        //print the total time consumed by the algorithm:
        System.out.println("Total runtime of Dijkstra Algorithm: " + (ftime - startTime) + " ms.");
    }//end of ComputrDijkstraBasedSPAlg method 
}//End of class 
