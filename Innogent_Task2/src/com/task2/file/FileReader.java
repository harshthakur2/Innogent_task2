package com.task2.file;
import java.io.*;

public class FileReader {

	public static void main(String[] args) {
		try (FileReader reader = new FileReader("class.csv");
			     CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

			    for (CSVRecord csvRecord : csvParser) {
			        // Access each column by index or name
			        String column1 = csvRecord.get(0); // First column
			        String column2 = csvRecord.get(1); // Second column

			        // Apply your operations here
			        // Example: Print the values of the first and second columns
			        System.out.println("Column 1: " + column1);
			        System.out.println("Column 2: " + column2);
			    }
			} catch (IOException e) {
			    e.printStackTrace();
			}

	}

}
