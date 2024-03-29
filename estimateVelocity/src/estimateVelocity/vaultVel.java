package estimateVelocity;

import java.util.*;
public class vaultVel extends velocityCase {
	double g;// gravity
	double D;// horizontal distance
	double H;// vertical distance
	double e;// super elevation
	double vv;// vault velocity
	
	public vaultVel() {
		
	}
	
	public vaultVel(double g, double D, double H, double e) {
		this.g = g;
		this.D = D;
		this.H = H;
		this.e = e;
		this.vv = Math.sqrt((g*Math.pow(D, 2))/(2*(H + (D*e))));
	}
	
	//get information to calculate the velocity before takeoff
	public void getInformation() {
		Scanner kb = new Scanner(System.in);
		System.out.println();
		System.out.println("\nEnter information to determine the take off velocity of the car: ");
		System.out.println("\nEnter the horizontal distance of the impact in meters.");
		this.D = kb.nextDouble();
		System.out.println("\nEnter the vertical distance of the car before takeoff in meters: ");
		this.H = kb.nextDouble();
		System.out.println("\nPlase enter the percentage of super-elevation: ");
		this.e = (kb.nextDouble())/100;
		System.out.println("\nEnter the altitude of the car in meters above the surface of the Earth to estimate the gravitational pull: ");
		double altitude = kb.nextDouble();
		this.g = (6.67 * Math.pow(10, -11) * 5.972 * Math.pow(10, 24))/(Math.pow(((6.371 * Math.pow(10, 6)) + altitude), 2));
		System.out.println();
		System.out.printf("\nthe gravity of %.2f will be used\n",g );
		
	}
	public void getSimulation() {
		double vertVel = 0, horizVel = vv;
		System.out.printf("\nThe vault velovity is %.2f meters per second\n ", vv);
		double d = Math.sqrt(Math.pow(D, 2) + Math.pow(H, 2));
		System.out.printf("The distance it travles is %.2f meters\n", d);
		double scale = Math.pow(10, 2);
		double time = (Math.round((d/(vv))*scale) / scale);
		double InstVel = 0;
		double velocity;
		System.out.printf("The time taken is %.2f seconds\n\n", time);
		for(double count = 0; count < time ; count += .05) {
			vertVel = g * count;
			InstVel = Math.sqrt(Math.pow(vertVel, 2) + Math.pow(horizVel, 2));
			velocity = vv + InstVel;
			System.out.printf("At time = %.2f, the velocity of the car was %.2f meters per second\n ", count, velocity);
		}
		System.out.printf("At time = %.2f, the velocity of the car was 0 meters per second\n", time);

		
	}
	
	public double getVaultVel() {
		this.vv = Math.sqrt((g*Math.pow(D, 2))/(2*(H + (D*e))));
		return vv;
	}
	
	public void getReport() {
		System.out.printf("\n******************************REPORT******************************\n");
		System.out.printf("* %63s*\n", " ");
		System.out.printf("* Force of gravity: %-45.2f*\n", g);
		System.out.printf("* Horizontal Distance: %-42.2f*\n", D);
		System.out.printf("* Vertical Distance: %-44.2f*\n", H);
		System.out.printf("* Equation: v = sqrt(gD^2)/(2(H+De))                             *\n");
		System.out.printf("* Vault Velocity: %-47.2f*\n", vv);
		System.out.printf("* %63s*\n", " ");
		System.out.printf("******************************************************************\n");
	}
	
	
	public String toString() {
		return String.format("Vault Velocity base on Vault Case: %.2f\n" , vv);
	}
	
}
