package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PrettyPrinter {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ";";

    //Record attributes index
    private static final int RECORD_ID = 0;
    private static final int RECORD_TYPE = 1;
    private static final int RECORD_DESCRIPTION = 2;
    private static final int RECORD_APPROVED = 3;
    private static final int RECORD_AMOUNT = 4;
    private static final int RECORD_CURRENCY = 5;

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
                String[] tokens = line.split(COMMA_DELIMITER);
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

    public static void printReportToConsole(List<Record> records){
        String title1 = "--------------------------------------------------------------------------------";
        String title2 = "|    id    | Type |       Description       | IsApproved |   Amount   |Currency|";
        String title3 = "--------------------------------------------------------------------------------";



    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/report2017.csv");
        String pathToFile = file.getAbsolutePath();
        List<Record> records = readCsvFile(pathToFile);

        //Print the new record list
        for (Record record : records) {
            System.out.println(record.toString());
        }
    }
}