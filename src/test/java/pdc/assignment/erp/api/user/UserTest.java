package pdc.assignment.erp.api.user;

import org.junit.jupiter.api.Test;
import pdc.assignment.erp.dbo.service.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    @Test
    void registerUser() {
        assertTrue(UserRegister.registerUser("_Aaron", "Aaron3525", 0));
        assertTrue(UserRegister.registerUser("_Abbott", "Abbott85678", 0));
        assertTrue(UserRegister.registerUser("_Charles", "Charles111", 0));
        assertTrue(UserRegister.registerUser("_Barton", "Barton5441", 0));
        assertTrue(UserRegister.registerUser("_Black", "Black2890", 0));

        UserServiceImpl userService = new UserServiceImpl();
        assertTrue(userService.deleteUser(userService.selectUser("_Aaron")));
        assertTrue(userService.deleteUser(userService.selectUser("_Abbott")));
        assertTrue(userService.deleteUser(userService.selectUser("_Charles")));
        assertTrue(userService.deleteUser(userService.selectUser("_Barton")));
        assertTrue(userService.deleteUser(userService.selectUser("_Black")));


        assertFalse(UserRegister.registerUser("", "sopf2341", 0));
        assertFalse(UserRegister.registerUser("James", "james@156", 0));
        assertFalse(UserRegister.registerUser("Alex", "1238123891902380198390120938139814344232434242234", 0));
        assertFalse(UserRegister.registerUser("Epic", "@#$adwdaq", 0));
        assertFalse(UserRegister.registerUser("Strong", "", 0));
    }

}