package pdc.assignment.erp.model.table.generator;

import pdc.assignment.erp.dbo.entity.CustomersEntity;
import pdc.assignment.erp.dbo.service.CustomerServiceImpl;
import pdc.assignment.erp.dbo.service.ReceiptServiceImpl;
import pdc.assignment.erp.model.table.ReceiptsTableModel;

public class ReceiptsTableGenerator {

    private ReceiptsTableGenerator(){
        throw new IllegalStateException("Utility class");
    }

    public static ReceiptsTableModel searchReceipts() {
        ReceiptServiceImpl receiptService = new ReceiptServiceImpl();

        return new ReceiptsTableModel(receiptService.selectReceipts());
    }

    public static ReceiptsTableModel searchReceipts(String name) {
        ReceiptServiceImpl receiptService = new ReceiptServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        CustomersEntity customer = customerService.selectCustomer(name);

        if(customer != null)
            return new ReceiptsTableModel(receiptService.selectCidReceipts(customer.getCid()));
        else
            return new ReceiptsTableModel(receiptService.selectReceipts());
    }
}
