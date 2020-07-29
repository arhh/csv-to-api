class Main {
    public static void main(String[] args) {
        String CSVFilename = args[0];
        boolean testSuccess;
        testSuccess = testCSVToAPI(CSVFilename);
    }

    private static boolean testCSVToAPI(String csvFile) {
        boolean testSuccess = true;
        CSVToAPI csvAPIInterpreter;
        boolean returnStatus;
        System.out.println("Beginning test of CSVToAPI class...");

        // Pass a CSV file to CSVToAPI object constructor
        csvAPIInterpreter = CSVToAPI.createInterpreter(csvFile);

        // Instruct CSVToAPI object to translate CSV into API calls
        returnStatus = csvAPIInterpreter.translateCSVToAPI();
        // Check if successful. Failed transaltion = False return value

        // Instruct CSVToAPI object to make API calls.
        returnStatus = csvAPIInterpreter.makeAPIRequests();
        // Check if successful. Failed transaltion = False return value

        System.out.println("Finishing CSVToAPI test...");

        return testSuccess;
    }
}
