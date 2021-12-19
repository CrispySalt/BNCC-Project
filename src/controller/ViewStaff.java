package controller;

import java.io.IOException;

import main.Main;

public class ViewStaff {

	public ViewStaff() {
		for(int i=0;i<30;i++) {
			System.out.println("");
		}
		if(Main.staff.size()>0) {
			new PrintStaff();
		System.out.println("Press any button to return...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Main.scan.nextLine();
		}else {
			System.out.println("Tidak ada data Karyawan!");
			System.out.println("Press any button to return...");
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Main.scan.nextLine();
		}
	}

}
