package pdc.assignment.erp.dbo.service;

import pdc.assignment.erp.dbo.entity.UsersEntity;

import java.util.List;

public interface UserService {
    
    public UsersEntity selectUser(int uid);

    public UsersEntity selectUser(String username);

    public List<UsersEntity> selectUsers();

    public List<UsersEntity> selectUsers(String username);

    public boolean updateUser(UsersEntity user);

    public boolean insertUser(UsersEntity user);

    public boolean deleteUser(UsersEntity user);
}
