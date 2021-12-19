package controller;

import java.io.FileWriter;
import java.io.IOException;

import main.Main;

public class FileSave {

	public FileSave() {
		try {
			saveStaff();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void saveStaff() throws IOException {
		FileWriter saveStaff = new FileWriter("StaffData.txt");
		for(int i=0;i<Main.staff.size();i++) {
			String temp=String.format("%s#%s#%s#%s#%d#%d\n",Main.staff.get(i).getId(),Main.staff.get(i).getNama(),Main.staff.get(i).getJenisKelamin(),
					Main.staff.get(i).getJabatan(),Main.staff.get(i).getGaji(),Main.staff.get(i).getRanking());
			saveStaff.write(temp);
		}
		saveStaff.close();
		
	}
	

}
