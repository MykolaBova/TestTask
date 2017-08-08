package task2version2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Printer {
    private static final String DELIMITER = ";";

    public static Table readCsvFile (String pathToFile){

        Table table = null;
        String line;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(pathToFile))){

            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(DELIMITER);

                if (table == null) {
                    table = new Table(tokens.length);
                }

                if (tokens.length > 0) {
                    for(int i=0; i<tokens.length; i++){
                        table.getColumn(i).addData(tokens[i]);
                        if (tokens[i].length() > table.getColumn(i).getRowLength()){
                            table.getColumn(i).setRowLength(tokens[i].length());
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error in CSVFileReader");
            e.printStackTrace();
        }
        return table;
    }

    public static void main(String[] args) {
        //File file = new File("src/main/resources/report2017.csv");
        File file = new File("src/main/resources/sample.csv");
        String pathToFile = file.getAbsolutePath();
        Table records = readCsvFile(pathToFile);
        if (records != null){
            records.printTable();
        }
    }
}
