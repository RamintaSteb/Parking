package com.journaldev.java;
import java.util.Random;
import java.util.Scanner;

public class Parking {

	public static void main(String[] args) {
		int[] floor;
		floor = new int[12];
		Random rand= new Random();
		Scanner in = new Scanner(System.in);
		
		//generates how many free 
		for (int i=0; i<11; i++)
		{
			floor[i]=rand.nextInt(10);
				int aukst = i-2;
			System.out.println("In " + aukst + " floor are/is " + floor[i] + " empty spaces"); //shows floors occupancy
		}
		boolean repeat = true;
		while (repeat == true)
		{
			//Decides car type and in which floor THE car is
			int CarFloor = rand.nextInt(10)+1;
			CarFloor = CarFloor-2;
			int CarType = rand.nextInt(3)+1;
			String type;
			if (CarType==1) type = "petrol/diesel";
			else if (CarType==2) type = "van";
			else type="electric";
			System.out.println("Your car is in " + CarFloor + " floor, " + type + " type");
			
			int Suggest;
			if (CarType==1) //if it is petrol/diesel
			{
				if (floor[CarFloor+2]!=0)
				{
					System.out.println("You can go to " + CarFloor + " floor");
					floor[CarFloor+2]--;
				}
				else
				{
					boolean up=false, down=false;
					int j=0;
					while ((up==false && down==false) && j<=10)
					{
						j++;
						if (CarFloor+j+2<11)
						{
							if (floor[CarFloor+j+2]!=0)
							{
								up=true;
							}
						}
						if (CarFloor-j+2>=0)
						{
							if (floor[CarFloor-j+2]!=0)
							{
								down=true;
							}
						}
					}
					if (up == false && down == false)
					{
						System.out.println("No available spots right now");
					}
					else {
						if (up==true)
						{
							Suggest= CarFloor+j;
							System.out.println("You can go to " + Suggest + " floor");
							floor[Suggest+2]--;
						}
						else 
						{
							Suggest= CarFloor-j;
							System.out.println("You can go to " + Suggest + " floor");
							floor[Suggest+2]--;
						}
					}
				}
			}
			
			else if (CarType==2) //if it is van
			{
				if((CarFloor!=(-2) && floor[1]!=0)) //-1 floor
				{
					System.out.println("You can go to -1 floor");
					floor[1]--;
				}
				else if (floor[0]!=0) //-2 floor
				{
					System.out.println("You can go to -2 floor");
					floor[0]--;
				}
				else System.out.println("No available spots right now");
			}
			
			else //if it is electric
			{
				if((CarFloor!=8 && floor[9]!=0)) //7th floor
				{
					System.out.println("You can go to 7 floor");
					floor[9]--;
				}
				else if (floor[10]!=0) //8th floor
				{
					System.out.println("You can go to 8 floor");
					floor[10]--;
				}
				else System.out.println("No available spots right now");
			}
			System.out.println("Would you like to park one more car? 1/0");
			if (in.nextInt()==0) repeat=false;
		}
		
	}
}
