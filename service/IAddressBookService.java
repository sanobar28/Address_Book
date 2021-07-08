package com.bridgelabz.JavaPractice.service;

import java.util.List;

import com.bridgelabz.JavaPractice.Person;
import com.bridgelabz.JavaPractice.exception.AddressBookException;

public interface IAddressBookService {


    List<Person> addRecord(List<Person> personList, Person person);

    List<Person> editRecord(List<Person> person) throws AddressBookException;

    void displayRecord(List<Person> person);

    List<Person> deleteRecord(List<Person> personList, int id) throws AddressBookException;
}
