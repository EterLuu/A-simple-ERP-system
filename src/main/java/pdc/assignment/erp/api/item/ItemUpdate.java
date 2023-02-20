package pdc.assignment.erp.api.item;

import pdc.assignment.erp.dbo.entity.ItemsEntity;
import pdc.assignment.erp.dbo.service.ItemServiceImpl;
import pdc.assignment.erp.util.Judgement;

import java.math.BigDecimal;

public class ItemUpdate {

    private ItemUpdate(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean updateItem(int iid, String name, String description, BigDecimal price) {

        // Prevent SQL injection.
        if(!(Judgement.judgeString(name))){
            return false;
        }
        if(!(Judgement.judgeLongStringWithoutEmpty(description))){
            return false;
        }
        if(!(Judgement.judgeNumber(price.toString()))){
            return false;
        }

        ItemServiceImpl itemService = new ItemServiceImpl();

        ItemsEntity item = itemService.selectItem(iid);

        if(item == null)
            return false;
        
        if (item.getName().equals(name)){
            ItemsEntity temp = itemService.selectItem(name);
            if(temp!=null){
                if(temp.getIid()!=iid){
                    return false;
                }
            }
            else{
                item.setName(name);
            }
        }
        else {
            item.setName(name);
        }

        item.setPrice(price);
        item.setDescription(description);

        itemService.updateItem(item);

        return true;
    }
}
