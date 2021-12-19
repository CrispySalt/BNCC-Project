package controller;

import java.io.IOException;

import main.Main;
import models.Staff;

public class InsertStaff {

	public InsertStaff() {
		String nama;
		String jenisKelamin;
		String jabatan;
		String id;
		long gaji=0;
		System.out.println("['0' to return]");
		do {
			System.out.print("Input nama Karyawan [>=3]:");
			nama=Main.scan.nextLine();
			if(nama.equals("0")) {
				return;
			}
		} while (nama.length()<3);
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive):");
			jenisKelamin=Main.scan.nextLine();
			if(jenisKelamin.equals("0")) {
				return;
			}
		}while(!(jenisKelamin.equals("Laki-laki"))&&!(jenisKelamin.equals("Perempuan")));
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive):");
			jabatan=Main.scan.nextLine();
			if(jabatan.equals("0")) {
				return;
			}
		}while(!(jabatan.equals("Manager"))&&!(jabatan.equals("Supervisor"))&&!(jabatan.equals("Admin")));
		int ranking=0;
		if(jabatan.equals("Manager")) {
			gaji=8000000;
			Main.managerCount+=1;
			ranking=Main.managerCount;
		}else if(jabatan.equals("Supervisor")) {
			Main.supervisorCount+=1;
			ranking=Main.supervisorCount;
			gaji=6000000;
		}else if(jabatan.equals("Admin")) {
			Main.adminCount+=1;
			ranking=Main.adminCount;
			gaji=4000000;
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
		Staff tempStaff=new Staff(id, nama, jenisKelamin, jabatan, gaji,ranking);
		Main.staff.add(tempStaff);
		System.out.println("Berhasil menambahkan karyawan dengan id "+id);
		new PositionChecker(jabatan);
		new FileSave();
		System.out.println("Press any button to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Main.scan.nextLine();
		return;
	}

}
