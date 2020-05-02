package estimateVelocity;

import java.util.Scanner;

public class skidMarksVel extends velocityCase{
	double f; // drag factor
	double g; // gravity
	double vf; // final velocity
	double vi = 0; // initial velocity
	double d = 0;
	double acceleration = 0;

	public skidMarksVel() {
		
	}

	public skidMarksVel(double f, double g) {
		this.f = f;
		this.g = g;
	}
	
	// gather information and calculate the initial velocity
	public void calSkidMarksVel() {
		boolean check = false;
		String input;
		Scanner kb = new Scanner(System.in);
		
		//Using the flow graph of skid marks to get appropriate value to get the initial velocity
		System.out.println();
		System.out.println("Enter information to determine the initial velocity of the car");
		while(check == false) {
			System.out.println("\nWas there vehicle rotation?\n1. Yes\n2. No");
			input = kb.next();
			if(input.equals("1")) {
				check = true;
				boolean check2 = false;
				while(check2 == false) {
					System.out.println();
					System.out.println("\nDid all three tires leave Skid-marks?\n1. Yes\n2. No");
					input = kb.next();
					if(input.equals("1")) {
						check2 = true;
						System.out.print("\nEnter the average skid distance in meters: ");
						this.d = kb.nextDouble();
						System.out.println("\nEnter the final velocity of car in meters per second: ");
						this.vf = kb.nextDouble();
						vi = Math.sqrt(((2*f*g*d) + (Math.pow(vf, 2))));
					}
					else if(input.equals("2")){
						check2 = true;
						System.out.print("\nEnter the distance between impact and rest in meters: ");
						this.d = kb.nextDouble();
						System.out.println("\nEnter the final velocity of car in meters per second: ");
						this.vf = kb.nextDouble();
						vi = Math.sqrt(((2*f*g*d) + (Math.pow(vf, 2))));	
					}
					else {
						check2 = false;
						System.out.println("Invalid Entry");	
					}
				}
			}
			else if(input.equals("2")) {
				check = true;
				boolean check3 = false;
				while(check3 == false) {
					System.out.println("\nAre there over-lapping skid-marks?\n1. Yes\n2. No");
					input = kb.next();
					if(input.equals("1")) {
						check3 = true;
						boolean check4 = false;
						while(check4 == false) {
							System.out.println("\nIs there pre-impact phase?\n1. Yes\n2. No");
							input = kb.next();
							if(input.equals("1")) {
								check4 = true;
								System.out.print("\nEnter the longest skid distance in meters: \n");
								double longSkid = kb.nextDouble();
								System.out.print("\nEnter the W-base: \n");
								double wbase = kb.nextDouble();
								this.d = longSkid - wbase;
								System.out.println("\nEnter the final velocity of car in meters per second: ");
								this.vf = kb.nextDouble();
								vi = Math.sqrt(((2*f*g*d) + (Math.pow(vf, 2))));
							}
							else if (input.equals("2")) {
								check4 = true;
								System.out.println("\nEnter the longest skid distance in meters: ");
								this.d = kb.nextDouble();
								System.out.println("\nEnter the final velocity of car in meters per second: ");
								this.vf = kb.nextDouble();
								vi = Math.sqrt(((2*f*g*d) + (Math.pow(vf, 2))));
							}
							else {
								check4 = false;
								System.out.println("Invalid Entry");
							}
						}	
					}
					else if (input.equals("2")) {
						check3 = true;
						boolean check5 = false;
						while(check5 == false) {
							System.out.println("\nWas there Uniform brake application?\n1. Yes\n2. No");
							input = kb.next();
							if(input.equals("1")) {
								check5 = true;
								System.out.println("\nEnter the longest skid distance in meters:");
								this.d = kb.nextDouble();
								System.out.println("\nEnter the final velocity of car in meters per second: ");
								this.vf = kb.nextDouble();
								vi = Math.sqrt(((2*f*g*d) + (Math.pow(vf, 2))));	
							}
							else if (input.equals("2")) {
								check5 = true;
								System.out.println("\nEnter the average skid distance in meters:");
								this.d = kb.nextDouble();
								System.out.println("\nEnter the final velocity of car in meters per second: ");
								this.vf = kb.nextDouble();
								vi = Math.sqrt(((2*f*g*d) + (Math.pow(vf, 2))));
							}
							else {
								System.out.println("Invalid Entry");
								check5 = false;
							}
						}
					}
					else {
						System.out.println("Invalid Entry");
						check3 = false;
					}
				}
			}
			else {
				check = false;
				System.out.println("Invalid Entry");	
			}
			
		}
		
		
	}
	
	public void getSimulation() {
		double scale = Math.pow(10, 2);
		double time = (Math.round((d/(vi-vf))*scale) / scale);
		System.out.printf("\nThe time taken is %.2f seconds\n", time);
		System.out.printf("The intital velocity is %.2f meters per second\n\n", vi);
		acceleration = (-1)*((vi-vf)/time);
		double InstantaneousVelocity = 0;
		double velocity = 0;
		double count;
		for(count = 0; count < time; count += .05) {
			InstantaneousVelocity = acceleration*count;
			velocity = InstantaneousVelocity + vi;
			System.out.printf("At time = %.2f, the velocity of the car was %.2f meters per second \n", count, velocity);
		}
		System.out.printf("At time = %.2f, the velocity of the car was %.2f meters per second\n", time, vf);	
	}
	
	public void getReport() {
		System.out.printf("\n******************************REPORT******************************\n");
		System.out.printf("* %63s*\n", " ");
		System.out.printf("* Drag Factor: %-50.2f*\n", f);
		System.out.printf("* Final Velocity: %-47.2f*\n", vf);
		System.out.printf("* Equation: vi = sqrt(2fgd + vf^2)                               *\n");
		System.out.printf("* Initial Velocity: %-45.2f*\n", vi);
		System.out.printf("* Decceleration of the car is %-35.2f*\n", acceleration);
		System.out.printf("* %63s*\n", " ");
		System.out.printf("******************************************************************\n");
	}
	
	// return the initial velocity of the car
	public double getSkidMarksVel() {
		return vi;
	}
	
	
	
	public String toString() {
		return String.format("Initial Velocity Based on Skid Marks: %.2f Drag Factor: %.2f\n", vi, f);
	}
	
}
