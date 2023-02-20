package pdc.assignment.erp.api.user;

import pdc.assignment.erp.dbo.entity.UsersEntity;
import pdc.assignment.erp.dbo.service.UserServiceImpl;
import pdc.assignment.erp.util.Judgement;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UserRegister {

    private UserRegister(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean registerUser(String username, String password, int role){

        // Prevent SQL injection.
        if(!Judgement.judgeName(username)){
            return false;
        }
        if(!Judgement.judgePassword(password)){
            return false;
        }

        UserServiceImpl userService = new UserServiceImpl();

        if(userService.selectUser(username)==null) {

            UsersEntity user = new UsersEntity();
            user.setPassword(password);
            user.setRole(role);
            user.setUsername(username);
            user.setRegisterTime(Timestamp.valueOf(LocalDateTime.now()));

            userService.insertUser(user);

            return true;
        }
        else {
            return false;
        }
    }
}
