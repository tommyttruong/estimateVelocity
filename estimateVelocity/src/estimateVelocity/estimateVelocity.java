package estimateVelocity;

import java.util.*;
import java.util.Map.Entry;

public class estimateVelocity {
	
	static Scanner kb = new Scanner(System.in);
	
	static dragFactor x = new dragFactor();
	
	public static double getDragFactor() { // Getting Drag Factor --------------------------------------------------------------
		Map<String, Double> values = x.createMap();
		
		
		String factor = "";
	
		System.out.println("Is the road surface wet or dry?");
		System.out.println("Please enter 1 for wet, or 2 for dry");
		
		int wetness = kb.nextInt();
		while(!((wetness == 1) || (wetness == 2))) {
			System.out.println("That is not an option");
			System.out.println("Please enter 1 for wet, or 2 for dry");
			wetness = kb.nextInt();
		}
		if(wetness == 1)
			factor = factor + "w";
		else
			if(wetness == 2)
				factor = factor + "d";
		
		System.out.println("Please choose the type of road surface");
		System.out.println("1: Portland Cement");
		System.out.println("2: Asphalt or Tar");
		System.out.println("3: Gravel");
		System.out.println("4: Cinders");
		System.out.println("5: Rock");
		System.out.println("6: Ice");
		System.out.println("7: Snow");
		int roadSurface = kb.nextInt();
		while((roadSurface < 1) || (roadSurface > 7)) {
			System.out.println("That is not an option");
			System.out.println("Please choose the type of road surface");
			System.out.println("1: Portland Cement");
			System.out.println("2: Asphalt or Tar");
			System.out.println("3: Gravel");
			System.out.println("4: Cinders");
			System.out.println("5: Rock");
			System.out.println("6: Ice");
			System.out.println("7: Snow");
			roadSurface = kb.nextInt();
		}
		switch (roadSurface) {
		case 1:
			System.out.println("Please select the cement type");
			System.out.println("1: New, Sharp");
			System.out.println("2: Travelled");
			System.out.println("3: Polished");
			int cementType = kb.nextInt();
			while(cementType<1 || cementType>3) {
				System.out.println("That is not an option");
				System.out.println("Please select the cement type");
				System.out.println("1: New, Sharp");
				System.out.println("2: Travelled");
				System.out.println("3: Polished");
				cementType = kb.nextInt();
			}
			if(cementType == 1) 
				factor = factor + "cn";
			else
				if(cementType == 2)
					factor = factor + "ct";
				else
					if(cementType == 3)
						factor = factor + "cp";
			break;
		case 2:
			System.out.println("Please select the type of asphalt");
			System.out.println("1: New, Sharp");
			System.out.println("2: Travelled");
			System.out.println("3: Polished");
			System.out.println("4: Excess Tar");
			int asphaltType = kb.nextInt();
			while(asphaltType<1 || asphaltType>4) {
				System.out.println("That is not an option");
				System.out.println("Please select the type of asphalt");
				System.out.println("1: New, Sharp");
				System.out.println("2: Travelled");
				System.out.println("3: Polished");
				System.out.println("4: Excess Tar");
				asphaltType = kb.nextInt();
			}
			if(asphaltType == 1)
				factor = factor + "an";
			else
				if(asphaltType == 2)
					factor = factor + "at";
				else
					if(asphaltType == 3)
						factor = factor + "ap";
					else
						if(asphaltType == 4)
							factor = factor + "ae";
			break;
		case 3:
			System.out.println("Please select the type of gravel");
			System.out.println("1: Packed, Oiled");
			System.out.println("2: Loose");
			int gravelType = kb.nextInt();
			while(gravelType<1 || gravelType>2) {
				System.out.println("That is not an option");
				System.out.println("Please select the type of gravel");
				System.out.println("1: Packed, Oiled");
				System.out.println("2: Loose");
				gravelType = kb.nextInt();
			}
			if(gravelType == 1)
				factor = factor + "gp";
			else
				if(gravelType == 2)
					factor = factor + "gl";
			break;
		case 4:
			factor = factor + "cip";
			break;
		case 5:
			factor = factor + "rc";
			break;
		case 6: 
			factor = factor + "is";
			break;
		case 7: 
			System.out.println("Please select the type of ice");
			System.out.println("1: Packed");
			System.out.println("2: Loose");
			int iceType = kb.nextInt();
			while(iceType<1 || iceType>2) {
				System.out.println("That is not an option");
				System.out.println("Please select the type of ice");
				System.out.println("1: Packed");
				System.out.println("2: Loose");
				iceType = kb.nextInt();
			}
			if(iceType == 1)
				factor = factor + "sp";
			else
				if(iceType == 2)
					factor = factor + "sl";
			break;
		}
		
		System.out.println("Was the vehicle moving faster than 30 mph?");
		System.out.println("Press 1 if it was moving faster, 2 if it was moving slower");
		int speed = kb.nextInt();
		while(speed<1 || speed>2) {
			System.out.println("That is not an option");
			System.out.println("Was the vehicle moving faster than 30 mph?");
			System.out.println("Press 1 if it was moving faster, 2 if it was moving slower");
			speed = kb.nextInt();
		}
		if(speed == 1)
			factor = factor + "m";
		else
			if(speed == 2)
				factor = factor + "l";
						
		return values.get(factor);
			
	}
		
