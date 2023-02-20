package pdc.assignment.erp.model.table.generator;

import pdc.assignment.erp.dbo.entity.ReceiptDetailsEntity;
import pdc.assignment.erp.model.table.ReceiptDetailsTableModel;

import java.util.List;

public class ReceiptDetailsTableGenerator {

    private ReceiptDetailsTableGenerator(){
        throw new IllegalStateException("Utility class");
    }

    public static ReceiptDetailsTableModel get(List<ReceiptDetailsEntity> list) {
        return new ReceiptDetailsTableModel(list);
    }
}
