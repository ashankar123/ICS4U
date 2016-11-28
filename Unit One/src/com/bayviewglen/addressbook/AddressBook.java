package com.bayviewglen.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	private ArrayList<Contact> list;
	private PrintWriter writer;
	private Scanner scanner;
	private String filePath;

	public AddressBook(File file) throws FileNotFoundException {
		list = new ArrayList<Contact>();
		File f = file;
		scanner = new Scanner(f);
		filePath = "Books\\" + file.getName();
		file.getName().substring(0, file.getName().length() - 4);
		insertContacts();

	}

	public void insertContacts() {
		int numContacts = scanner.nextInt();
		if (numContacts > 0) {
			scanner.nextLine();
		}
		String temp;
		String fName, lName, phoneNumber;
		for (int i = 0; i < numContacts; i++) {
			temp = scanner.nextLine();
			fName = temp.split(" ")[0];
			lName = temp.split(" ")[1];
			phoneNumber = temp.split(" ")[2];
			list.add(new Contact(fName, lName, phoneNumber));
		}
	}

	public void addContact(String firstName, String lastName, String phoneNumber) throws FileNotFoundException {
		list.add(new Contact(firstName, lastName, phoneNumber));
		saveContacts();
	}

	public void removeContact(Contact contact) throws FileNotFoundException {
		list.remove(contact);
		saveContacts();
	}

	public void displayContacts() {
		int counter = 0;
		for (Contact contact : list) {
			System.out.println(counter + 1 + ":");
			System.out.println("First name: " + contact.getFirstName());
			System.out.println("Last name: " + contact.getLastName());
			System.out.println("Phone number: " + contact.getPhoneNumber());
			System.out.println();
			counter++;
		}
	}

	public ArrayList<Contact> searchList(String x) {
		ArrayList<Contact> found = new ArrayList<Contact>();
		for (Contact contact : list) {
			if (contact.getFirstName().toLowerCase().equals(x.toLowerCase())) {
				found.add(contact);
			} else if (contact.getLastName().toLowerCase().equals(x.toLowerCase())) {
				found.add(contact);
			} else if (contact.getPhoneNumber().equals(x)) {
				found.add(contact);
			}
		}
		if (found.get(0) != null) {
			return found;
		}
		return null;
	}

	public void searchDisplay(String x) {
		int countResults = 0;
		for (Contact contact : list) {
			if (contact.getFirstName().toLowerCase().equals(x.toLowerCase())) {
				System.out.println(countResults + 1 + ":");
				System.out.print("First Name: ");
				System.out.println(contact.getFirstName());
				System.out.print("Last Name: ");
				System.out.println(contact.getLastName());
				System.out.print("Phone Number: ");
				System.out.println(contact.getPhoneNumber());
				System.out.println();
				countResults++;

			} else if (contact.getLastName().toLowerCase().equals(x.toLowerCase())) {
				System.out.println(countResults + 1 + ":");
				System.out.print("First Name: ");
				System.out.println(contact.getFirstName());
				System.out.print("Last Name: ");
				System.out.println(contact.getLastName());
				System.out.print("Phone Number: ");
				System.out.println(contact.getPhoneNumber());
				System.out.println();
				countResults++;
			} else if (contact.getPhoneNumber().equals(x)) {
				System.out.println(countResults + 1 + ":");
				System.out.print("First Name: ");
				System.out.println(contact.getFirstName());
				System.out.print("Last Name: ");
				System.out.println(contact.getLastName());
				System.out.print("Phone Number: ");
				System.out.println(contact.getPhoneNumber());
				System.out.println();
				countResults++;
			}
		}

	}

	public Contact search(String x) {
		for (Contact contact : list) {
			if (contact.getFirstName().toLowerCase().equals(x.toLowerCase())) {
				return contact;
			} else if (contact.getLastName().toLowerCase().equals(x.toLowerCase())) {
				return contact;
			} else if (contact.getPhoneNumber().equals(x)) {
				return contact;
			}
		}
		return null;
	}

	public void saveContacts() throws FileNotFoundException {
		writer = new PrintWriter(filePath);
		writer.println(list.size());
		for (Contact contact : list) {
			writer.println(contact.getFirstName() + " " + contact.getLastName() + " " + contact.getPhoneNumber());
		}
		writer.close();
	}

}
