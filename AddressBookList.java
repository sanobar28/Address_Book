package com.bridgelabz.JavaPractice;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class AddressBookList {

	Scanner nameSc = new Scanner(System.in);
	Scanner phoneSc = new Scanner(System.in);
	Scanner addressSc = new Scanner(System.in);
	private String AddressBookName;
	
	/**
	 *  UC-6 Created Hashmap to store addressbooks and array list to store person records
	 */
	
	static final HashMap<String, AddressBookList> bookList = new HashMap<String, AddressBookList>();
	final ArrayList<AddressBook> addBookList = new ArrayList<>();

	// Created address book key to store unique address book
	
	public AddressBookList(String addressBookKey) {
		this.AddressBookName = addressBookKey;
	}

	public static void welcomeMessage() {
		System.out.println(" Welcome to Address Book System ");
	}

	
	//This Method to add new address book with unique address book key
	
	public static void addNewAddressBook(String addressBookKey, AddressBookList list) {
		AddressBookList.bookList.put(addressBookKey, list);

	}

	// Shows all address book	
	public static boolean ShowAllAddressBooks() {
		boolean flag = false;
		for (Map.Entry<String, AddressBookList> entryObj : bookList.entrySet()) {
			System.out.println(entryObj.getKey());
			flag = true;
		}
		return flag;
	}
	
	// Remove address book by key value
	public static void deleteAddressBook(String key) {
		bookList.remove(key);
	}

	
	public static AddressBookList getAddressBook(String addbookName) {
		return bookList.get(addbookName);
	}

	public void AddRecord(AddressBook addressBook) {
		this.addBookList.add(addressBook);
	}

	/**
	 * Update record is address book
	 */
	public void updateRecord() {

		final Scanner inputResponse = new Scanner(System.in);
		System.out.print("Enter the record ID: ");
		int recordId = inputResponse.nextInt();
		boolean recordFound = false;
		for (final AddressBook addressBook : addBookList) {
			if (addressBook.getRecordId() == recordId) {
				recordFound = true;
				System.out.println("Record updation for " + addressBook.getPerson().getFullName());
				System.out.print(
						"1. Update Name \n2. Update Phone Number \n3. Update Address \n4.Update Phone and Addrees \n5.Update All");
				System.out.print("\nChoose your option: ");

				class SwitchCase {
					void selctOption() {
						int status = inputResponse.nextInt();
						switch (status) {
						case 1:
							addressBook.updatePersonName(addressBook.getPerson());
							break;
						case 2:
							addressBook.addPhoneNumber(addressBook.getPerson());
							break;
						case 3:
							addressBook.addAddress(addressBook.getPerson());
							break;
						case 4:
							addressBook.addPhoneNumber(addressBook.getPerson());
							addressBook.addAddress(addressBook.getPerson());
							break;
						case 5:
							addressBook.updatePersonName(addressBook.getPerson());
							addressBook.addPhoneNumber(addressBook.getPerson());
							addressBook.addAddress(addressBook.getPerson());
							break;
						default:
							System.out.print("Invalid ! Select again :");
							new SwitchCase().selctOption();
							break;
						}
					}
				}

				new SwitchCase().selctOption();
				break;
			}
		}
		if (!recordFound) {
			System.out.println("\nOpps! Record Not Found! ");
		}
	}

	
	/**
	 * To find person details if record exist or not by taking first name as input
	 */
	public void personDetails() {
		Scanner scObj = new Scanner(System.in);
		System.out.print("Enter First Name: ");
		String firstName = scObj.nextLine();
		boolean recordFound = false;
		for (AddressBook addressBook : addBookList) {
			if (addressBook.getPerson().firstName().equals(firstName)) {
				recordFound = true;
				System.out.println("\nDetails of " + addressBook.getPerson().getFullName() + "\n");
				try {
					System.out.println(addressBook.getRecordId() + " " + addressBook.getPerson().getPersonDetails());
				} catch (NullPointerException e) {
					System.out.println(addressBook.getRecordId() + " " + addressBook.getPerson().getFullName() + " --- "
							+ " --- " + " --- " + " --- " + " --- ");
				}
			}
		}
		if (!recordFound) {
			System.out.println("Opps! Record Not Found ");
		}
	}

	/**
	 * To show all Records in address book
	 */
	public void showAllRecords() {
		System.out.println(" - All records are listed bellow - \n");
		boolean emptyFlag = true;
		for (AddressBook addressBook : addBookList) {
			try {
				emptyFlag = false;
				System.out.println(addressBook.getRecordId() + " " + addressBook.getPerson().getPersonDetails());
			} catch (NullPointerException e) {
				System.out.println(addressBook.getRecordId() + " " + addressBook.getPerson().getFullName() + " --- "
						+ " --- " + " --- " + " --- " + " --- ");
			}
		}
		if (emptyFlag) {
			System.out.println(" Address Book is empty! ");
		}
	}
	
	/**
	 * Method to delete record from address book
	 */

	public void deleteRecord() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Want to delete all records: 1=Yes/2=No:  ");
		int status = sc.nextInt();
		if (status == 1) {
			System.out.print("Delete Confirm?: y/n: ");
			String confirmStatus = sc.next();
			if (confirmStatus.equals("y")) {
				addBookList.clear();
				System.out.println("All records has been deleted ! ");
			}
		} else if (status == 2) {
			System.out.print("Enter the record ID: ");
			int id = sc.nextInt();
			for (AddressBook record : addBookList) {
				if (record.getRecordId() == id) {
					System.out.println(record.getRecordId() + " " + record.getPerson().getFullName());
					System.out.print("Delete Confirm?: y/n : ");
					String confirmStatus = sc.next();
					if (confirmStatus.equals("y")) {
						addBookList.remove(record);
						System.out.println(record.getPerson().getFullName() + "'s record has been deleted ! ");
						break;
					}
				}
			}
		} else {
			System.out.println("Sorry! Could not understand your response! ");
			deleteRecord();
		}

	}

	@Override
	public String toString() {
		return this.AddressBookName;
	}

	/**
	 * In main method methods are called according to user input to  add multiple address books 
	 * and address book records
	 * @param args
	 */
	public static void main(String[] args) {

		welcomeMessage();

		Scanner inputResponse = new Scanner(System.in);
		while (true) {
			System.out.println("1. Add new AddreesBook");
			System.out.println("2. Delete AddreesBook");
			System.out.println("3. Goto AddreesBook");
			System.out.print("Enter Your Option: ");

			Scanner inputRes = new Scanner(System.in);
			int chooseSc = inputRes.nextInt();
			AddressBookList bookList = null;
			boolean flag = false;
			if (chooseSc == 1) {
				flag = true;
				System.out.print("\n\nEnter the Address Book Name: ");
				String AddBookNameSc = inputRes.next();
				bookList = new AddressBookList(AddBookNameSc);
				AddressBookList.addNewAddressBook(AddBookNameSc, bookList);
			} else if (chooseSc == 2) {
				AddressBookList.ShowAllAddressBooks();
				System.out.print("\n\nEnter the Address Book Name: ");
				String AddBookNameSc = inputRes.next();
				AddressBookList.deleteAddressBook(AddBookNameSc);
			} else if (chooseSc == 3) {
				if (AddressBookList.ShowAllAddressBooks()) {
					System.out.print("\n\nEnter the Address Book Name: ");
					String AddBookNameSc = inputRes.next();
					bookList = AddressBookList.getAddressBook(AddBookNameSc);
					if (bookList != null) {
						flag = true;
					} else {
						System.out.println("\nSuch AddressBook Not found! Try again!\n");
					}
				} else {
					System.out.println("\nNo Address Book Yet!\n");
				}

			} else {
				System.out.print("\nOpps! Wrong input! Enter again!\n");
			}

			boolean listFlag = false;
			while (flag) {
				if (listFlag)
					break;
				System.out.println("\n\nAddress Book Name: " + bookList);
				System.out.println("\n1. Add Record");
				System.out.println("2. Update Record");
				System.out.println("3. Delete Record");
				System.out.println("4. Person Details");
				System.out.println("5. All Records ");

				System.out.print("Choose Your Option: ");
				int response = inputResponse.nextInt();
				System.out.print("\n\n");

				switch (response) {
				case 1:
					AddressBook addressbook = new AddressBook();
					addressbook.addRecord(inputResponse);
					bookList.AddRecord(addressbook);
					break;
				case 2:
					bookList.updateRecord();
					break;
				case 3:
					bookList.deleteRecord();
					break;
				case 4:
					bookList.personDetails();
					break;
				case 5:
					bookList.showAllRecords();
					break;
				case 6:
					listFlag = true;
					break;
				case 7:
					inputResponse.close();
					System.exit(0);
					break;
				default:
					System.out.println("Sorry! Could not understand. Please choose the correct option!");
					break;

				}
			}
		}
	}
}
