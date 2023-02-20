package pdc.assignment.erp.model.table;

import pdc.assignment.erp.dbo.entity.CustomersEntity;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CustomersTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -5738442966080399822L;
    private String[] columnNames = {"ID", "Name", "Telephone", "Address", "Fax", "Remark"};
    private final List<Object[]> data = new ArrayList<>();

    public CustomersTableModel(List<CustomersEntity> results) {
        for (CustomersEntity customer : results) {
            Object[] obj = new Object[columnNames.length];
            obj[0] = customer.getCid();
            obj[1] = customer.getName();
            obj[2] = customer.getTelephone();
            obj[3] = customer.getAddress();
            obj[4] = customer.getFax();
            obj[5] = customer.getRemark();

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
