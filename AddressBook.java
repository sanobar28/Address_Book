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

import java.util.Scanner;
import java.util.regex.Pattern;

public class AddressBook {

	private Person person;
	private int recordId;
	private static int recordCounter = 100;

	/**
	 * Method to validate user input 
	 * @param pattern
	 * @param inputTitle
	 * @return
	 */
	public static String userInputValidation(String pattern, String inputTitle) {
		
		Scanner nameSc = new Scanner(System.in);
		String userInput;
		while (true) {
			System.out.print("Enter " + inputTitle + ": ");
			userInput = nameSc.nextLine();
			if (Pattern.matches(pattern, String.valueOf(userInput))) {
				break;
			}

			else if (inputTitle.equals("Phone Number") || inputTitle.equals("ZIP")) {
				System.out.println("Opps!" + " Invalid " + inputTitle);
			} else {
				System.out.println("Opps! " + inputTitle + " should start with Capital letter and"
						+ " should not contain any space!");
			}
		}
		return userInput;
	}
	
	/**
	 * Methods to add or update person data (first name, last name, phone no., address )
	 * 
	 */

	public void addPerson() {
	
		String pattern = "^[A-Z][a-zA-Z]+$";
		String firstName= AddressBook.userInputValidation(pattern, "First Name");;
		String lastName= AddressBook.userInputValidation(pattern, "Last Name");

		Person personObj = new Person(firstName, lastName);
		this.person = personObj;
	}

	public void updatePersonName(Person personObj) {

		String pattern = "^[A-Z][a-zA-Z]+$";
		String firstName = AddressBook.userInputValidation(pattern, "First Name");
		String lastName = AddressBook.userInputValidation(pattern, "Last Name");
		personObj.setName(firstName, lastName);
	}

	public Person getPerson() {
		return this.person;
	}

	public int getRecordId() {
		return this.recordId;
	}

	public void addPhoneNumber(Person personObj) {
		String pattern = "^(\\+91|91|0)?([6-9]{1}[0-9]{9})$";
		String phoneNumber = AddressBook.userInputValidation(pattern, "Phone Number");
		personObj.setPhoneNumber(phoneNumber);
	}

	public void addAddress(Person personObj) {
		String pattern = "^[A-Z][a-zA-Z]+$";
		String zipPattern = "^[1-9]{1}[0-9]{2}(-| |)[0-9]{3}$";
		String address = AddressBook.userInputValidation(pattern, "Address");
		String city = AddressBook.userInputValidation(pattern, "City");
		String state = AddressBook.userInputValidation(pattern, "State");
		String zip = AddressBook.userInputValidation(zipPattern, "ZIP");

		Address addressObj = new Address(address, city, state, zip);
		personObj.setAddress(addressObj);
	}
	
	/**
	 * UC-5 to add multiple users to Address book
	 * 
	 * @param inputResponse
	 * @return
	 */

	public AddressBook addRecord(Scanner inputResponse) {

		this.addPerson();
		this.recordId = AddressBook.recordCounter;
		AddressBook.recordCounter++;

		System.out.print("Want to skip for now? y/n : ");
		String skipStatus = inputResponse.next();

		if (skipStatus.equals("n")) {
			Person personObj = this.getPerson();
			this.addPhoneNumber(personObj);
			this.addAddress(personObj);
		}
		return this;

	}
}