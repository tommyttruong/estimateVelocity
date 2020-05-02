package estimateVelocity;

import java.util.Scanner;

public class skidMarksVel extends velocityCase{
	double f; // drag factor
	double g; // gravity
	double vf; // final velocity
	double vi = 0; // initial velocity
	double d = 0;

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
			System.out.println("Was there vehicle rotation?\n1. Yes\n2. No");
			input = kb.next();
			if(input.equals("1")) {
				check = true;
				boolean check2 = false;
				while(check2 == false) {
					System.out.println("Did all three tires leave Skid-marks?\n1. Yes\n2. No");
					input = kb.next();
					if(input.equals("1")) {
						check2 = true;
						System.out.print("Enter the average skid distance in meters: ");
						this.d = kb.nextDouble();
						System.out.println("Enter the final velocity of car in meters per second: ");
						this.vf = kb.nextDouble();
						vi = Math.sqrt(((2*f*g*d) + (Math.pow(vf, 2))));
					}
					else if(input.equals("2")){
						check2 = true;
						System.out.print("Enter the distance between impact and rest in meters: ");
						this.d = kb.nextDouble();
						System.out.println("Enter the final velocity of car in meters per second: ");
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
					System.out.println("Are there over-lapping skid-marks?\n1. Yes\n2. No");
					input = kb.next();
					if(input.equals("1")) {
						check3 = true;
						boolean check4 = false;
						while(check4 == false) {
							System.out.println("Is there pre-impact phase?\n1. Yes\n2. No");
							input = kb.next();
							if(input.equals("1")) {
								check4 = true;
								System.out.print("Enter the longest skid distance in meters: \n");
								double longSkid = kb.nextDouble();
								System.out.print("Enter the W-base: \n");
								double wbase = kb.nextDouble();
								this.d = longSkid - wbase;
								System.out.println("Enter the final velocity of car in meters per second: ");
								this.vf = kb.nextDouble();
								vi = Math.sqrt(((2*f*g*d) + (Math.pow(vf, 2))));
							}
							else if (input.equals("2")) {
								check4 = true;
								System.out.println("Enter the longest skid distance in meters: ");
								this.d = kb.nextDouble();
								System.out.println("Enter the final velocity of car in meters per second: ");
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
							System.out.println("Was there Uniform brake application?\n1. Yes\n2. No");
							input = kb.next();
							if(input.equals("1")) {
								check5 = true;
								System.out.println("Enter the longest skid distance in meters:");
								this.d = kb.nextDouble();
								System.out.println("Enter the final velocity of car in meters per second: ");
								this.vf = kb.nextDouble();
								vi = Math.sqrt(((2*f*g*d) + (Math.pow(vf, 2))));	
							}
							else if (input.equals("2")) {
								check5 = true;
								System.out.println("Enter the average skid distance in meters:");
								this.d = kb.nextDouble();
								System.out.println("Enter the final velocity of car in meters per second: ");
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
		System.out.printf("The time taken is %.2f seconds\n", time);
		System.out.printf("The intital velocity is %.2f meters per second\n", vi);
		double acceleration = (-1)*((vi-vf)/time);
		System.out.printf("Decceleration of the car is %.2f meters per second^2 \n ", acceleration);
		double InstantaneousVelocity = 0;
		double velocity = 0;
		double count;
		for(count = 0; count <= time; count += .05) {
			InstantaneousVelocity = acceleration*count;
			velocity = InstantaneousVelocity + vi;
			System.out.printf("At time = %.2f, the velocity of the car was %.2f meters per second \n", count, velocity);
		}
		
		
	}
	// return the initial velocity of the car
	public double getSkidMarksVel() {
		return vi;
	}
	
	
	
	public String toString() {
		return "Initial Velocity Based on Skid Marks: " + vi + " Drag Factor: f";
	}
	
}
