/**
 * @author Sanobar Mujawar
 * @since 22.06.21
 * 
 * This is service class for searching record
 * in address book system.
 * 
 * 
 */

package com.bridgelabz.JavaPractice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bridgelabz.JavaPractice.Person;
import com.bridgelabz.JavaPractice.Util.InputUtil;

public class Search {

	/**
	 * UC-8 To search person record by city name UC-10 gives count of records found
	 * for given city
	 * 
	 * @param person
	 */
	public static void searchByCity(List<Person> person) {
		String search;
		List<Person> matches = new ArrayList<>();
		System.out.println("Enter city name : ");
		search = InputUtil.getStringValue();
		int flag = 0;
		for (Person p : person) {
			if (p.getCity().equalsIgnoreCase(search)) {
				flag = 1;
				matches.add(p);
			}
		}
		if (flag == 1) {

			List<Object> searchByCity = matches.stream().collect(Collectors.toList()); //stream to collect matches for given city
			System.out.println(searchByCity);
			System.out.println("Found " + searchByCity.size() + " number of records"); //for counting no of records with given city
																				
		} else {
			System.out.println("Match Not Found!!!");
		}
	}

	/**
	 * UC-8 To search Person record by state name 
	 * UC-10 gives count of records found using java stream
	 * for given state
	 * 
	 * @param person
	 */
	public static void searchByState(List<Person> person) {
		String search;
		int flag = 0;
		List<Person> matches = new ArrayList<>();
		System.out.println("Enter state name : ");
		search = InputUtil.getStringValue();
		for (Person p : person) {
			if (p.getState().equalsIgnoreCase(search)) {
				flag = 1;
				matches.add(p);
			}
		}
		if (flag == 1) {
			List<Object> searchByState = matches.stream().collect(Collectors.toList()); //stream to collect matches for given city
			System.out.println(searchByState);
			System.out.println("Found " + searchByState.size() + " number of records"); // for counting no of records with given state																				
		} else {
			System.out.println("Match Not Found!!!");
		}
	}

}
