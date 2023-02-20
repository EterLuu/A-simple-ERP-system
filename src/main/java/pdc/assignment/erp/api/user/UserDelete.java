package pdc.assignment.erp.api.user;

import pdc.assignment.erp.dbo.entity.UsersEntity;
import pdc.assignment.erp.dbo.service.UserServiceImpl;

public class UserDelete {

    private UserDelete(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean userDelete(int uid){

        UserServiceImpl userService = new UserServiceImpl();

        UsersEntity user = userService.selectUser(uid);

        if (user == null)
            return false;

        return userService.deleteUser(user);
    }
}
