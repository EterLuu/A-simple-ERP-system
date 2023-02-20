package pdc.assignment.erp.model.table;

import pdc.assignment.erp.dbo.entity.UsersEntity;

import javax.swing.table.AbstractTableModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsersTableModel extends AbstractTableModel implements Serializable {

    private static final long serialVersionUID = -7344318065344668192L;
    private String[] columnNames = {"ID", "Username", "Role"};
    private final List<Object[]> data = new ArrayList<>();

    public UsersTableModel(List<UsersEntity> results) {
        for (UsersEntity user : results) {
            Object[] obj = new Object[columnNames.length];
            obj[0] = user.getUid();
            obj[1] = user.getUsername();
            obj[2] = user.getRole();

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
