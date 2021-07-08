/**
 * @author Sanobar Mujawar
 * @Created_on: 07.06.21
 * 
 * Purpose: Address book system to manage person data and can 
 * add, edit, delete person details.
 * 
 */

package com.bridgelabz.JavaPractice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.bridgelabz.JavaPractice.Util.AddressBookUtility;
import com.bridgelabz.JavaPractice.Util.FileIO;
import com.bridgelabz.JavaPractice.Util.InputUtil;
import com.bridgelabz.JavaPractice.exception.AddressBookException;
import com.bridgelabz.JavaPractice.service.AddressBookService;
import com.bridgelabz.JavaPractice.service.DatabaseOperations;
import com.bridgelabz.JavaPractice.service.SearchSortOperations;
import com.opencsv.exceptions.CsvValidationException;

public class AddressBook {

	// main
	public static void main(String[] args)
			throws AddressBookException, IOException, CsvValidationException, SQLException {

		final String JSON_SIMPLE_FILE_PATH = "src/main/resources/JSonSimpleAddressBook.json";
		final String OPEN_CSV_FILE_PATH = "src/main/resources/CSVAddressBook.csv";
		final int jsonSampleOperation = 1, openCSVOperation = 2;
		int operations = 0, flag = 0;
		String filePath = null;
		List<Person> personList;
		FileIO fileOperations = new FileIO();
		DatabaseOperations dataBaseOperations = new DatabaseOperations();
		SearchSortOperations searchSortOperations = new SearchSortOperations();
		AddressBookUtility addressBookUtility = new AddressBookUtility();
		final AddressBookService addressBookService = new AddressBookService();

		System.out.println("Select Below Operations:\n" + "1. Using JSON SAMPLE\n" + "2. Using OPEN CSV\n"
				+ "3. Using MySQL DataBase");
		int option = InputUtil.getIntValue();
		switch (option) {
		case 1:
			filePath = JSON_SIMPLE_FILE_PATH;
			operations = jsonSampleOperation;
			break;
		case 2:
			filePath = OPEN_CSV_FILE_PATH;
			operations = openCSVOperation;
			break;
		case 3:
			break;
		default:
			System.out.println("Invalid Choice!!!");
		}
		while (flag == 0) {
			System.out.println("--- Address Book Management ---\n");
			System.out.println("\t--MENU--");
			System.out.println("1: Add New Person");
			System.out.println("2: Display Records");
			System.out.println("3: Edit Person");
			System.out.println("4: Delete Person");
			System.out.println("5: Sort");
			System.out.println("6: Search");
			System.out.println("7: Exit\n");
			System.out.println("--- Enter Your Choice ---");
			int choice = InputUtil.getIntValue();
			switch (choice) {
			case 1:
				if (option == 3) {
					dataBaseOperations.addRecordToDB();
					break;
				}
				personList = fileOperations.getDataInList(filePath, operations);
				personList = addressBookUtility.addRecord(personList);
				fileOperations.convertToFile(personList, filePath, operations);
				break;
			case 2:
				if (option == 3) {
					List<Person> personDetails = dataBaseOperations.getDataFromDB();
					addressBookService.displayRecord(personDetails);
					break;
				}
				List<Person> person = fileOperations.getDataInList(filePath, operations);
				addressBookService.displayRecord(person);
				break;
			case 3:
				if (option == 3) {
					dataBaseOperations.editPersonDetails();
					break;
				}
				personList = fileOperations.getDataInList(filePath, operations);
				personList = addressBookService.editRecord(personList);
				fileOperations.convertToFile(personList, filePath, operations);

				break;
			case 4:
				if (option == 3) {
					dataBaseOperations.deleteRecord();
					break;
				}
				personList = fileOperations.getDataInList(filePath, operations);
				personList = addressBookUtility.deleteRecord(personList);
				fileOperations.convertToFile(personList, filePath, operations);
				break;
			case 5:
				if (option == 3) {
					searchSortOperations.sortRecords();
					break;
				}
				personList = fileOperations.getDataInList(filePath, operations);
				addressBookUtility.sortRecords(personList);
				break;
			case 6:
				if (option == 3) {
					searchSortOperations.searchInRecords();
					break;
				}
				personList = fileOperations.getDataInList(filePath, operations);
				addressBookUtility.searchInRecords(personList);
				break;
			case 7:
				flag = 1;
				break;
			default:
				System.out.println("Please Enter Valid Option!!!");
			}
		}
	}
}
