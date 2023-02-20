
package pdc.assignment.erp.api.user;

import pdc.assignment.erp.dbo.entity.UsersEntity;
import pdc.assignment.erp.dbo.service.UserServiceImpl;
import pdc.assignment.erp.ui.frame.CenterPage;
import pdc.assignment.erp.util.Judgement;

public class UserLogin {

    private UserLogin(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean userLogin(String username, String password) {

        // Prevent SQL injection.
        if(!(Judgement.judgeName(username) || Judgement.judgePassword(password))){
            return false;
        }

        UserServiceImpl userService = new UserServiceImpl();

        UsersEntity user = userService.selectUser(username);

        if(user == null){
            return false;
        }

        if(user.getPassword().equals(password)){
            java.awt.EventQueue.invokeLater(() -> new CenterPage().setVisible(true));
            return true;
        }
        else {
            return false;
        }
    }
}
