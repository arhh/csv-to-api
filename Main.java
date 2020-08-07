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

        // Get the field names of the CSV file.
        final HashMap<String, String> suTTestA = suT.getNextFieldValues();
        // print the output of above method
        System.out.println(suTTestA.toString());

        System.out.println("\n\nFinishing CSVReader test...");

        return testSuccess;
    }
}
