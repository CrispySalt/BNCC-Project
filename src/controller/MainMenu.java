package controller;

import main.Main;
import java.util.concurrent.TimeUnit;

public class MainMenu {

	public MainMenu() {
		String temp;
		int temp1=-1;
		do {
			for(int i=0;i<30;i++) {
				System.out.println("");
			}
		System.out.flush();
		System.out.println("PT. Mentol Staff Management System");
		System.out.println("==================================");
		System.out.println("1. Insert Data Karyawan");
		System.out.println("2. View Data Karyawan");
		System.out.println("3. Update Data Karyawan");
		System.out.println("4. Delete Data Karyawan");
		System.out.println("5. Exit");
		System.out.print(">>");
		temp=Main.scan.nextLine();
		if((temp.matches("[0-9]"))) {
			temp1=Integer.parseInt(temp);
			switch(temp1) {
			default:temp1=-1;
				System.out.println("Invalid input!");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(int i=0;i<30;i++) {
					System.out.println("");
				}break;
			case 1:new InsertStaff();break;
			case 2:new ViewStaff();break;
			case 3:new EditStaff();break;
			case 4:new DeleteStaff();break;
			case 5:System.out.println("Exiting System...");new FileSave();System.exit(0);
			}
		}else {
    	System.out.println("Invalid input!");
    	try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	for(int i=0;i<30;i++) {
    		System.out.println("");
    	}
    }
	}while(temp1!=0);
	}

}
