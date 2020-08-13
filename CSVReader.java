import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.io.FileNotFoundException;

/*
Brainstorm:
csvreader has a Scanner
It can spit out the fields/columns in a csv file
It always has delimiter = "comma"
*/

public class CSVReader {
    private Scanner rowScanner;
    private String[] columnHeaders;

    private CSVReader(Scanner scanner) {
        rowScanner = scanner.useDelimiter("\n");
        columnHeaders = getColumnHeaders();
    }

    /**
     * Class method to instantiate an instance of CSVReader.
     *
     * @param csvFile A string representing the filename of the CSV
     * @return Instance of CSVReader
     */
    public static CSVReader instantiateCSVReader(String csvFile) {
        CSVReader csvReader = null;
        Scanner scanner = null;

        final File inputFile = new File(csvFile);

        try {
            scanner = new Scanner(inputFile);
        }
        catch (FileNotFoundException e) {
            System.err.println("Could not find input file: " + e.getMessage());
        }

        if (scanner != null) {
            csvReader = new CSVReader(scanner);
        }

        return csvReader;
    }

    /**
     * Get the column headers from the CSV file.
     *
     * Column headers in CSV file are the values in the first row of the CSV file
     *
     * @return String array representing the column headers in CSV file
     */
    public String[] getColumnHeaders() {
        String[] columnHeaders = this.columnHeaders;

        // Only pull the headers from file iff it has not already been done.
        // Saves needless reads to the file, and potential for incorrect data to be returned
        // (i.e. the next row of CSV which is not the column headers)
        if (columnHeaders == null) {
            // The first invocation of getRowValues() will return the column headers
            columnHeaders = getRowValues();
        }

        return columnHeaders;
    }

    /**
     * Get the next row of values from the CSV file
     *
     * This method will generate a map between the column headers and the current row's values.
     *
     * @return HashMap with key = column header, and value = value of field on this particular row
     */
    public HashMap<String, String> getNextFieldValues() {
        HashMap<String, String> fieldValueMap = new HashMap<String, String>();
        String[] fieldValueArray = getRowValues();

        for (int i = 0; i < fieldValueArray.length; i++) {
            fieldValueMap.put(columnHeaders[i], fieldValueArray[i]);
        }

        return fieldValueMap;
    }

    /**
     * Get the next row of values from the CSV file
     *
     * This implementation will iterate to the next row of the CSV file each time it is invoked
     *
     * @return String array of field values for the current row.
     */
    private String[] getRowValues() {
        // Get the next row in the rowscanner
        final String nextRow = rowScanner.nextLine();
        // create another scanner called fieldScanner to scan each value of row
        final Scanner fieldScanner = new Scanner(nextRow).useDelimiter(",");
        // get all values of row using scanner's tokens() method, and use Token's toArray to get
        // an array of Strings
        final String[] rowValues = fieldScanner.tokens().toArray(String[]::new);
        // return the array
        return rowValues;
    }
}
