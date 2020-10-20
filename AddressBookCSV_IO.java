package com.bridgelabz.addressbook;

import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookCSV_IO {
	private static String CSV_FILE_PATH = "C:\\Users\\SOURABH HARALE\\eclipse-workspace\\bridgelabz\\src\\main\\java\\com\\bridgelabz\\addressbook\\ContactList.csv";

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public void writeContactToCSVFile()
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		// Creating writer class to generate csv file
		Writer writer = Files.newBufferedWriter(Paths.get(CSV_FILE_PATH));

		List<Contact> listOfContacts = new ArrayList<>();
		listOfContacts.add(new Contact("Sourabh", "Harale", "Gandhari", "Hyderabad", "Telangana", 503114, 949411827,
				"hsourabh@gmail.com"));
		listOfContacts.add(new Contact("Dheeraj", "Harale", "Kamareddy", "Hyderabad", "Telangana", 503114, 720702046,
				"dheeraj@gmail.com"));

		// Creating StatefulBeanToCsv object
		StatefulBeanToCsvBuilder<Contact> builder = new StatefulBeanToCsvBuilder(writer);
		StatefulBeanToCsv beanWriter = builder.build();

		// Write list to StatefulBeanToCsv object
		beanWriter.write(listOfContacts);
		// closing the writer object
		writer.close();
	}

	public void readContactsFromCSVFile() {
		try {

			// Create an object of fileReader class with CSV file as a parameter.
			FileReader filereader = new FileReader(
					"C:\\Users\\SOURABH HARALE\\eclipse-workspace\\bridgelabz\\src\\main\\java\\com\\bridgelabz\\addressbook\\ContactList.csv");

			// create csvReader object passing
			// file reader as a parameter
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;

			// we are going to read data line by line
			int flag = 0;
			while ((nextRecord = csvReader.readNext()) != null) {
				if (flag != 0) {
					System.out.println("Address - " + nextRecord[0]);
					System.out.println("City - " + nextRecord[1]);
					System.out.println("Email - " + nextRecord[2]);
					System.out.println("First Name - " + nextRecord[3]);
					System.out.println("Last Name - " + nextRecord[4]);
					System.out.println("Phone - " + nextRecord[5]);
					System.out.println("State - " + nextRecord[6]);
					System.out.println("Zip - " + nextRecord[7]);
				}
				flag++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
