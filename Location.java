
package AirFreightApp;

import GraphFrameWork.Vertex;
import java.util.logging.Logger;

/*Location class is a subclass or a child class for the Vertex class
and it inherents all of its methods and attributes
and overrides some of its methods
*/
public class Location extends Vertex {
    
    //Attributes: 
    String City;
    String Labell;
    //constructer:
    public Location(String Label, int i) {
        super(Label);
        this.City = "City" + i;
        this.Labell = Label;
    }
    //getters and setters: 
    public String getCity() {
        return City;
    }
    public void setCity(int i) {
        this.City = "City " + i;
    }
    //Methods:
    //A method to display information about the location object: 
    @Override
    public void displayInfo() {
        System.out.print("loc."+Labell+":"+City);
    }    
}//End of class 
