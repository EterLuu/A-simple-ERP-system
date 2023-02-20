package pdc.assignment.erp.api.item;

import org.junit.jupiter.api.Test;
import pdc.assignment.erp.dbo.service.ItemServiceImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void itemAdd() {
        assertTrue(ItemAdd.itemAdd("stephen","best shooter",new BigDecimal(30)));
        assertTrue(ItemAdd.itemAdd("thumpson","second best shooter",new BigDecimal(11)));
        assertTrue(ItemAdd.itemAdd("green","good defender",new BigDecimal(23)));
        assertTrue(ItemAdd.itemAdd("igdala","first fmvp",new BigDecimal(9)));
        assertTrue(ItemAdd.itemAdd("keer","best coach",new BigDecimal(9)));

        ItemServiceImpl itemService = new ItemServiceImpl();

        assertTrue(itemService.deleteItem(itemService.selectItem("stephen")));
        assertTrue(itemService.deleteItem(itemService.selectItem("thumpson")));
        assertTrue(itemService.deleteItem(itemService.selectItem("green")));
        assertTrue(itemService.deleteItem(itemService.selectItem("igdala")));
        assertTrue(itemService.deleteItem(itemService.selectItem("keer")));

        assertFalse(ItemAdd.itemAdd("@$@#","",new BigDecimal(24335435)));
        assertFalse(ItemAdd.itemAdd("","youknow978",new BigDecimal(0)));
        assertFalse(ItemAdd.itemAdd("*(*&*&","9&*&*fhds",new BigDecimal(99)));
        assertFalse(ItemAdd.itemAdd("someone","norespond(&97d",new BigDecimal(45)));
        assertFalse(ItemAdd.itemAdd("fucxkdsjfoisdlkfjiosjfihsdfjnsjdfhisdfsydifsdfhjsdh","yousuckdsjf&^&^%654ds65f$",new BigDecimal(711)));
    }
}