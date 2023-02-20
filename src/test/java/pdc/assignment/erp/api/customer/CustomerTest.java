package pdc.assignment.erp.api.customer;

import org.junit.jupiter.api.Test;
import pdc.assignment.erp.dbo.service.CustomerServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    @Test
    void customerAdd() {
        assertTrue(CustomerAdd.customerAdd("durant","wjksjdf","21335345","skldjfewods","dsfjioe"));
        assertTrue(CustomerAdd.customerAdd("keven","eroius-jj","sdfe97786","eseoixu89","eee"));
        assertTrue(CustomerAdd.customerAdd("daxishi","24324hjhj","es088767"," xjdifedfdfs23","dk df"));
        assertTrue(CustomerAdd.customerAdd("liwensidun","weijs9eesd","186765543","esjidjxnn","stk vs dk"));
        assertTrue(CustomerAdd.customerAdd("padun","dsfjkxjndn","7642736432","jeijxkjfdk","yongshizongguanjun"));
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        assertTrue(customerService.deleteCustomer(customerService.selectCustomer("durant")));
        assertTrue(customerService.deleteCustomer(customerService.selectCustomer("keven")));
        assertTrue(customerService.deleteCustomer(customerService.selectCustomer("daxishi")));
        assertTrue(customerService.deleteCustomer(customerService.selectCustomer("liwensidun")));
        assertTrue(customerService.deleteCustomer(customerService.selectCustomer("padun")));

        assertFalse(CustomerAdd.customerAdd("","jweoijs","%^&$$5342","dsjfiesjd;jdsf]]","jksldjfioenkfj"));
        assertFalse(CustomerAdd.customerAdd("djfnnx234","","sd234u23jshdfj","^%$%#%^$##^#$","dsfjkjdsn323"));
        assertFalse(CustomerAdd.customerAdd("$#%$#%$","feise6e6455r4^","","fdjsiofe6547","76e5rdf%^$FD"));
        assertFalse(CustomerAdd.customerAdd("spheusjfd","&^&D^FYFDGUYF","1248786dfs","","EWIOjdjs*333#"));
        assertFalse(CustomerAdd.customerAdd("STUOPIDFjgdf","dsf*7&6f78ef76","987d6g7d676","dfjosDUFSDf87sd8",""));
    }
}