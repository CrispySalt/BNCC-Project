package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import main.Main;
import models.Staff;

public class EditStaff {

	protected String checker;
	public EditStaff() {
		for(int i=0;i<30;i++) {
			System.out.println("");
		}
		if(Main.staff.size()>0) {
			new PrintStaff();
			ArrayList<String> temp=new ArrayList<>();
			for(int i=0;i<Main.staff.size();i++) {
				temp.add(Main.staff.get(i).getNama());
			}
			Collections.sort(temp);
			int choice=-1;
			String tempC;
			do {
				System.out.print("Input No ['0' to return]>>");
				tempC=Main.scan.nextLine();
				if(tempC.matches("[0-9]+")) {
					choice=Integer.parseInt(tempC);
				}
			}while(choice<0||choice-1>=Main.staff.size());
			if(choice==0) {
				return;
			}
			choice--;
			for(int i=0;i<Main.staff.size();i++) {
				for(int j=0;j<Main.staff.size();j++) {
					if(temp.get(i).equals(Main.staff.get(j).getNama())) {
						if(i==choice) {
						this.checker=Main.staff.get(j).getJabatan();
						startedEdit(i,j);
						return;
						}
					}
				}
			}		
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

	private void startedEdit(int index,int index1) {
		String nama;
		String jenisKelamin;
		String jabatan;
		String id;
		long gaji=0;
		do {
			System.out.print("Input nama Karyawan [>=3]:");
			nama=Main.scan.nextLine();
		} while (nama.length()<3);
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive):");
			jenisKelamin=Main.scan.nextLine();
		}while(!(jenisKelamin.equals("Laki-laki"))&&!(jenisKelamin.equals("Perempuan")));
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive):");
			jabatan=Main.scan.nextLine();
		}while(!(jabatan.equals("Manager"))&&!(jabatan.equals("Supervisor"))&&!(jabatan.equals("Admin")));
		int ranking=0;
		if(jabatan.equals("Manager")) {
			gaji=8000000;
			Main.managerCount+=1;
			ranking=Main.managerCount;
		}else if(jabatan.equals("Supervisor")) {
			Main.supervisorCount+=1;
			gaji=6000000;
			ranking=Main.supervisorCount;
		}else if(jabatan.equals("Admin")) {
			Main.adminCount+=1;
			gaji=4000000;
			ranking=Main.adminCount;
		}
		int checker=0;
		do {
			int id1=Main.rand.nextInt(90-65+1)+65;
			int id2=Main.rand.nextInt(90-65+1)+65;
			int id3=Main.rand.nextInt(9999-0000+1)+0;
			id=String.format("%c%c-%04d",id1,id2,id3);
			checker=1;
			for(int i=0;i<Main.staff.size();i++) {
				if(Main.staff.get(i).getId().equals(id)) {
					checker=0;
					break;
				}else checker=1;
			}
		}while(checker==0);
		Staff temp=new Staff(id, nama, jenisKelamin, jabatan, gaji, ranking);
		if(Main.staff.get(index).getJabatan().equals("Manager")) {
			Main.managerCount--;
			for(int i=index+1;i<Main.staff.size();i++) {
				if(Main.staff.get(i).getJabatan().equals("Manager")) {
					Main.staff.get(i).setRanking(Main.staff.get(i).getRanking()-1);
				}
			}
		}else if(Main.staff.get(index).getJabatan().equals("Supervisor")) {
			Main.supervisorCount--;
			for(int i=index+1;i<Main.staff.size();i++) {
				if(Main.staff.get(i).getJabatan().equals("Supervisor")) {
					Main.staff.get(i).setRanking(Main.staff.get(i).getRanking()-1);
				}
			}
		}else if(Main.staff.get(index).getJabatan().equals("Admin")) {
			Main.adminCount--;
			for(int i=index+1;i<Main.staff.size();i++) {
				if(Main.staff.get(i).getJabatan().equals("Admin")) {
					Main.staff.get(i).setRanking(Main.staff.get(i).getRanking()-1);
				}
			}
		}
		Main.staff.set(index1, temp);
		System.out.println("Berhasil Menganti karyawan dengan id baru "+id);
		if(!(jabatan.equals(this.checker))) {
			new PositionChecker(jabatan);
		}
		new FileSave();
		System.out.println("Press any button to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Main.scan.nextLine();
		
	}

}
