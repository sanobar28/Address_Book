package com.bridgelabz.JavaPractice.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.bridgelabz.JavaPractice.Person;

public class Sort {

	/**
	 * UC-11 To Sort person record by name alphabetically using java stream
	 * 
	 * @param person
	 */
	public static void sortByName(List<Person> person) {
		Collections.sort(person, Person.firstNameSorting);
		List<Object> sortByName = person.stream().collect(Collectors.toList());
		System.out.println(sortByName);
	}

	/**
	 * UC-12 To Sort Records by city, state or zip using java stream
	 * 
	 * @param person
	 */
	public static void sortByCity(List<Person> person) {
		Collections.sort(person, Person.citySorting);
		List<Object> sortByCity = person.stream().collect(Collectors.toList());
		System.out.println(sortByCity);
	}

	public static void sortByState(List<Person> person) {
		Collections.sort(person, Person.stateSorting);
		List<Object> sortByState = person.stream().collect(Collectors.toList());
		System.out.println(sortByState);
	}

	public static void sortByZip(List<Person> person) {
		Collections.sort(person, Person.zipSorting);
		List<Object> sortByZip = person.stream().collect(Collectors.toList());
		System.out.println(sortByZip);
	}

}
