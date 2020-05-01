package estimateVelocity;

import java.util.*;
public class yawMarksVel {
	double f;// drag factor
	double R;// radius of the yaw mark
	double g;// gravity
	double e;// super elevation of the road
	double vc;// critical velocity
	double theta; // angle of the arc length
	public yawMarksVel() {
		
	}
	
	public yawMarksVel(double f, double g) {
		this.f = f;
		this.g = g;
	}
	
	//get information to calculate the velocity
	public void getInformation() {
		Scanner kb = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter information to determine the critical velocity of the car");
		System.out.println("Enter the radius of the yaw marks -- for precise calculation please enter 1/3 of the yaw marks: ");
		this.R = kb.nextDouble();
		System.out.println("Plase enter the percentage of super-elevation");
		this.e = (kb.nextDouble())/100;
		System.out.println("Enter the angle of the arc length from the 1/3 radius of the yaw mark:");
		this.theta = kb.nextDouble();

	}
	
	//calculate the critical velocity
	public void calCriticalVel() {
		this.vc = Math.sqrt(((R*g)*(f+e))/(1-(f*e)));
	}
	
	public void getSimulation() {
		double d = R*theta;
		double scale = Math.pow(10, 2);
		double time = (Math.round((d/(vc))*scale) / scale);
		System.out.println("Time is: " + time);
		System.out.println("The intital velocity is: " + vc);
		double acceleration = (-1)*(vc/time);
		System.out.println("Decceleration of the car is: " + acceleration);
		double InstantaneousVelocity = 0;
		double velocity = 0;
		double count;
		for(count = 0; count <= time; count += .01) {
			InstantaneousVelocity = acceleration*count;
			velocity = InstantaneousVelocity + vc;
			System.out.printf("At time = %.2f, the velocity of the car was %.2f meters per second \n", count, velocity);
		}
	}
	
	//return the critical velocity
	public double getCriticalVel() {
		return vc;
	}

}
