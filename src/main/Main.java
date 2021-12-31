package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import controller.FileHandling;
import controller.MainMenu;
import models.Staff;

public class Main {
	
	public static ArrayList<Staff> staff=new ArrayList<>();
	public static Scanner scan=new Scanner(System.in);
	public static Random rand=new Random();
	public static int adminCount=0;
	public static int managerCount=0;
	public static int supervisorCount=0;
	public static int enableFileHandling=0;
	public Main() {
		String choice1;
		String choice;
		System.out.println("Created by: Raymond Dehenrich Susilo");
		System.out.println("[Input is Case-Sensitive]");
		do {
			System.out.print("Do you want to enable File Handling[Save/Load from file]? [Y/N]:");
			choice1=scan.nextLine();
		}while(!(choice1.equals("Y"))&&!(choice1.equals("N")));
		if(choice1.equals("Y")) {
			enableFileHandling=1;
		}else {
			System.out.println("[Warning] Any modified data will not be saved!");
			System.out.println("Press any button to continue...");
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}scan.nextLine();
			enableFileHandling=0;}
		if(enableFileHandling==1) {
		do {
			System.out.print("Load data from existing file? [Y/N]:");
			choice=scan.nextLine();
		}while(!(choice.equals("Y"))&&!(choice.equals("N")));
		if(choice.equals("Y")) {
			new FileHandling(1);
		}else {
			System.out.println("[Warning] existing file will be overwritten!");
			System.out.println("Press any button to continue...");
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}scan.nextLine();
		}
		}
		new MainMenu();
		}

	public static void main(String[] args) {
		new Main();
	}

}
