package com.bayviewglen.addressbook;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Start {
	static Scanner scanner = new Scanner(System.in);
	static AddressBook inUse;

	public static void main(String[] args) throws IOException, InterruptedException {
		mainMenu();
	}

	public static void mainMenu() throws IOException, InterruptedException {

		scanner = new Scanner(System.in);
		File file = new File("addressbooks/addressbook.txt");
		File file2 = new File("addressbooks/addressbook2.txt");

		AddressBook a1 = new AddressBook(file);
		AddressBook a2 = new AddressBook(file2);

		inUse = a1;
		boolean validBook = false;
		System.out.println("Hello, welcome to The Address Book.  Please select the address book you want to access: ");
		while (!validBook) {
			System.out.println("Enter the number of the Book you want to access.");
			System.out.println("1. Address Book 1");
			System.out.println("2. Address Book 2");

			int tempChoice = scanner.nextInt();
			if (tempChoice == 1) {
				inUse = a1;
				validBook = true;
			} else if (tempChoice == 2) {
				inUse = a2;
				validBook = true;
			}
		}

		startAgain(inUse);
	}

	public static void startAgain(AddressBook book) throws IOException, InterruptedException {
		boolean validMainMenu = false;
		while (!validMainMenu) {
			System.out.println("What would you like to do now?");
			Thread.sleep(1000);
			System.out.println("To search for a contact, enter (1)");
			Thread.sleep(1000);
			System.out.println("To add a contact, enter (2)");
			Thread.sleep(1000);
			System.out.println("To display your entire address book, enter (3)");
			Thread.sleep(1000);
			System.out.println("To select a different address book, enter (4)");
			Thread.sleep(1000);

			int choice = scanner.nextInt();
			scanner.nextLine();
			String tempChoice2;
			if (choice == 4) {
				mainMenu();
			}
			if (choice == 1) {
				boolean searchAgain = true;
				while (searchAgain) {
					System.out.println("Enter something to search.  Either a first name, last name, or phone number");

					tempChoice2 = scanner.nextLine();

					if ((inUse.search(tempChoice2)) == null) {
						System.out.println("Contact not found, sorry.");
						System.out.println();
						System.out.println();
						System.out.println("What now?");
						System.out.println("Search again (1)");
						System.out.println("Previous menu (2)");
						int tempChoice = scanner.nextInt();
						if (tempChoice == 1) {
							searchAgain = true;
							scanner.nextLine();
						} else if (tempChoice == 2) {
							startAgain(inUse);
						}

					}

					else {
						searchAgain = false;
						System.out.print("Searching.");
						Thread.sleep(400);
						System.out.print(".");
						Thread.sleep(400);
						System.out.println(".");
						Thread.sleep(400);
						System.out.println();

						System.out.println("Result:");
						inUse.searchDisplay(tempChoice2);

						System.out.println("Options:");
						System.out.println("Delete a contact: 1");
						System.out.println("Previous menu: 2");

						int deleteChoice = scanner.nextInt();

						if (deleteChoice == 2) {
							startAgain(inUse);
						} else if (deleteChoice == 1) {
							searchAgain = false;
							System.out.println("Enter number above contact you wish to delete: ");
							int tempDelete = scanner.nextInt();
							if (tempDelete > inUse.searchList(tempChoice2).size() || tempDelete < 1) {
								System.out.println("Not a valid entry");
								System.out.println();
								System.out.println();
								Thread.sleep(2000);
								startAgain(inUse);
							}
							inUse.removeContact(inUse.searchList(tempChoice2).get(tempDelete - 1));
							System.out.println("Contact removed.");

							startAgain(inUse);
						}
					}
					validMainMenu = true;
				}
			} else if (choice == 3) {
				inUse.displayContacts();

				System.out.println("What now?");
				System.out.println("Return to previous menu? Enter 1.");
				System.out.println("Quit? Enter 2.");

				int decision = scanner.nextInt();
				if (decision == 1) {
					startAgain(inUse);
				}
				validMainMenu = true;
			} else if (choice == 2) {
				System.out.println("Please enter the first name you would like this contact to have: ");
				String chosenFName = scanner.nextLine();
				System.out.println("Please enter the last name you would like this contact to have: ");
				String chosenLname = scanner.nextLine();
				System.out.println(
						"Please enter the phone number you would like this contact to have, with the format xxx-xxx-xxxx");
				String chosenPhone = scanner.nextLine();

				inUse.addContact(chosenFName, chosenLname, chosenPhone);

				System.out.println("Contact added.");

				validMainMenu = true;
				startAgain(inUse);
			}

		}
	}

}
