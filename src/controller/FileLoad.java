package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import main.Main;
import models.Staff;

public class FileLoad {

	public FileLoad() {
		StaffLoad();
	}

	private void StaffLoad() {
		try {
		File loadStaff = new File("StaffData.txt");
		Scanner fileReader = new Scanner(loadStaff);
		fileReader.useDelimiter("#");
		while(fileReader.hasNextLine()) {
			String id = fileReader.next();
			String nama = fileReader.next();
			String jenisKelamin = fileReader.next();
			String jabatan = fileReader.next();
			String gaji=fileReader.next();
			long gaji1=Long.parseLong(gaji);
			String ranking=fileReader.nextLine();
			String ranking1=ranking.replaceAll("[#]", "");
			int ranking2=Integer.parseInt(ranking1);
			Staff temp = new Staff(id,nama,jenisKelamin,jabatan,gaji1,ranking2);
			Main.staff.add(temp);
			if(jabatan.equals("Manager")) {
				Main.managerCount+=1;
			}else if(jabatan.equals("Supervisor")) {
				Main.supervisorCount+=1;
			}else if(jabatan.equals("Admin")) {
				Main.adminCount+=1;
			}
		}
		fileReader.close();
		}catch(FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}
	

}
