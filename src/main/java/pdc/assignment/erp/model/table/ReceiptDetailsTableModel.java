package pdc.assignment.erp.model.table;

import pdc.assignment.erp.dbo.entity.ReceiptDetailsEntity;
import pdc.assignment.erp.dbo.service.BankaccountServiceImpl;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ReceiptDetailsTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -9112964488698160885L;
    private String[] columnNames = {"Bank Account", "Balance", "Remark"};
    private final List<Object[]> data = new ArrayList<>();

    public ReceiptDetailsTableModel(List<ReceiptDetailsEntity> results) {

        BankaccountServiceImpl bankaccountService = new BankaccountServiceImpl();

        for (ReceiptDetailsEntity detail : results) {
            Object[] obj = new Object[columnNames.length];
            obj[0] = bankaccountService.selectBankAccount(detail.getBid()).getName();
            obj[1] = detail.getBalance().toString();
            obj[2] = detail.getRemark();
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
