
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
	 * created object of AddressBook class and called methods using switch case for
	 * adding, editing, deleting and showing contacts.
	 * 
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

	/**
     * UC-3 To edit contact getting person name and comparing with arraylist,
     * if it is equal then user will able to edit details for that person  
     * 
     */
    
    public void editUser() {
    	
        System.out.println("Enter the Phone No.");
        String personName = scanner.next();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getFirstName().equals(personName) ) {
                PersonInfo temp = personList.get(i);
                do {
                    System.out.println("1: edit Phone Number : ");
                    System.out.println("2: edit Address : ");
                    System.out.println("3: edit City : ");
                    System.out.println("4: edit ZipCode : ");
                    System.out.println("5: edit State : ");
                    System.out.println("6: edit Email : ");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Enter the new Number");
                            temp.setPhoneNumber(scanner.nextLong());
                            break;
                        case 2:
                            System.out.println("Enter the new Address");
                            temp.setAddress(scanner.next());
                            break;
                        case 3:
                            System.out.println("Enter the new city");
                            temp.setCity(scanner.next());
                            break;
                        case 4:
                            System.out.println("Enter the new ZipCode");
                            temp.setZipcode(scanner.nextInt());
                            break;
                        case 5:
                            System.out.println("Enter the new State");
                            temp.setState(scanner.next());
                            break;
                        case 6:
                            System.out.println("Enter the new Email");
                            temp.setEmail(scanner.next());
                            break;
                        default:
                            System.out.println("Enter the correct Input");

                    }
                    System.out.println("If you want to edit more thing than enter true");
                } while (scanner.nextBoolean());
            } 
        } 

    }
    
}
