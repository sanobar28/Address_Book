
/**
 * 
 * @author Sanobar Mujawar
 * @Created_on: 07.06.21
 * 
 * Purpose: Address book system to manage person data and can 
 * add, edit, delete person details.
 * 
 * 
 */

package com.bridgelabz.JavaPractice;

import com.bridgelabz.JavaPractice.model.PersonInfo;
import java.util.*;
import java.util.ArrayList;

public class AddressBook {

	List<PersonInfo> personList = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	
	/**
	 * created object of AddressBook class and called methods using switch case for adding,
	 * editing, deleting and showing contacts. 
	 * @param args
	 */
	
	public static void main(String[] args) {

		System.out.println("Welcome to address book system");
		AddressBook addressbook = new AddressBook();

		boolean isExit = false;
		while (!isExit) {

			System.out.println("Enter options\n1.Add\n2.Edit\n3.Delete\n4.Show contacts\n5.Exit");
			int userInput = scanner.nextInt();
			switch (userInput) {
			case 1:
				addressbook.addPerson();
				break;
			case 2:
				addressbook.editUser();
				break;
			case 3:
				addressbook.deleteUser();
				break;
			case 4:
				addressbook.showContacts();
				break;
			case 5:
				isExit = true;
				break;
			default:
				System.out.println("Please enter valid input");
			}
		}
	}
	
	/**
	 * UC-2 to add new person info to address book 
	 * 
	 */
	
	private void addPerson() {

		PersonInfo person = new PersonInfo();
		System.out.println("Enter First Name: ");
		person.setFirstName(scanner.next());

		System.out.println("Enter Last Name : ");
		person.setLastName(scanner.next());

		System.out.println("Enter the Address : ");
		person.setAddress(scanner.next());

		System.out.println("Enter the City : ");
		person.setCity(scanner.next());

		System.out.println("Enter the State : ");
		person.setState(scanner.next());

		System.out.println("Enter Email : ");
		person.setEmail(scanner.next());

		System.out.println("Enter ZipCode : ");
		person.setZipcode(scanner.nextInt());

		System.out.println("Enter Phone Number: ");
		person.setPhoneNumber(scanner.nextLong());
		personList.add(person);

	}

}
