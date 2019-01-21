package com.journaldev.java;
import java.util.Random;

public class Parking {

	public static void main(String[] args) {
		int[] floor;
		floor = new int[12];
		Random rand= new Random();
		
		//susigeneruoja kiek laisvu vietu kiekvienam aukste
		for (int i=0; i<11; i++)
		{
			floor[i]=rand.nextInt(10);
				int aukst = i-2; //delete later
			System.out.println("Aukste " + aukst + " yra " + floor[i] + " laisvu vietu");
		}
		
		//susizino kuriame aukste yra automobilis IR kokio jis tipo
		int CarFloor = rand.nextInt(10)+1;
		CarFloor = CarFloor-2;
		int CarType = rand.nextInt(3)+1;
		System.out.println("Automobilis yra aukste " + CarFloor + ", " + CarType + " tipo");
		
		//kur arciausia petrol/diesel?
		
		int Suggest;
		if (floor[CarFloor+2]!=0)
		{
			System.out.println("Galite statytis " + CarFloor + " aukste");
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
				System.out.println("Automobiliu aikstele pilna");
			}
			else if (up == true && down == true)
			{
				Suggest= CarFloor+j;
				System.out.println("Galite statytis " + Suggest);
				Suggest= CarFloor-j;
				System.out.println("arba " + Suggest + " aukste");
			}
			else {
				if (up==true)
				{
					Suggest= CarFloor+j;
					System.out.println("Galite statytis " + Suggest + " aukste");
				}
				else 
				{
					Suggest= CarFloor-j;
					System.out.println("Galite statytis " + Suggest + " aukste");
				}
			}
		}
		
		//kur arciau van
		if((CarFloor!=0 && floor[1]!=0)) //gali statytis -1 aukste
		{
			System.out.println("Galite statytis -1 aukste");
		}
		else if (floor[0]!=0) //gali statytis -2 aukste
		{
			System.out.println("Galite statytis -2 aukste");
		}
		else System.out.println("Automobiliu aikstele pilna");
		
		//kur arciau electric
		if((CarFloor!=8 && floor[9]!=0)) //gali statytis 7 aukste
		{
			System.out.println("Galite statytis 7 aukste");
		}
		else if (floor[10]!=0) //gali statytis 8 aukste
		{
			System.out.println("Galite statytis 8 aukste");
		}
		else System.out.println("Automobiliu aikstele pilna");		
	}
}
