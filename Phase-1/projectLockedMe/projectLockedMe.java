package LockedMe;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class projectLockedMe {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String dirPath = "D:\\";

		while (true) {

			System.out.println("Welcome to the Virtual Key Repository");
			System.out.println("Developer Name : Aditya Pranav\n");

			System.out.println("Enter 1 : Get filename from directory in sorted manner");
			System.out.println("Enter 2 : For business level operations");
			System.out.println("Enter 3 : Close the application");

			String choice = sc.nextLine();

			if (choice.equals("1")) {
				// logic for displaying files in ascending order
				File directory = new File(dirPath);

				// List of all the files in directories and shorting
				String contents[] = directory.list();
				Arrays.sort(contents);
				System.out.println("List of files and directories in the specified directory:");
				for (int i = 0; i < contents.length; i++) {
					System.out.println(contents[i]);
				}
				System.out.println();
			}

			else if (choice.equals("2")) {
				while (true) {
					System.out.println("Enter 1 : To create new file");
					System.out.println("Enter 2 : Delete a file");
					System.out.println("Enter 3 : Search a file");
					System.out.println("Enter 4 : Go back");

					String chTwo = sc.nextLine();
					String fileName = null;

					if (chTwo.equals("1")) {
						System.out.println("Enter the name of the file");
						fileName = sc.nextLine();
						// logic for creating file

						File fileWithAbsolutePath = new File(dirPath + "/" + fileName + ".txt");
						if (fileWithAbsolutePath.exists()) {

							System.out.println("file with the given name already exists\n");

						} else {
							try {
								fileWithAbsolutePath.createNewFile();
								System.out.println("File Added Successfully\n");
							} catch (IOException e) {
								System.out.println("Please enter a valid file name");
								e.printStackTrace();
							}
						}

					} else if (chTwo.equals("2")) {
						System.out.println("Enter a file name to delete");
						fileName = sc.nextLine();
						// logic to delete a file
						File file = new File(dirPath + "/" + fileName + ".txt");

						if (file.delete()) {
							System.out.println("File deleted successfully");
						} else {
							System.out.println("Failed to delete the file");
							System.out.println("File Not Found\n");

						}

					} else if (chTwo.equals("3")) {
						System.out.println("Enter the file name (with .txt) to search");
						fileName = sc.nextLine();
						// logic to search a file

						File directory = new File(dirPath);
						int flag = 0;
						// List of all files and directories
						String contents[] = directory.list();
						for (String str : contents) {

							if (str.equals(fileName)) {
								System.out.println("File " + fileName + " found\n");
								flag++;
								break;
							}
						}
						if (flag == 0) {
							System.out.println("File Not Found\n");
						}
					} else if (chTwo.equals("4")) {
						break;
						// go back to outer loop
					} else {
						System.out.println("\nPlease enter a valid number\n");
					}
				}
			} else if (choice.equals("3")) {
				break;
				// exit program
			} else {
				System.out.println("\nPlease enter a valid number\n");
			}
		}
	}

}
