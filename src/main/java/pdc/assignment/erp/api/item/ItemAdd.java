package pdc.assignment.erp.api.item;

import pdc.assignment.erp.dbo.entity.ItemsEntity;
import pdc.assignment.erp.dbo.service.ItemServiceImpl;
import pdc.assignment.erp.util.Judgement;

import java.math.BigDecimal;

public class ItemAdd {

    private ItemAdd(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean itemAdd(String name, String description, BigDecimal price){

        // Prevent SQL injection.
        if(!(Judgement.judgeName(name))){
            return false;
        }
        if(!(Judgement.judgeLongStringWithoutEmpty(description))){
            return false;
        }
        if(!(Judgement.judgeNumber(price.toString()))){
            return false;
        }

        ItemServiceImpl itemService = new ItemServiceImpl();

        if(itemService.selectItem(name)==null) {

            ItemsEntity item = new ItemsEntity();
            item.setName(name);
            item.setDescription(description);
            item.setPrice(price);

            itemService.insertItem(item);

            return true;
        }
        else {
            return false;
        }
    }
}
