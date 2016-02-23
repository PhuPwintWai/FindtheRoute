package TrainExpress;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Calculate
{
    public static void main(String[] args)
    {
    //Create the Station
	Station A = new Station("A");
	Station B = new Station("B");
	Station C = new Station("C");
	Station D = new Station("D");
	Station E = new Station("E");

	//declare the minutes of each station
	A.way = new Route[]{ new Route(B, 3), new Route(D,6)};	
	B.way = new Route[]{ new Route(A, 3), new Route(C,7)};	
	C.way = new Route[]{ new Route(D, 8), new Route(E,3)};	
	D.way = new Route[]{new Route(E, 9), new Route(C,9),new Route(B,5)};	
	E.way = new Route[]{ new Route(D, 9)};
	
	//Printout all stations
	Station[] stations = { A, B, C, D, E};
	System.out.println("*******Welcome*******");
	System.out.print("Choose among these station : ");
	for (Station st : stations){
    	System.out.print(st.getName()+"  ");
    }
	System.out.println();
	int count =0; String start;
	 Scanner in = new Scanner(System.in);
	 
	 //Get the Start station of route, Station name must be in the array
        do{
          System.out.println("Please type start station");
  	       start = in.nextLine();
  	      start=start.toUpperCase();
          for (Station st : stations){
          	if (start.endsWith(st.getName())){
          		count=1;
          		calculateShortestPath(st);
          	}
          }
          if (count !=1){
        	  System.out.println("The station is not available");
          }
        }while(count!=1);
       
      //Get the End station of route, Station name must be in the array
        do{
        	System.out.println("Please type end station");
  	      String end = in.nextLine();
  	      end=end.toUpperCase();
  	      
          for (Station st : stations){
          	if (end.endsWith(st.getName())){  	
          		count=2;
          		    List<String> path = getPathList(st);
          		    System.out.println("The quickest route from Station "+start+" to "+end+" : " + path);
          		    System.out.println("Duration is " + (int)st.getMinDistance()+" minutes.");
          	}
          	
          }
          if(count!=2){
        		System.out.println("The station is not available");
        	}
        }while(count!=2);
        
    }
    
    //
    public static void calculateShortestPath(Station s)
    {
        s.setMinDistance(0.); 
        //Using Priority Queue
        PriorityQueue<Station> queueStation = new PriorityQueue<Station>();
        queueStation.add(s);

	while (!queueStation.isEmpty()) {
	    Station st = queueStation.poll();
            for (Route e : st.getWay())
            {
                Station station = e.getDestination();
                double minute = e.getMinutes();
                double distance = st.minDistance + minute;
		if (distance < station.minDistance) {
		    queueStation.remove(station);

		    station.minDistance = distance ;
		    station.previous = st;
		    queueStation.add(station);
		}
            }
            System.out.println("queueStation---> "+queueStation.toString());
        }
	
    }
    
    //get the shortest path station name list
    public static List<String> getPathList(Station stationss)
    {
        List<String> path = new ArrayList<String>();
        for (Station s = stationss; s != null; s = s.previous)
            path.add(s.getName());
        Collections.reverse(path);
        return path;
    }
}
