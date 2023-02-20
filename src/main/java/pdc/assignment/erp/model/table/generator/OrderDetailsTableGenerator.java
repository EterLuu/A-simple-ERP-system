package pdc.assignment.erp.model.table.generator;

import pdc.assignment.erp.dbo.entity.OrderDetailsEntity;
import pdc.assignment.erp.model.table.OrderDetailsTableModel;
import java.util.List;

public class OrderDetailsTableGenerator {

    private OrderDetailsTableGenerator(){
        throw new IllegalStateException("Utility class");
    }

    public static OrderDetailsTableModel get(List<OrderDetailsEntity> list) {
        return new OrderDetailsTableModel(list);
    }
}
