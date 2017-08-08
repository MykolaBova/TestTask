package task2version2;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private static final int ADDITIONAL_SPACES = 2;
    private List<Column> table;

    public Table(int size) {
        this.table = new ArrayList<>(size);
        for (int i=0; i<size; i++){
            table.add(new Column());
        }
    }

    public Column getColumn(int index) {
        return table.get(index);
    }

    public void printTable (){
        if (table == null) throw new IllegalArgumentException("Table is empty");

        printTitle();
        int numberOfRows = table.get(0).getSize();
        for (int i = 1; i<numberOfRows ;i++){
            printRow(i);
        }
    }

    private void printTitle(){
        for (Column column : table){
            String formatTemplate = "%"+(ADDITIONAL_SPACES+column.getMaxSize())+"s |";
            System.out.print(String.format(formatTemplate, column.getTitle()));
        }
        System.out.println();
    }

    private void printRow(int index){
        for (Column column : table){
            String formatTemplate = "%"+(ADDITIONAL_SPACES+column.getMaxSize())+"s |";
            System.out.print(String.format(formatTemplate, column.getData(index)));
        }
        System.out.println();
    }


}
