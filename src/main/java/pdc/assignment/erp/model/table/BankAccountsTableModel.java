package pdc.assignment.erp.model.table;

import pdc.assignment.erp.dbo.entity.BankAccountsEntity;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class BankAccountsTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 529916705612423703L;
    private String[] columnNames = {"ID", "Account Name", "Card"};
    private final List<Object[]> data = new ArrayList<>();

    public BankAccountsTableModel(List<BankAccountsEntity> results) {
        for (BankAccountsEntity account : results) {
            Object[] obj = new Object[columnNames.length];
            obj[0] = account.getBid();
            obj[1] = account.getName();
            obj[2] = account.getCard();

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
