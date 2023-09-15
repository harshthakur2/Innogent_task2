import com.opencsv.CSVReader;

import java.io.Closeable;
import java.io.FileReader;
import java.util.List;

public class First{
    public static void main(String[] args) {
        // Define the pin code you want to filter by
        String pinCodeToFilter = "482002";

        try {
            // Create a CSV reader
            CSVReader reader = new CSVReader(new FileReader("address.csv"));

            // Read all rows from the CSV file
            List<String[]> allRows = reader.readAll();

            // Iterate through the rows and filter based on the pin code
            for (String[] row : allRows) {
                if (row.length >= 2 && row[1].equals(pinCodeToFilter)) {
                    // Print the entire row or access specific columns as needed
                    System.out.println("Student ID: " + row[0]);
                    System.out.println("Pin Code: " + row[1]);
                    System.out.println("City: " + row[2]);
                    System.out.println("Student ID: " + row[3]);
                }
            }

            // Close the CSV reader
            ((Closeable) reader).close();
        } catch (Exception e) {
            ((Throwable) e).printStackTrace();
        }
    }
}
