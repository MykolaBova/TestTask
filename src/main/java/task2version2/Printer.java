package task2version2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Printer {
    private static final String DELIMITER = ";";

    /**
     * Static helper method for read CSV file by its location.
     * This is dynamic method and can make table from any CSV file
     * @param pathToFile path to file should be absolute
     * @return Table
     */
    public static Table readCsvFile (String pathToFile){

        Table table = null;
        String line;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(pathToFile))){

            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(DELIMITER);

                //if table not exist create new with number of columns
                if (table == null) {
                    table = new Table(tokens.length);
                }

                if (tokens.length > 0) {
                    for(int i=0; i<tokens.length; i++){
                        table.getColumn(i).addData(tokens[i]);
                        //Check max size of column
                        if (tokens[i].length() > table.getColumn(i).getMaxSize()){
                            table.getColumn(i).setMaxSize(tokens[i].length());
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
        //File file = new File("src/main/resources/sample.csv");
        File file = new File(args[0]);
        String pathToFile = file.getAbsolutePath();
        Table records = readCsvFile(pathToFile);
        if (records != null){
            records.printTable();
        }
    }
}
