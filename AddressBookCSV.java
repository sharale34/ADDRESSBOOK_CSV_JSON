package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookCSV {
	private static Scanner sc = new Scanner(System.in);
	static List<Contact> contactList;

	public enum addressBookEnum {
		FILE_IO, CONSOLE_IO;
	}

	public AddressBookCSV() {
	}

	public AddressBookCSV(ArrayList<Contact> contactList) {
		AddressBookCSV.contactList = contactList;
	}

	public static void main(String[] args) throws Exception {
		AddressBookCSV addressBook = new AddressBookCSV();
		int choice = 0;
		do {
			System.out.println("Select from Menu! \n1 : Add contact Details \n2 : View contact Details \n3 : Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				write(addressBookEnum.FILE_IO);
				break;
			case 2:
				addressBook.readContactDetails(addressBookEnum.FILE_IO);
				break;
			}
		} while (choice != 3);
	}

	private void readContactDetails(addressBookEnum fileIo) {
		if (fileIo.equals(addressBookEnum.FILE_IO))
			new AddressBookCSV_IO().readContactsFromCSVFile();
	}

	private static void write(addressBookEnum fileIo) throws Exception {
		if (fileIo.equals(addressBookEnum.FILE_IO))
			new AddressBookCSV_IO().writeContactToCSVFile();
	}
}
