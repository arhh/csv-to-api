import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        String CSVFilename = args[0];
        boolean testSuccess;
        testSuccess = testCSVReader(CSVFilename);
        System.out.println("Test status: " + testSuccess);
    }

    private static boolean testCSVReader(String csvFile) {
        boolean testSuccess = true;
        CSVReader suT;
        System.out.println("Beginning test of CSVReader class...\n\n");

        // Pass a CSV file to CSVReader object constructor
        suT = CSVReader.instantiateCSVReader(csvFile);

        // Get the column headers in the CSV file
        final String[] testCSVColumnHeadersA = suT.getColumnHeaders();
        for (String header : testCSVColumnHeadersA) { System.out.println(header); }

        // Get the next row of fields of the CSV file.
        final HashMap<String, String> suTTestA = suT.getNextFieldValues();
        System.out.println(suTTestA.toString());

        // Get the column headers in the CSV file
        final String[] testCSVColumnHeadersB = suT.getColumnHeaders();
        for (String header : testCSVColumnHeadersB) { System.out.println(header); }

        // Get the next row of fields of the CSV file.
        final HashMap<String, String> suTTestB = suT.getNextFieldValues();
        System.out.println(suTTestB.toString());

        // Get the column headers in the CSV file
        final String[] testCSVColumnHeadersC = suT.getColumnHeaders();
        for (String header : testCSVColumnHeadersC) { System.out.println(header); }

        System.out.println("\n\nFinishing CSVReader test...");

        return testSuccess;
    }
}
