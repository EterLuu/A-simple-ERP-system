package pdc.assignment.erp.model.table;

import pdc.assignment.erp.api.Context;
import pdc.assignment.erp.dbo.entity.OrdersEntity;
import pdc.assignment.erp.dbo.service.CustomerServiceImpl;

import javax.swing.table.AbstractTableModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrdersTableModel extends AbstractTableModel implements Serializable {

    private static final long serialVersionUID = -3509664072552202155L;
    private String[] columnNames = {"ID", "Customer", "Outgoing", "Time", "Remark"};
    private final List<Object[]> data = new ArrayList<>();

    public OrdersTableModel(List<OrdersEntity> results) {

        CustomerServiceImpl customerService = new CustomerServiceImpl();

        for (OrdersEntity order : results) {
            Object[] obj = new Object[columnNames.length];
            obj[0] = order.getOid();
            obj[1] = customerService.selectCustomer(order.getCid()).getName();
            obj[2] = order.getPrice() + Context.CURRENCYSYMBOL;
            obj[3] = order.getTime().toLocalDateTime().toString();
            obj[4] = order.getRemark();
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
