
package AirFreightApp;

import GraphFrameWork.Edge;
import GraphFrameWork.Vertex;
import java.util.ArrayList;

/*Route class is a subclass or a child class for the Edge class
and it inherents all of its methods and attributes
and overrides some of its methods
*/
public class Route extends Edge {
    
    //Attributes:
    public int lenght;
    //an arraylist to store all of the locations objects for each route object 
    ArrayList<Location> locat = new ArrayList<>();
    //constructer:
    public Route(Vertex sourceVer, Vertex destVer, int weight) {
        super(sourceVer, destVer, weight);
    }
    //getters and setters:
    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
    public int getLenght() {
        return lenght;
    }
    public void setLocat(ArrayList<Location> locat) {
        this.locat = locat;
    }
    public ArrayList<Location> getLocat() {
        return locat;
    }
    //Methods:
    //A method to display information about the Location arraylist objects:
    public void PrintLocation(){
        for(int i=0;i<locat.size();i++){
            locat.get(i).displayInfo();
        } 
    }
    //A method to display information about the route object: 
    @Override
    public void displayInfo() {
        System.out.println("- -Route Lenght: "+lenght);
    }    
}//End of class 
