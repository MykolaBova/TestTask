package task2version1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PrettyPrinter {
    //Delimiter used in CSV file
    private static final String DELIMITER = ";";

    //Record attributes index
    private static final int RECORD_ID = 0;
    private static final int RECORD_TYPE = 1;
    private static final int RECORD_DESCRIPTION = 2;
    private static final int RECORD_APPROVED = 3;
    private static final int RECORD_AMOUNT = 4;
    private static final int RECORD_CURRENCY = 5;

    /**
     * Static helper method for read CSV file by its location.
     * @param pathToFile path to file should be absolute
     * @return List of Record
     */
    public static List<Record> readCsvFile (String pathToFile){

        //Create a new list of records to be filled by CSV file data
        List<Record> records = new ArrayList();
        String line;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(pathToFile))){

            //Read the CSV file header to skip it
            fileReader.readLine();

            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(DELIMITER);
                if (tokens.length > 0) {
                    //Create a new Record
                    Record record = new Record();
                    record.setId(Long.parseLong(tokens[RECORD_ID]));
                    record.setType(tokens[RECORD_TYPE]);
                    record.setDescription(tokens[RECORD_DESCRIPTION]);
                    record.setApproved(Boolean.parseBoolean(tokens[RECORD_APPROVED]));

                    NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                    Number number = format.parse(tokens[RECORD_AMOUNT]);
                    double amount = number.doubleValue();
                    record.setAmount(amount);

                    record.setCurrency(tokens[RECORD_CURRENCY]);

                    records.add(record);
                }
            }
        } catch (Exception e) {
            System.out.println("Error in CSVFileReader");
            e.printStackTrace();
        }
        return records;
    }

    /**
     * Method print table of records to console
     * @param records List of records to be printed
     */
    public static void printReportToConsole(List<Record> records){
        String title1 = "----------------------------------------------------------------------------------------";
        String title2 = "|     id     | Type |          Description          | IsApproved |   Amount   |Currency|";
        System.out.println(title1);
        System.out.println(title2);
        System.out.println(title1);

        for (Record record : records){
            System.out.format("|%11d |", record.getId());
            System.out.print(String.format("%5s |", record.getType()));
            System.out.print(String.format("%30s |", record.getDescription()));
            System.out.print(String.format("%10s  |", record.isApproved()));
            System.out.format("%11.2f |", record.getAmount());
            System.out.print(String.format("%6s  |%n", record.getCurrency()));
        }
        System.out.println(title1);
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/report2017.csv");
        String pathToFile = file.getAbsolutePath();
        List<Record> records = readCsvFile(pathToFile);
        printReportToConsole(records);
    }
}