package com.bridgelabz.JavaPractice.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.bridgelabz.JavaPractice.Person;

public class Sort {

	/**
	 * UC-11 To Sort person record by name alphabetically
	 * using java stream
	 * 
	 * @param person
	 */
	public static void sortByName(List<Person> person) {
		Collections.sort(person, Person.firstNameSorting);
		List<Object> sortByName = person.stream().collect(Collectors.toList());
		System.out.println(sortByName);
	}

}
