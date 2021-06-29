/**
 * 
 * @author Sanobar Mujawar
 * @Created_on: 07.06.21
 * 
 * Purpose: Address book system to manage person data and can 
 * add, edit, delete person details.
 * 
 */

package com.bridgelabz.JavaPractice;

import java.io.IOException;
import java.util.LinkedList;
import com.bridgelabz.JavaPractice.Util.FileIO;
import com.bridgelabz.JavaPractice.Util.InputUtil;
import com.bridgelabz.JavaPractice.exception.AddressBookException;
import com.bridgelabz.JavaPractice.service.AddressBookService;

public class AddressBook {

	// main
	public static void main(String[] args) throws AddressBookException, IOException {

		int choice, i = 0;
		final String OPEN_CSV_FILE_PATH = "C:\\Users\\User\\eclipse-workspace\\JavaPractice\\src\\main\\resources\\CSVAddressBook.csv";
		LinkedList<Person> personList;
		FileIO fileOperations = new FileIO(); //fileoperation object
		
		final AddressBookService addressBookService = new AddressBookService();
		final int openCSVOperation = 1;
		int operations = 0;

		String filePath = OPEN_CSV_FILE_PATH;
		operations = openCSVOperation;

		while (i == 0) {
			System.out.println("--- Address Book Management ---\n");
			System.out.println("\t--MENU--");
			System.out.println("1: Add New Person      ");
			System.out.println("2: Display Records     ");
			System.out.println("3: Edit Person     ");
			System.out.println("4: Delete Person     ");
			System.out.println("5: Search Record   ");
			System.out.println("6: Sort Records    ");
			System.out.println("7: Exit		       \n");
			System.out.println("--- Enter Your Choice ---");

			choice = InputUtil.getIntValue();
			switch (choice) {
			case 1:
				personList = fileOperations.getDataInList(filePath, operations);
				personList = addressBookService.addRecord(personList);
				fileOperations.convertToFile(personList, filePath, operations);
				break;
			case 2:
				LinkedList<Person> person = fileOperations.getDataInList(filePath, operations);
				addressBookService.displayRecord(person);
				break;
			case 3:
				personList = fileOperations.getDataInList(filePath, operations);
				personList = addressBookService.editRecord(personList);
				fileOperations.convertToFile(personList, filePath, operations);

				break;
			case 4:
				personList = fileOperations.getDataInList(filePath, operations);
				personList = addressBookService.deleteRecord(personList);
				fileOperations.convertToFile(personList, filePath, operations);
				break;
			case 5:
				personList = fileOperations.getDataInList(filePath, operations);
				addressBookService.sortRecords();
				break;
			case 6:
				personList = fileOperations.getDataInList(filePath, operations);
				addressBookService.searchInRecords(personList);
				break;
			case 7:
				i = 1;
				break;
			default:
				System.out.println("Please Enter Valid Option!!!");
			}
		}
	}
}
