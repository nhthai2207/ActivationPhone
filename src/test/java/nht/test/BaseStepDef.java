package nht.test;

import cucumber.api.DataTable;

import java.util.List;
import java.util.Map;

public class BaseStepDef {
    public int getNumberOfRows(DataTable table) {
        List<Map<String, String>> hashes = table.asMaps(String.class, String.class);
        return hashes.size();
    }
    public Map<String, String> getRow(DataTable table, int rowIndex) {
        List<Map<String, String>> hashes = table.asMaps(String.class, String.class);

        return hashes.get(rowIndex);
    }

    public List<String> getHeaderRow(DataTable table) {
        return table.topCells();
    }

    public String getValues(DataTable table, int rowIndex, String column) {
        Map<String, String> properties = getRow(table, rowIndex);
        return properties.get(column);
    }
}
