package estimateVelocity;

import java.util.*;
public class vaultVel {
	double g;// gravity
	double D;// horizontal distance
	double H;// vertical distance
	double e;// super elevation
	double vv;// vault velocity
	
	public vaultVel() {
		
	}
	
	public vaultVel(double g) {
		this.g = g;
	}
	
	//get information to calculate the velocity before takeoff
	public void getInformation() {
		Scanner kb = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter information to determine the take off velocity of the car");
		System.out.println("Enter the horizontal distance:");
		this.D = kb.nextDouble();
		System.out.println("Enter the vertical distance of the car before takeoff: ");
		this.H = kb.nextDouble();
		System.out.println("Plase enter the percentage of super-elevation");
		this.e = (kb.nextDouble())/100;

		
	}
	public void getSimulation() {
		double vertVel = 0, horizVel = vv;
		System.out.println("The vault velovity is: " + vv);
		double d = Math.sqrt(Math.pow(D, 2) + Math.pow(H, 2));
		System.out.println("The distance it travles is " + d);
		double scale = Math.pow(10, 2);
		double time = (Math.round((d/(vv))*scale) / scale);
		double InstVel = 0;
		double velocity;
		System.out.println("The time is: " + time);
		for(double count = 0; count < time - .01; count += .01) {
			vertVel = g * count;
			InstVel = Math.sqrt(Math.pow(vertVel, 2) + Math.pow(horizVel, 2));
			velocity = vv + InstVel;
			System.out.printf("At time = %.2f, the velocity of the car was %.2f meters per second\n ", count, velocity);
		}
		System.out.printf("At time = %.2f, the velocity of the car was 0 meters per second\n ", time);

		
	}
	
	public double getVaultVel() {
		this.vv = Math.sqrt((g*Math.pow(D, 2))/(2*(H + (D*e))));
		return vv;
	}
	
}
