package pdc.assignment.erp.api.test;

import pdc.assignment.erp.api.bankaccount.BankAccountAdd;
import pdc.assignment.erp.api.customer.CustomerAdd;
import pdc.assignment.erp.api.item.ItemAdd;
import pdc.assignment.erp.api.user.UserRegister;

import java.math.BigDecimal;

public class AddTestData {

    private AddTestData(){
        throw new IllegalStateException("Utility class");
    }

    public static void addTestData(){
        UserRegister.registerUser("Aaron","Aaron3525",0);
        UserRegister.registerUser("Abbott","Abbott85678",0);
        UserRegister.registerUser("Charles","Charles111",0);
        UserRegister.registerUser("Barton","Barton5441",0);
        UserRegister.registerUser("Black","Black2890",0);

        CustomerAdd.customerAdd("Bob","52 Bridge St Glasgow Schottland","+44 7673388119","+44 7673388119","  ");
        CustomerAdd.customerAdd("Slaninova","17 Ruthvenfield Rd Perth Schottland","+44 7690062471","+44 7690062471","  ");
        CustomerAdd.customerAdd("Juliwa","21 Harrogate Rd Ripon England","+44 7831472259","+44 7831472259","  ");
        CustomerAdd.customerAdd("Eli Perlo Tor","64 Hanbury St London England","+44 7648447269","+44 7648447269","  ");
        CustomerAdd.customerAdd( "Antonio","29 Brook St Chester England","+44 7810517020","+44 7810517020","  ");

        ItemAdd.itemAdd("Apple","fresh apple",new BigDecimal(6));
        ItemAdd.itemAdd("Banana","banana",new BigDecimal(8));
        ItemAdd.itemAdd("Cherry","cherry",new BigDecimal(10));
        ItemAdd.itemAdd("Date","date",new BigDecimal(14));
        ItemAdd.itemAdd("Grape","grape",new BigDecimal(15));
        ItemAdd.itemAdd("Haw","haw",new BigDecimal(12));
        ItemAdd.itemAdd("Lemon","lemon",new BigDecimal(24));
        ItemAdd.itemAdd("Mango","mango",new BigDecimal(18));
        ItemAdd.itemAdd("Orange","orange",new BigDecimal(31));
        ItemAdd.itemAdd("Strawberry","strawberry",new BigDecimal(23));

        BankAccountAdd.addAccount("Alice","01-2356-1872651-222");
        BankAccountAdd.addAccount("Alex","02-1644-5984327-412");

        CustomerAdd.customerAdd("Radosavyevich","92 Dalston Rd Carlisle","+44 7642001350","+44 7642001350"," ");
        CustomerAdd.customerAdd("Villa","14 Bromley Pl Nottingham","+44 7584176049","+44 7584176049"," ");
        CustomerAdd.customerAdd("Wen Duke","20 Well St Exeter","+44 7841719485","+44 7841719485"," ");
        CustomerAdd.customerAdd("Babu Jeff","95 Beech Rd St Albans","+44 7696706074","+44 7696706074"," ");
        CustomerAdd.customerAdd("Bonaventile","7 Via Ravenna Chichester","+44 7686897155","+44 7686897155"," ");

        BankAccountAdd.addAccount("An Qi Qi","5448019748443230");
        BankAccountAdd.addAccount("Kylie","4556326708124473");

        UserRegister.registerUser("Godwin","Godwin1118",0);
        UserRegister.registerUser("Shern Huber","Huber0321",0);
        UserRegister.registerUser("Rubsan Gombe","Gombe0926",0);
        UserRegister.registerUser("Mo Xia di","di0709",0);
        UserRegister.registerUser("Danube","Danube1212",0);

        ItemAdd.itemAdd("Flower","rose",new BigDecimal(25));
        ItemAdd.itemAdd("Earphone","sony",new BigDecimal(1090));
        ItemAdd.itemAdd("Bulk","NVC bulk", BigDecimal.valueOf(21.5));
        ItemAdd.itemAdd("Laptop","Lenovo",new BigDecimal(4099));
        ItemAdd.itemAdd("Monitor","Skyworth",new BigDecimal(1399));
        ItemAdd.itemAdd("Table lamp","OPPLE",new BigDecimal(119));
        ItemAdd.itemAdd("Mask","mask",new BigDecimal(14));
        ItemAdd.itemAdd("Hair drier","hair drier",new BigDecimal(40));
        ItemAdd.itemAdd("Toothbrush","toothbrush", BigDecimal.valueOf(17.8));
        ItemAdd.itemAdd("Mop","mop", BigDecimal.valueOf(21.8));
    }
}
