package pdc.assignment.erp.model.table.generator;

import pdc.assignment.erp.dbo.service.ItemServiceImpl;
import pdc.assignment.erp.model.table.ItemsTableModel;
import pdc.assignment.erp.util.Judgement;

public class ItemsTableGenerator {

    private ItemsTableGenerator(){
        throw new IllegalStateException("Utility class");
    }

    private static ItemServiceImpl itemService = new ItemServiceImpl();

    public static ItemsTableModel searchItem(String name) {

        // Prevent SQL injection.
        if(!Judgement.judgeName(name)){
            return new ItemsTableModel(itemService.selectItems());
        }

        return new ItemsTableModel(itemService.selectItems(name));
    }

    public static ItemsTableModel searchItem() {

        return new ItemsTableModel(itemService.selectItems());
    }
}
