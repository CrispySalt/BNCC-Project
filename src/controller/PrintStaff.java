package controller;

import java.util.ArrayList;
import java.util.Collections;

import main.Main;

public class PrintStaff {

	public PrintStaff() {
		System.out.println("|----|-----------------|--------------------------|---------------|-------------|-------------|");
		System.out.println("|No  |Kode Karyawan    |Nama Karyawan             |Jenis kelamin  |Jabatan      |Gaji Karyawan|");
		System.out.println("|----|-----------------|--------------------------|---------------|-------------|-------------|");
		ArrayList<String> temp=new ArrayList<>();
		for(int i=0;i<Main.staff.size();i++) {
			temp.add(Main.staff.get(i).getNama());
		}
		Collections.sort(temp);
		for(int i=0;i<Main.staff.size();i++) {
			for(int j=0;j<Main.staff.size();j++) {
				if(temp.get(i).equals(Main.staff.get(j).getNama())) {
					System.out.printf("|%1$4d|%2$17s|%3$26s|%4$15s|%5$13s|%6$13s|\n",
							i+1,Main.staff.get(j).getId(),Main.staff.get(j).getNama(),Main.staff.get(j).getJenisKelamin(),Main.staff.get(j).getJabatan(),Main.staff.get(j).getGaji());
				}
			}
		}
		System.out.println("|----|-----------------|--------------------------|---------------|-------------|-------------|");
	}

}
