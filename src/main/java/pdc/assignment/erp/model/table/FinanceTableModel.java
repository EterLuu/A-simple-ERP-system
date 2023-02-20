package pdc.assignment.erp.model.table;

import pdc.assignment.erp.dbo.entity.CustomersEntity;
import pdc.assignment.erp.dbo.entity.OrdersEntity;
import pdc.assignment.erp.dbo.entity.ReceiptsEntity;
import pdc.assignment.erp.dbo.service.CustomerServiceImpl;
import pdc.assignment.erp.dbo.service.OrderServiceImpl;
import pdc.assignment.erp.dbo.service.ReceiptServiceImpl;

import javax.swing.table.AbstractTableModel;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FinanceTableModel extends AbstractTableModel implements Serializable {

    private static final long serialVersionUID = -3509664072552202155L;
    private String[] columnNames = {"Customer", "Outgoing", "Incoming", "Total outgoing and incoming"};
    private final List<Object[]> data = new ArrayList<>();

    public FinanceTableModel() {

        CustomerServiceImpl customerService = new CustomerServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();
        ReceiptServiceImpl receiptService = new ReceiptServiceImpl();

        List<CustomersEntity> results = customerService.selectCustomers();

        for(CustomersEntity customer : results){
            Object[] obj = new Object[columnNames.length];
            obj[0] = customer.getName();

            List<OrdersEntity> orders = orderService.selectCidOrders(customer.getCid());

            BigDecimal outGoing = new BigDecimal(0);
            BigDecimal inComing = new BigDecimal(0);

            for(OrdersEntity order : orders) {
                outGoing = outGoing.add(order.getPrice());
            }

            List<ReceiptsEntity> receipts = receiptService.selectCidReceipts(customer.getCid());

            for(ReceiptsEntity receipt : receipts) {
                inComing = inComing.add(receipt.getBalance());
            }

            BigDecimal total = new BigDecimal(0);

            total = inComing.subtract(outGoing);

            obj[1] = outGoing.toString();
            obj[2] = inComing.toString();
            obj[3] = total.toString();

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
