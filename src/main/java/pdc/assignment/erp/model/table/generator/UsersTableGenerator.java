package pdc.assignment.erp.model.table.generator;

import pdc.assignment.erp.dbo.service.UserServiceImpl;
import pdc.assignment.erp.model.table.UsersTableModel;
import pdc.assignment.erp.util.Judgement;

public class UsersTableGenerator {

    private UsersTableGenerator(){
        throw new IllegalStateException("Utility class");
    }

    private static UserServiceImpl userService = new UserServiceImpl();

    public static UsersTableModel searchUser(String username) {

        // Prevent SQL injection.
        if(!Judgement.judgeName(username)){
            return new UsersTableModel(userService.selectUsers());
        }

        return new UsersTableModel(userService.selectUsers(username));
    }

    public static UsersTableModel searchUser() {

        return new UsersTableModel(userService.selectUsers());
    }
}
