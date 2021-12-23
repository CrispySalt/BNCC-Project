package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import main.Main;
import models.Staff;

public class FileHandling {

	public FileHandling(int mode) {
		//1=load,2=save
		if(mode==1) {
			fileLoad();
		}else if(mode==2) {
			fileSave();
		}
	}
	
	private void fileSave() {
		try {
			staffSave();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void fileLoad() {
		staffLoad();
	}
	
	protected void staffSave() throws IOException {
		FileWriter saveStaff = new FileWriter("StaffData.txt");
		for(int i=0;i<Main.staff.size();i++) {
			String temp=String.format("%s#%s#%s#%s#%d#%d\n",Main.staff.get(i).getId(),Main.staff.get(i).getNama(),Main.staff.get(i).getJenisKelamin(),
					Main.staff.get(i).getJabatan(),Main.staff.get(i).getGaji(),Main.staff.get(i).getRanking());
			saveStaff.write(temp);
		}
		saveStaff.close();
		
	}
	
	protected void staffLoad(){
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
