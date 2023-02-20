package pdc.assignment.erp.api.user;

import pdc.assignment.erp.dbo.entity.UsersEntity;

import pdc.assignment.erp.dbo.service.UserServiceImpl;
import pdc.assignment.erp.util.Judgement;

public class UserUpdate {

    private UserUpdate(){
        throw new IllegalStateException("Utility class");
    }
    public static boolean updateUser(int uid, String username, String password, int role) {

        // Prevent SQL injection.
        if(!Judgement.judgeName(username)){
            return false;
        }
        if(!Judgement.judgePassword(password)){
            return false;
        }

        UserServiceImpl userService = new UserServiceImpl();

        UsersEntity user = userService.selectUser(uid);

        if(user == null)
            return false;
        
        if (!password.equals("")) {
            // Prevent SQL injection.
            if (!Judgement.judgeName(password)) {
                return false;
            }
            user.setPassword(password);
        }
        user.setRole(role);
        
        if (!username.equals(user.getUsername())){
            if(userService.selectUser(username)!=null){
                return false;
            }
            else{
                user.setUsername(username);
            }
        }

        userService.updateUser(user);

        return true;
    }
}
