package com.bridgelabz.JavaPractice;

import java.util.ArrayList;
import java.util.Scanner;

import com.bridgelabz.JavaPractice.Util.InputUtil;
import com.bridgelabz.JavaPractice.service.Search;
import com.bridgelabz.JavaPractice.service.Sort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Helper {

	// GLOBAL LIST TO STORE PERSON RECORD
	List<Person> PERSON = new ArrayList<Person>();

	/**
	 * UC-2 To add Record in address Book
	 * 
	 */
	public void addRecord() {
		int i = 0;
		String fname = null;
		final String lname, address, city, state, phone, zip;
		while (i == 0) {
			System.out.print("Enter First Name : ");
			fname = InputUtil.getStringValue();
			if (checkExists(fname)) {
				System.out.println("Person Name Already Exists!!\nPlease enter different name...");
			} else {
				i = 1;
			}
		}
		System.out.print("Enter Last Name : ");
		lname = InputUtil.getStringValue();
		System.out.print("Enter Phone Number : ");
		phone = InputUtil.getStringValue();
		System.out.print("Enter Address : ");
		address = InputUtil.getStringValue();
		System.out.print("Enter city : ");
		city = InputUtil.getStringValue();
		System.out.print("Enter zip : ");
		zip = InputUtil.getStringValue();
		System.out.print("Enter state : ");
		state = InputUtil.getStringValue();

		PERSON.add(new Person(fname, lname, address, city, state, phone, zip));
	}

	/**
	 * Method to display record in address book
	 * 
	 */
	public void displayRecord() {
		if (PERSON.isEmpty()) {
			System.out.println("No Records!!!");
		} else {
			for (Person person : PERSON) {
				System.out.println(person);
			}
		}

	}

	/**
	 * UC-3 Method to edit record in the address book
	 * 
	 */
	public void editRecord() {
		int id, choice = 0, i = 0;
		String fname, lname, address, city, state, phone, zip;
		for (Person person : PERSON) {
			System.out.println("ID: #" + PERSON.indexOf(person) + " : " + person);
		}
		System.out.print("\nEnter #ID to Edit Contact : ");
		id = InputUtil.getIntValue();
		System.out.println(PERSON.get(id));
		while (i == 0) {
			System.out.println("What You Want to edit...\n" + "\t1: Address\n" + "\t2: city\n" + "\t3: State\n"
					+ "\t4: Phone\n" + "\t5: Zip Code\n" + "\t6. Save And Exit\n");
			choice = InputUtil.getIntValue();
			switch (choice) {
			case 1:
				System.out.print("Enter new Address : ");
				address = InputUtil.getStringValue();
				PERSON.get(id).setAddress(address);
				break;
			case 2:
				System.out.print("Enter new City : ");
				city = InputUtil.getStringValue();
				PERSON.get(id).setCity(city);
				break;
			case 3:
				System.out.print("Enter new State : ");
				state = InputUtil.getStringValue();
				PERSON.get(id).setState(state);
				break;
			case 4:
				System.out.print("Enter new Phone : ");
				phone = InputUtil.getStringValue();
				PERSON.get(id).setPhone(phone);
				break;
			case 5:
				System.out.print("Enter new Zip Code : ");
				zip = InputUtil.getStringValue();
				PERSON.get(id).setZip(zip);
				break;
			case 6:
				i = 1;
				break;
			default:
				System.out.println("Please Enter Valid Option");
			}
			System.out.println(PERSON.get(id));
		}
	}

	/**
	 * UC-4 Method to delete person record from address book
	 * 
	 */
	public void deleteRecord() {
		int id;
		for (Person p : PERSON) {
			System.out.println("ID: #" + PERSON.indexOf(p) + " : " + p);
		}
		System.out.print("\nEnter #ID to delete Contact : ");
		id = InputUtil.getIntValue();
		PERSON.remove(id);
	}

	/**
	 * UC-7 Check if Person record already exist by using equals
	 * 
	 * @param fname
	 * @return
	 */
	public boolean checkExists(String fname) {
		int flag = 0;
		for (Person p : PERSON) {
			if (p.getFname().equals(fname)) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return true;
		}
		return false;
	}

	/**
	 * UC-9 View person records by person city or person state
	 * 
	 */
	public void searchInRecords() {
		int i = 0;
		while (i == 0) {
			System.out.println("1. Search By City\n" + "2. Search By State\n" + "3. Back\n" + "Choose Your Option");
			int choice = InputUtil.getIntValue();
			switch (choice) {
			case 1:
				Search.searchByCity(PERSON);
				break;
			case 2:
				Search.searchByState(PERSON);
				break;
			case 3:
				i = 1;
				break;
			default:
				System.out.println("Please Enter Correct Option...");
			}
		}
	}

	/**
	 * UC-11 This Method will Sort the Address book by Name UC-12 This Method will
	 * Sort the Address book by Name, city, state, zip
	 */
	public void sortRecords() {
		System.out.println("Sort By...\n" + "1: First Name\n" + "2: City\n" + "3: State\n" + "4: Zip Code\n" + "5: Back");
		int choice = InputUtil.getIntValue();
		switch (choice) {
		case 1:
			Sort.sortByName(PERSON);
			break;
		case 2:
			Sort.sortByZip(PERSON);
			break;
		case 3:
			Sort.sortByState(PERSON);
			break;
		case 4:
			Sort.sortByZip(PERSON);
			break;
		case 5:
			return;
		default:
			System.out.println("Please Enter Valid Option...");
		}
	}

}
