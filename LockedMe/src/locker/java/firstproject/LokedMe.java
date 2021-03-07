package locker.java.firstproject;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class LokedMe {
	public static final String dir = "/home/rajeev/EclipseProjects/LockedMe/mydirectory";

	public static void main(String[] args) {
		mainscreen();
		navigation();
	}

	public static void mainscreen() {
		// -------------------- Main Menu Screen Design
		// ---------------------------------//
		System.out.println("-----------------------------------------------------------------");
		System.out.print("|");
		System.out.format("\t \t LokedMe.com By Lockers Pvt Ltd. \t \t");
		System.out.println("|");
		System.out.print("|");
		System.out.format("\t \t Developer : RAJEEV RANJAN KUMAR. \t \t");
		System.out.println("|");
		System.out.print("|");
		System.out.format("\t \t Email ID : raj89in@gmail.com \t \t \t");
		System.out.println("|");
		System.out.print("|");
		System.out.format("\t \t Contact No : 7004860216. \t \t \t");
		System.out.println("|");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Main Menu For Navigation");
		System.out.println("Press.");
		System.out.println("1. To List files in Accending Order");
		System.out.println("2. For user interaction operations");
		System.out.println("3. Exit Application");
		
		// -------------------- End Of Main Menu Screen Design
		// ---------------------------------//
	}

	public static void navigation() {
		try {
			Scanner scanner = new Scanner(System.in);
			int selected = 0;
			if (scanner.hasNext()) {
				selected = scanner.nextInt();
			}
			// scanner.close();
			switch (selected) {
			case 1:
				listFiles();
				navigation();
				break;
			case 2:
				subnavigation();
				break;
			case 3:
				System.out.println("Application has been terminated !");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input!!");
				navigation();
				break;
			}
		} catch (Exception e) {

		}
	}
	
	public static void subnavigation() {
		System.out.println("Sub Menu For Navigation");
		System.out.println("Press.");
		System.out.println("1. Add a new File");
		System.out.println("2. Delete A File");
		System.out.println("3. Search A File");
		System.out.println("4. Back To Main Menu");
		try {
			Scanner scanner = new Scanner(System.in);
			int selected = 0;
			if (scanner.hasNext()) {
				selected = scanner.nextInt();
			}
			// scanner.close();
			switch (selected) {
			case 1:
				addFiles();
				subnavigation();
				break;
			case 2:
				deleteFile();
				subnavigation();
				break;
			case 3:
				searchFile();
				subnavigation();
				break;
			case 4:
				mainscreen();
				navigation();
				break;
			default:
				System.out.println("Invalid Input!!");
				subnavigation();
				break;
			}
		} catch (Exception e) {

		}
	}

	public static void listFiles() {
		try {
			File f1 = new File(dir);
			String s[] = f1.list();
			Arrays.sort(s);
			if (s.length != 0) {
				for (String mystr : s) {
					System.out.println(mystr);
				}
			} else {
				System.out.println("Directory is empty!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addFiles() {
		System.out.println("Enter the file name : ");
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.next();
		try {
			File myfile = new File(dir + "/" + filename + ".txt");
			if (myfile.createNewFile()) {
				System.out.println("File has been created:" + myfile.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteFile() {
		System.out.println("Enter the file name : ");
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.next();
		try {
			File myfile = new File(dir + "/" + filename + ".txt");
			if (myfile.delete()) {
				System.out.println("File has been deleted:" + myfile.getName());
			} else {
				System.out.println("Failed to delete the file.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchFile() {
		System.out.println("Enter the file name : ");
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.next();
		filename = filename + ".txt";
		try {
			File f1 = new File(dir);
			String s[] = f1.list();
			Arrays.sort(s);
			if (s.length != 0) {
				for (String mystr : s) {
					if (mystr.equals(filename)) {
						System.out.println("Search successfull :" + filename);
					} else {
						System.out.println("Search failed :" + filename);
					}
				}
			} else {
				System.out.println("Directory is empty!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
