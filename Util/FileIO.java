package com.bridgelabz.JavaPractice.Util;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
import com.bridgelabz.JavaPractice.Person;

public class FileIO {

	public void convertToFile(LinkedList<Person> addressBook, String filePath, int fileOperations) {

		try (Writer writer = Files.newBufferedWriter(Paths.get(filePath))) {
			StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

			beanToCsv.write(addressBook);
		} catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
			e.printStackTrace();
		}
	}

	public LinkedList<Person> getDataInList(String filePath, int fileOperations) throws IOException {

		LinkedList<Person> addressBook = new LinkedList<>();

		Reader reader = Files.newBufferedReader(Paths.get(filePath));
		CSVReader csvReader = new CSVReader(reader);

		try {
			csvReader.readNext();

			String[] nextPerson;
			while ((nextPerson = csvReader.readNext()) != null) {
				addressBook.add(new Person(nextPerson[2], nextPerson[3], nextPerson[0], nextPerson[1], nextPerson[5],
						nextPerson[6], nextPerson[4]));
			}
		} catch (CsvValidationException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return addressBook;
	}

}
