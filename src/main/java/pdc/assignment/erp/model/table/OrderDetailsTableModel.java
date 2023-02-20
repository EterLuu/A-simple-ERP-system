package pdc.assignment.erp.model.table;

import pdc.assignment.erp.api.Context;
import pdc.assignment.erp.dbo.entity.OrderDetailsEntity;
import pdc.assignment.erp.dbo.service.ItemServiceImpl;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -9112964488698160885L;
    private String[] columnNames = {"Item", "Number", "Price", "Total Price", "Remark"};
    private final List<Object[]> data = new ArrayList<>();

    public OrderDetailsTableModel(List<OrderDetailsEntity> results) {

        ItemServiceImpl itemService = new ItemServiceImpl();

        for (OrderDetailsEntity detail : results) {
            Object[] obj = new Object[columnNames.length];
            obj[0] = itemService.selectItem(detail.getIid()).getName();
            obj[1] = detail.getNumber().toString();
            obj[2] = detail.getPrice().toString() + Context.CURRENCYSYMBOL;
            obj[3] = detail.getTotalPrice().toString() + Context.CURRENCYSYMBOL;
            obj[4] = detail.getRemark();
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
