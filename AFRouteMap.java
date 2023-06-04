
package AirFreightApp;

import GraphFrameWork.Graph;

/*AFRouteMap class is a subclass or a child class for the Graph class
and it inherents all of its methods and attributes
and overrides some of its methods
*/
public class AFRouteMap extends  Graph {
    //constructers:
    public AFRouteMap(int veticesNo, int edgeNo, boolean isDigraph) {
        super(veticesNo, edgeNo, isDigraph);
    }
    public AFRouteMap() {
    }    
}//End of class 
