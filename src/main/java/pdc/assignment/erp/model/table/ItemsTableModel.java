package pdc.assignment.erp.model.table;

import pdc.assignment.erp.dbo.entity.ItemsEntity;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ItemsTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -1922987555911611568L;
    private String[] columnNames = {"ID", "Name", "Price", "Description"};
    private final List<Object[]> data = new ArrayList<>();

    public ItemsTableModel(List<ItemsEntity> results) {
        for (ItemsEntity item : results) {
            Object[] obj = new Object[columnNames.length];
            obj[0] = item.getIid();
            obj[1] = item.getName();
            obj[2] = item.getPrice();
            obj[3] = item.getDescription();

            data.add(obj);
        }
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}
