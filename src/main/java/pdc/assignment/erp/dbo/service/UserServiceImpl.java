package pdc.assignment.erp.dbo.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pdc.assignment.erp.dbo.Database;
import pdc.assignment.erp.dbo.entity.UsersEntity;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public UsersEntity selectUser(int uid){
        Query<UsersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from UsersEntity where uid = ?1");
        query.setParameter(1, uid);
        try {
            UsersEntity result = query.getSingleResult();
            transaction.commit();
            session.close();
            return result;
        } catch (NoResultException e) {
            transaction.commit();
            session.close();
            return null;
        }
    }

    @Override
    public UsersEntity selectUser(String username){
        Query<UsersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from UsersEntity where username like ?1");
        query.setParameter(1, username);
        try {
            UsersEntity result = query.getSingleResult();
            transaction.commit();
            session.close();
            return result;
        } catch (NoResultException e) {
            transaction.commit();
            session.close();
            return null;
        }
    }

    @Override
    public List<UsersEntity> selectUsers(){
        Query<UsersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from UsersEntity");
        return getUsersEntities(query, session, transaction);
    }

    @Override
    public List<UsersEntity> selectUsers(String username){
        Query<UsersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from UsersEntity where username like ?1");
        query.setParameter(1, "%"+username+"%");

        return getUsersEntities(query, session, transaction);
    }

    private List<UsersEntity> getUsersEntities(Query<UsersEntity> query, Session session, Transaction transaction) {
        try {
            List<UsersEntity> results = query.getResultList();
            transaction.commit();
            session.close();
            return results;
        } catch (NoResultException e) {
            transaction.commit();
            session.close();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean updateUser(UsersEntity user){
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
            transaction.commit();
            session.close();
            return true;
        } catch (NoResultException e) {
            transaction.commit();
            session.close();
            return false;
        }
    }

    @Override
    public boolean insertUser(UsersEntity user){
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(user);
            transaction.commit();
            session.close();
            return true;
        } catch (NoResultException e) {
            transaction.commit();
            session.close();
            return false;
        }
    }

    @Override
    public boolean deleteUser(UsersEntity user){
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(user);
            transaction.commit();
            session.close();
            return true;
        } catch (NoResultException e) {
            transaction.commit();
            session.close();
            return false;
        }
    }
}