	public static void main(String[] args) {
		Map<Integer, velocityCase> simulations = new HashMap<Integer, velocityCase>();
		
		boolean cont = true;
		int simCount = 1;
		double f = 0;
		
		
		while(cont) {	//Main Menu --------------------------------------------------------------------------------------------------------	
			System.out.println("What would you like to do?: ");
			System.out.println("1: View velocity and simulation based on skid marks");
			System.out.println("2: View velocity and simulation based on yaw marks");
			System.out.println("3: View velocity and simulation based on an airborne vehicle");
			System.out.println("4: View news related to safe driving");
			System.out.println("5: View a previous simulation");
			System.out.println("6: Exit");
			int caseNumber = kb.nextInt();
			while(caseNumber<1 || caseNumber>6) {
				System.out.println("That is not an option");
				System.out.println("What would you like to do?: ");
				System.out.println("1: View velocity and simulation based on skid marks");
				System.out.println("2: View velocity and simulation based on yaw marks");
				System.out.println("3: View velocity and simulation based on an airborne vehicle");
				System.out.println("4: View news related to safe driving");
				System.out.println("5: View a previous simulation");
				caseNumber = kb.nextInt();	
			}
			
			
			
			switch(caseNumber) {
			case 1: //Skid Mark Velocity --------------------------------------------------------------------------------------------------------	
				f = getDragFactor();
				System.out.printf("From the given condtions the drag factor of %.2f will be used\n",f);
		
				skidMarksVel smv = new skidMarksVel(f, 9.8);
				smv.calSkidMarksVel();
				double initialVel = smv.getSkidMarksVel();
				System.out.printf("The initial velocity of the car was: %.2f\n", initialVel);
				smv.getSimulation();
				smv.getReport();
				
				boolean check = false;
				while(check == false) {
					System.out.println("Would you like to save this simulation?");
					System.out.println("1: Yes");
					System.out.println("2: No");
					int input = kb.nextInt();
					if(input == 1) {
						check = true;
						simulations.put(simCount++, smv);
						break;
					}
					else if(input == 2) {
						check = true;
						break;
					}
					else {
						System.out.println("Invalid entry");
						check = false;
					}
				}
				break;
			case 2: //Yaw Mark Velocity --------------------------------------------------------------------------------------------------------	
				f = getDragFactor();
				System.out.printf("From the given condtions the drag factor of %.2f will be used\n",f);

				yawMarksVel ymv = new yawMarksVel(f , 9.8);
				ymv.getInformation();
				ymv.calCriticalVel();
				double vc = ymv.getCriticalVel();
				System.out.printf("the critical velocity of the car was %.2f\n", vc);
				ymv.getSimulation();
				ymv.getReport();
				
				
				boolean check1 = false;
				while(check1 == false) {
					System.out.println("Would you like to save this simulation?");
					System.out.println("1: Yes");
					System.out.println("2: No");
					int input = kb.nextInt();
					if(input == 1) {
						check1 = true;
						simulations.put(simCount++, ymv);
						break;
					}
					else if(input == 2) {
						check1 = true;
						break;
					}
					else {
						System.out.println("Invalid entry");
						check1 = false;
					}
				}
				break;
				
			case 3: //Vault Case Velocity --------------------------------------------------------------------------------------------------------	
				
				vaultVel vcv = new vaultVel();
				vcv.getInformation();
				double vaultVelocity = vcv.getVaultVel();
				System.out.printf("The velocity of the car before take off was %.2f \n", vaultVelocity);
				vcv.getSimulation();	
				vcv.getReport();
				boolean check2 = false;
				while(check2 == false) {
					System.out.println("Would you like to save this simulation?");
					System.out.println("1: Yes");
					System.out.println("2: No");
					int input = kb.nextInt();
					if(input == 1) {
						check2 = true;
						simulations.put(simCount++, vcv);
						break;
					}
					else if(input == 2) {
						check2 = true;
						break;
					}
					else {
						System.out.println("Invalid entry");
						check1 = false;
					}
				}
				break;
			case 4:
				System.out.println("Wear your seatbelt!");
				break;
				
			case 5:
				System.out.println("Please enter the admin password (Password = 'password')");
				int tries = 0;
				while(!(kb.next().equals("password"))) {
					if(tries++ >= 5) {
						System.out.println("Too many incorrect tries");
						break;
					}
					System.out.println("Please try again");
				}
				System.out.println("Please select from the following");
				for (Map.Entry<Integer, velocityCase> entry : simulations.entrySet()) {
				    Integer key = entry.getKey();
				    Object value = entry.getValue();
				    System.out.println(key + ": " + value);
				}
				int simSelect = kb.nextInt();
				simulations.get(simSelect).getSimulation();

				
			
				break;
				
			case 6:	
				System.out.println("Goodbye!");
				cont = false;
				break;
	
			}	
		}
		kb.close();
	}

}
