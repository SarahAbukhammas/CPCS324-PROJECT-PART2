
package AirFreightApp;

import GraphFrameWork.DBAllSourceSPAlg;
import GraphFrameWork.Graph;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AirFreightApp {

 
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        //Ask user which requirements they would like to execute 
        System.out.print("Enter your requirement's choice: 1,2: ");
        int choice = input.nextInt();
        //If the user wishes to execute requirement 1: 
        if (choice == 1) {
        // Requirement (1):
        // Create a graph object
            Graph graph1 = new AFRouteMap();
            //Read the graph information from the graph file 
            graph1.readGraphFromFile("Graph.txt");
            //Create an object for the Dijkstra algorithm 
            DBAllSourceSPAlg D = new DBAllSourceSPAlg();
            D.ComputrDijkstraBasedSPAlg(graph1);

        }//End of if clause
        //////////////////////////////////////////////////////////////////////////////////
        //If the user wishes to execute requirement 2: 
        if(choice==2){
        //Requirement(2):
        //Print the choices to user so they can choose: 
        System.out.println("Enter your choice:");
        System.out.println("1: n= 2000 , m= 10000");
        System.out.println("2: n= 3000 , m= 15000");
        System.out.println("3: n= 4000 , m= 20000");
        System.out.println("4: n= 5000 , m= 25000");
        System.out.println("5: n= 6000 , m= 30000");
        //Get the choice from user for the number of vertices and edges of the graph
        choice=input.nextInt();
        //Ask user if they wish the graph to be directed or undirected:
        System.out.println("Is the graph directed?\n" +" enter 1(true) or 2(false)");
        //Get user choice:
        int isdigraph = input.nextInt();
            boolean digraph;
            //If 1 then graph is directed:
            if (isdigraph == 1) {
                digraph = true;
            }//End of if 
            //If 2 then graph is undirected:
            else {
                digraph = false;
            }//End of else
            //Declare variables:
            AFRouteMap graph2;
            DBAllSourceSPAlg D;

            //enter a switch to cover all of the choices available for the user to choose from: 
            switch (choice) {
                //If user chose option 1 for the graph: 
                case 1:
                    //Make the graph of the user choice:
                    graph2 = new AFRouteMap(2000,10000, digraph);
                    graph2.make_graph(graph2);
                    D = new DBAllSourceSPAlg();
                    D.ComputrDijkstraBasedSPAlg(graph2);
                    break;
                //If user chose option 2 for the graph:
                case 2:
                    //Make the graph of the user choice:
                    graph2 = new AFRouteMap(3000, 15000, digraph);
                    graph2.make_graph(graph2);
                    D = new DBAllSourceSPAlg();
                    D.ComputrDijkstraBasedSPAlg(graph2);
                    break;
                //If user chose option 3 for the graph:
                case 3:
                    //Make the graph of the user choice:
                    graph2 = new AFRouteMap(4000, 20000, digraph);
                    graph2.make_graph(graph2);
                    D = new DBAllSourceSPAlg();
                    D.ComputrDijkstraBasedSPAlg(graph2);
                    break;
                //If user chose option 4 for the graph:
                case 4:
                    //Make the graph of the user choice:
                    graph2 = new AFRouteMap(5000, 25000, digraph);
                    graph2.make_graph(graph2);
                    D = new DBAllSourceSPAlg();
                    D.ComputrDijkstraBasedSPAlg(graph2);
                    break;
                //If user chose option 5 for the graph:
                case 5:
                    //Make the graph of the user choice:
                    graph2 = new AFRouteMap(6000, 30000, digraph);
                    graph2.make_graph(graph2);
                    D = new DBAllSourceSPAlg();
                    D.ComputrDijkstraBasedSPAlg(graph2);
                    break;
                //If user chose enters any other number than 1 to 5:
                default:
                    System.out.println("Error !! ");
                    break;
            }//End of switch
        }//End of if clause
    } // End of Main Method
}// End of Class
    
    