package com.bridgelabz.JavaPractice.Util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
import com.bridgelabz.JavaPractice.Person;

public class FileIO {

	/**
	 * Write person data into Json or CSV file
	 * @param addressBook
	 * @param filePath
	 * @param fileOperations
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void convertToFile(List<Person> addressBook, String filePath, int fileOperations) throws IOException {
		switch (fileOperations) {
		case 1:
			JSONArray personList = new JSONArray();
			for (Person person : addressBook) {
				JSONObject personDetails = new JSONObject();
				personDetails.put("First Name", person.getFname());
				personDetails.put("Last Name", person.getLname());
				personDetails.put("Phone", person.getPhone());
				personDetails.put("Address", person.getAddress());
				personDetails.put("City", person.getCity());
				personDetails.put("State", person.getState());
				personDetails.put("Zip", person.getZip());
				JSONObject personObject = new JSONObject();
				personObject.put("person", personDetails);
				personList.add(personObject);
			}
			try {
				FileWriter fileWriter = new FileWriter(filePath);
				fileWriter.append(personList.toJSONString());
				fileWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try (Writer writer = Files.newBufferedWriter(Paths.get(filePath))) {
				StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder(writer)
						.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
				beanToCsv.write(addressBook);
			} catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	/**
	 * Method to read person data from Json or CSV file
	 * 
	 * @param filePath
	 * @param fileOperations
	 * @return
	 * @throws IOException
	 * @throws CsvValidationException
	 */
	public List<Person> getDataInList(String filePath, int fileOperations) throws IOException, CsvValidationException {

		List<Person> personDetails = new LinkedList<>();

		switch (fileOperations) {
		case 1:
			JSONParser jsonParser = new JSONParser();
			try {
				FileReader fileReader = new FileReader(filePath);
				Object obj = jsonParser.parse(fileReader);
				JSONArray personList = (JSONArray) obj;
				List<Person> finalPersonDetails = personDetails;
				personList.forEach(person -> finalPersonDetails.add(parseJSONObject((JSONObject) person)));
				personDetails = finalPersonDetails;
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
				csvReader.readNext();
				String[] data;
				while ((data = csvReader.readNext()) != null) {
					personDetails.add(new Person(data[2], data[3], data[0], data[1], data[5], data[6], data[4]));
				}
			}
			break;
		}
		return personDetails;
	}

	/**
	 * Json Object to get person data from json file
	 * 
	 * @param personJson
	 * @return
	 */
	private Person parseJSONObject(JSONObject personJson) {
		JSONObject personObj = (JSONObject) personJson.get("person");
		return new Person((String) personObj.get("First Name"), (String) personObj.get("Last Name"),
				(String) personObj.get("Address"), (String) personObj.get("City"), (String) personObj.get("State"),
				(String) personObj.get("Zip"), (String) personObj.get("Phone"));
	}

}
