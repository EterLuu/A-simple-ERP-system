package pdc.assignment.erp.api.item;

import pdc.assignment.erp.dbo.entity.ItemsEntity;
import pdc.assignment.erp.dbo.service.ItemServiceImpl;

public class ItemDelete {

    private ItemDelete(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean itemDelete(int iid){

        ItemServiceImpl itemService = new ItemServiceImpl();

        ItemsEntity item = itemService.selectItem(iid);

        if (item == null)
            return false;

        return itemService.deleteItem(item);
    }
}
