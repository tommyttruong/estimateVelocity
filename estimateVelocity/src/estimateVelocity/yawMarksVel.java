package estimateVelocity;

import java.util.*;
public class yawMarksVel extends velocityCase {
	double f;// drag factor
	double R;// radius of the yaw mark
	double g;// gravity
	double e;// super elevation of the road
	double vc;// critical velocity
	double theta; // angle of the arc length
	double acceleration = 0;
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
		System.out.println("\nEnter information to determine the critical velocity of the car");
		System.out.println("\nEnter the radius of the yaw marks in meters -- for precise calculation please enter 1/3 of the yaw marks: ");
		this.R = kb.nextDouble();
		System.out.println("\nPlase enter the percentage of super-elevation: ");
		this.e = (kb.nextDouble())/100;
		System.out.println("\nEnter the angle of the arc length from the 1/3 radius of the yaw mark in degrees: ");
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
		System.out.printf("\nThe time taken is %.2f seconds\n", time);
		System.out.printf("The intital velocity of the car is %.2f meters per second\n", vc);
		acceleration = (-1)*(vc/time);
		System.out.printf("Decceleration of the car is %.2f meter per second^2\n", acceleration);
		double InstantaneousVelocity = 0;
		double velocity = 0;
		double count;
		for(count = 0; count < time ; count += .05) {
			InstantaneousVelocity = acceleration*count;
			velocity = InstantaneousVelocity + vc;
			System.out.printf("At time = %.2f, the velocity of the car was %.2f meters per second \n", count, velocity);
		}
		System.out.printf("At time = %.2f, the velocity of the car was 0 meters per second\n", time);

	}
	
	//return the critical velocity
	public double getCriticalVel() {
		return vc;
	}
	
	public void getReport() {
		System.out.printf("\n******************************REPORT******************************\n");
		System.out.printf("* %63s*\n", " ");
		System.out.printf("* Drag Factor: %-50.2f*\n", f);
		System.out.printf("* Radius of the Yaw Mark: %-39.2f*\n", R);
		System.out.printf("* Equation: vc = sqrt(Rg(f+e)/(1-fe))                            *\n");
		System.out.printf("* Critical Curve Velocity: %-38.2f*\n", vc);
		System.out.printf("* Decceleration of the car is %-35.2f*\n", acceleration);
		System.out.printf("* %63s*\n", " ");
		System.out.printf("******************************************************************\n");
	}
	
	
	public String toString() {
		return String.format("Initial Velocity Based on Yaw Marks: %.2f Drag Factor: %.2f\n", vc, f);
	}

}
