package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import main.Main;

public class DeleteStaff {

	public DeleteStaff() {
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
			System.out.println(Main.staff.size());
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
			System.out.println("test");;
			choice--;
			int tempCheck=0;
			for(int i=0;i<Main.staff.size();i++) {
				for(int j=0;j<Main.staff.size();j++) {
					if(temp.get(i).equals(Main.staff.get(j).getNama())) {
						if(i==choice&&tempCheck==0) {
							System.out.println("Staff deleted!");
							if(Main.staff.get(j).getJabatan().equals("Manager")) {
								Main.managerCount--;
								for(int x=i;x<Main.staff.size();x++) {
									if(Main.staff.get(x).getJabatan().equals("Manager")) {
										Main.staff.get(x).setRanking(Main.staff.get(i).getRanking()-1);
									}
								}
							}else if(Main.staff.get(j).getJabatan().equals("Supervisor")) {
								Main.supervisorCount--;
								for(int x=i;x<Main.staff.size();x++) {
									if(Main.staff.get(x).getJabatan().equals("Supervisor")) {
										Main.staff.get(x).setRanking(Main.staff.get(i).getRanking()-1);
									}
								}
							}else if(Main.staff.get(j).getJabatan().equals("Admin")) {
								Main.adminCount--;
								for(int x=i;x<Main.staff.size();x++) {
									if(Main.staff.get(x).getJabatan().equals("Admin")) {
										Main.staff.get(x).setRanking(Main.staff.get(i).getRanking()-1);
									}
								}
							}
							Main.staff.remove(j);
							new FileSave();
							tempCheck=1;
						}
					}
				}
			}
			System.out.println("Press any button to return...");
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}else {
				System.out.println("Tidak ada data Karyawan!");
				System.out.println("Press any button to return...");
				try {
					System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		Main.scan.nextLine();
		return;
		}
}
