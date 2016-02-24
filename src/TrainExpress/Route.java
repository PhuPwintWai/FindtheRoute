package TrainExpress;

//route class include Station name and minutes
public class Route {

    public  Station destination;
    public  double minutes;
    
	public Route(Station destination, double minutes) {
		this.destination = destination;
		this.minutes = minutes;
	}

	public Station getDestination() {
		return destination;
	}

	public void setDestination(Station destination) {
		this.destination = destination;
	}

	public double getMinutes() {
		return minutes;
	}

	public void setMinutes(double minutes) {
		this.minutes = minutes;
	}

	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Route [minutes=" + minutes + "]";
	}
	
  
}


