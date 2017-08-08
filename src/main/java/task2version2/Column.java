package task2version2;

import java.util.ArrayList;
import java.util.List;

public class Column {
    private int rowLength;
    private List<String> dataArray = new ArrayList<>();

    public int getMaxSize() {
        return rowLength;
    }

    public void setMaxSize(int rowLength) {
        this.rowLength = rowLength;
    }

    public List<String> getDataArray() {
        return dataArray;
    }

    public void addData(String data) {
        this.dataArray.add(data);
    }

    public String getData (int index){
        return dataArray.get(index);
    }

    public String getTitle(){
        return dataArray.get(0);
    }

    public int getSize() {
        return dataArray.size();
    }
}
