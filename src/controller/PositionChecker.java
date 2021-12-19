package controller;

import main.Main;

public class PositionChecker {

	public PositionChecker(String position) {
		if(position.equals("Manager")) {
		if((Main.managerCount-1)%3==0&&Main.managerCount!=1&&Main.managerCount!=0) {
			System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");
			int temp=Main.managerCount;
			for(int i=0;i<Main.staff.size();i++) {
				if(temp!=1&&Main.staff.get(i).getJabatan().equals("Manager")) {
					System.out.printf("[%s]",Main.staff.get(i).getId());
					long gaji=((Main.staff.get(i).getGaji()/100)*110);
					Main.staff.get(i).setGaji(gaji);
				temp--;
				}
			}
			System.out.printf("\n");
		}
		}else if(position.equals("Supervisor")) {
			if((Main.supervisorCount-1)%3==0&&Main.supervisorCount!=1&&Main.supervisorCount!=0) {
			System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");
			int temp=Main.supervisorCount;
			for(int i=0;i<Main.staff.size();i++) {
				if(temp!=1&&Main.staff.get(i).getJabatan().equals("Supervisor")) {
					System.out.printf("[%s]",Main.staff.get(i).getId());
					long gaji=(long) ((Main.staff.get(i).getGaji()/100)*107.5);
					Main.staff.get(i).setGaji(gaji);
				temp--;
				}
			}
			System.out.printf("\n");
			}
		}else if(position.equals("Admin")) {
			if((Main.adminCount-1)%3==0&&Main.adminCount!=1&&Main.adminCount!=0) {
			System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id");
			int temp=Main.adminCount;
			for(int i=0;i<Main.staff.size();i++) {
				if(temp!=1&&Main.staff.get(i).getJabatan().equals("Admin")) {
					System.out.printf("[%s]",Main.staff.get(i).getId());
					long gaji=((Main.staff.get(i).getGaji()/100)*105);
					Main.staff.get(i).setGaji(gaji);
				temp--;
				}
			}
			System.out.printf("\n");
		}
		}
		return;
	}

}
