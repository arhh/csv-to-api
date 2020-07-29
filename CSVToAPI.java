public class CSVToAPI {
    private CSVToAPI(String csvFile) {

    }

    public static CSVToAPI createInterpreter(String csvFile) {
        CSVToAPI interpreter = null;

        interpreter = new CSVToAPI(csvFile);

        return interpreter;
    }

    public boolean translateCSVToAPI() {
        return true;
    }

    public boolean makeAPIRequests() {
        return true;
    }

    public String getCSV() {
        return null;
    }

    public String getAPICalls() {
        return null;
    }
}
