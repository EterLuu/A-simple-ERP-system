package pdc.assignment.erp.dbo.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pdc.assignment.erp.dbo.Database;
import pdc.assignment.erp.dbo.entity.CustomersEntity;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomersEntity selectCustomer(int cid){
        Query<CustomersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from CustomersEntity where cid = ?1");
        query.setParameter(1, cid);
        try {
            CustomersEntity result = query.getSingleResult();
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
    public CustomersEntity selectCustomer(String name){
        Query<CustomersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from CustomersEntity where name like ?1");
        query.setParameter(1, name);
        try {
            CustomersEntity result = query.getSingleResult();
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
    public List<CustomersEntity> selectCustomers(){
        Query<CustomersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from CustomersEntity");
        return getCustomersEntities(query, session, transaction);
    }

    @Override
    public List<CustomersEntity> selectCustomers(String name){
        Query<CustomersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from CustomersEntity where name like ?1");
        query.setParameter(1, "%"+name+"%");

        return getCustomersEntities(query, session, transaction);
    }

    private List<CustomersEntity> getCustomersEntities(Query<CustomersEntity> query, Session session, Transaction transaction) {
        try {
            List<CustomersEntity> results = query.getResultList();
            transaction.commit();
            session.close();
            return results;
        } catch (NoResultException e) {
            transaction.commit();
            session.close();
            return Collections.emptyList();
        }
    }

    @Override
    public boolean updateCustomer(CustomersEntity customer){
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(customer);
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
    public boolean insertCustomer(CustomersEntity customer){
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(customer);
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
    public boolean deleteCustomer(CustomersEntity customer){
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(customer);
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
