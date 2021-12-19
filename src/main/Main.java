package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import controller.FileLoad;
import controller.MainMenu;
import models.Staff;

public class Main {
	
	public static ArrayList<Staff> staff=new ArrayList<>();
	public static Scanner scan=new Scanner(System.in);
	public static Random rand=new Random();
	public static int adminCount=0;
	public static int managerCount=0;
	public static int supervisorCount=0;
	public Main() {
		String choice;
		System.out.println("Created by: Raymond Dehenrich Susilo");
		do {
			System.out.print("Load data from file? [Y/N]:");
			choice=scan.nextLine();
		}while(!(choice.equals("Y"))&&!(choice.equals("N")));
		if(choice.equals("Y")) {
			new FileLoad();
		}else {
			System.out.println("Warning! Old data will be overwritten!");
			System.out.println("Press any button to continue...");
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}scan.nextLine();
		}
		new MainMenu();
		}

	public static void main(String[] args) {
		new Main();
	}

}
