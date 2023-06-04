package GraphFrameWork;

import AirFreightApp.Location;
import AirFreightApp.Route;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*SingleSourceSPAlg class is a subclass or a child class for the ShortestPathAlgorithm class
and it inherents all of its methods and attributes
and overrides some of its methods
*/
public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    //Methods: 
    /*
    ComputeDijkstraAlg method is a method that executes the Dijkstra algorithm 
    to compute the shortest paths for a single specified source
    */
    public static void ComputeDijkstraAlg(Vertex source, Graph g) {
       
        //declare all needed arrays and arraylists 
        Route route[] = new Route[g.vertices.size()];
        int distince[] = new int[g.vertices.size()];
        Vertex Parent[] = new Vertex[g.vertices.size()];
        ArrayList<Location> location = new ArrayList<>();        
        
        
        //Printing the source 
        System.out.println("\nThe starting point location is " + source.getLable());
        System.out.println("The routes from location " + source.getLable() + " to the rest of the locations are:");
        //setting all the vertices as unvisited at the start 
        for (int i = 0; i < g.vertices.size(); i++) {
            g.vertices.get(i).setIsVisited(false);
        }//end of for 
        //setting the needed array and lists to store information aboute the distances and other information 
        for (int i = 0; i < route.length; i++) {
            Route r = null;
        }//end of for 
        for (int i = 0; i < g.vertices.size(); i++) {
            distince[i] = Integer.MAX_VALUE;
            Parent[i] = null;
        }//end of for 
        //first setting the source vertex distance as 0 
        distince[source.index] = 0;
        location.add((Location) source);      
        //Declaring the needed objects 
        Vertex vertex;
        Vertex CurrentVertex = null;
        int newDistince;
        /*
        This for loop will look for the minimum distance and then choose it to find 
        its adjecents and see if there si a need to change the distances of these 
        adjacent vertices and then update all what needs to be updated such as the distance array 
        and then go back again and choose the minimum distance 
        it will be repeated until all vertices are visited and all paths 
        starting from the given source are found 
        */
        for (int i = 0; i < g.vertices.size() - 1; i++) {
            // u is the source
            //find the minimum distance vertex 
            int Source_u = FindMin(distince, g);
            vertex = g.vertices.get(Source_u);
            //mark it as vivisted 
            vertex.setIsVisited(true);
            //go throug all adjacent vertices of the source_u vertex 
            for (int j = 0; j < vertex.getAdjList().size(); j++) {
                //go through the adjacent vertex for the source_u vertex one by one 
                CurrentVertex = vertex.getAdjList().get(j).getDestVer();
                //calculate the cuurent adjacent vertex new distance 
                newDistince = distince[Source_u] + vertex.getAdjList().get(j).weight;
                //check if the new distance is less than the current distance of the current vertex 
                if (CurrentVertex.isIsVisited() == false && distince[Source_u] != Integer.MAX_VALUE
                        && newDistince < distince[CurrentVertex.index]) {
                    //update the distance to the new calculated distance 
                    distince[CurrentVertex.index] = newDistince;
                    //change the parent of the adjacent vertex 
                    vertex.getAdjList().get(j).setParentVer(vertex);
                    Parent[CurrentVertex.index] = vertex;
                    if (!location.contains(CurrentVertex)) {
                        location.add((Location) CurrentVertex);
                    }//end of the 1st inner if 
                    //check if ther is already an existing edge or path or route between the two vertices 
                    Route r = findRoute(route, source, CurrentVertex);
                    //if there is no path returned from the method 
                    if (r == null) {
                        //create a new route path 
                        r = new Route(source, CurrentVertex, distince[CurrentVertex.index]);
                    }//end of the 2nd inner if 
                    //set the distance of the route with the new distance 
                    r.setLenght(newDistince);
                    route[CurrentVertex.index] = r;
                }//end of outer if 
            }//end of inner for loop 
        }//end of outer for loop 
        
        //Print of requirement 1:
        //declaring the counter variable 
        int counter = 1;
        for (int i = 0; i < location.size(); i++) {
            int j = 0;
            for (j=0 ; j < counter; j++) {
                if (counter != 1) {
                    location.get(j).displayInfo();
                    System.out.print(" - ");
                }//end of if 
            }//end of inner for loop 
            if (counter != 1) {
                Route r = findRoute(route, location.get(0), location.get(j - 1));
                r.displayInfo();
            }//end of if 
            System.out.println("");
            counter++;
        }//end of outer for loop 
        
        //Print of requirement 2: 
        //call the print method to print the final result of the paths 
        printshortestpath(source, distince, Parent, g);
  
    }//end of ComputeDijkstraAlg method 
    /*
    FindMin method is a method that finds and returns the minimum distance between all vertices 
    */
    public static int FindMin(int[] distince, Graph g) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < distince.length; i++) {
            if (distince[i] <= min && g.vertices.get(i).isIsVisited() == false) {
                min = distince[i];
                index = i;
            }//end of if 
        }//end of for loop 
        return index;
    }//end of FindMin method 
    /*
    printshortestpath method is a method that prints the shortest paths
    from the single source and prints all information such as the length of that path
    and all of the vertices and edges visited to complete that path 
    */
    public static void printshortestpath(Vertex source, int[] distence, Vertex[] parent, Graph g) {
        
        System.out.println("The starting point location is " + source.getLable());
        System.out.println("The routes from location " + source.getLable() + " to the rest of the locations are:");
        
        for (int i = 0; i < distence.length; i++) {
            System.out.println("loc. " + source.getLable() + " : " + g.vertices.get(i).getLable() + " route length: " + distence[i]);
        }//end of for loop 
        System.out.println("----------------------------------------------------------- \n");
    }//end of printshortestpath method 
    /*
    findRoute method is a method that looks for the needed route object between 
    two specified vertices and returns that route object 
    */
    public static Route findRoute(Route[] route, Vertex v1, Vertex v2) {
        
        Route r = null;
        //look for the route in the route array 
        for (int i = 0; i < route.length; i++) {
            if (route[i] != null) {
                if (route[i].destVer.getLable().equals(v2.getLable()) && route[i].getSourceVer().getLable().equals(v1.Lable)) {
                    r = route[i];
                    return r;
                }//end of inner if 
            }//end of outer if 
        }//end of for loop 
        return r;
    }//end of findRoute method 
    
}//End of class 
