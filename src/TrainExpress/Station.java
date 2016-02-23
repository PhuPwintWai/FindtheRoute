package TrainExpress;

import java.util.Arrays;

//Station class 
public class Station implements Comparable<Station>
{
    public final String name;
    public Route[] way;
    public double minDistance = Double.POSITIVE_INFINITY; //to find min value
    public Station previous;
  
  
    public Station(String name) {
		this.name = name;
	}
    
	public Station(String name, Route[] way, double minDistance,
			Station previous) {
		super();
		this.name = name;
		this.way = way;
		this.minDistance = minDistance;
		this.previous = previous;
	}

	
	public Route[] getWay() {
		return way;
	}

	public void setWay(Route[] way) {
		this.way = way;
	}

	public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	public Station getPrevious() {
		return previous;
	}

	public void setPrevious(Station previous) {
		this.previous = previous;
	}

	public String getName() {
		return name;
	}

	public int compareTo(Station other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
    @Override
  	public String toString() {
  		return "Station [name=" + name + ", way=" + Arrays.toString(way)
  				+ ", minDistance=" + minDistance + ", previous=" + previous
  				+ "]";
  	}
    

}
