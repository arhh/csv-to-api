public class CSVToAPI {
    private CSVToAPI(String csvFile);

    public static CSVToAPI createInterpreter(String csvFile);

    private boolean translateCSVToAPI();

    private boolean makeAPIRequests();
}
