package pdc.assignment.erp.dbo.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pdc.assignment.erp.dbo.Database;
import pdc.assignment.erp.dbo.entity.BankAccountsEntity;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.List;

public class BankaccountServiceImpl implements BankaccountService {

    @Override
    public BankAccountsEntity selectBankAccount(int bid){
        Query<BankAccountsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from BankAccountsEntity where bid = ?1");
        query.setParameter(1, bid);
        try {
            BankAccountsEntity result = query.getSingleResult();
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
    public BankAccountsEntity selectBankAccount(String name){
        Query<BankAccountsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from BankAccountsEntity where name = ?1");
        query.setParameter(1, name);
        try {
            BankAccountsEntity result = query.getSingleResult();
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
    public List<BankAccountsEntity> selectBankAccounts(){
        Query<BankAccountsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from BankAccountsEntity ");
        return getBankAccountsEntities(query, session, transaction);
    }

    @Override
    public List<BankAccountsEntity> selectBankAccounts(String name){
        Query<BankAccountsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from BankAccountsEntity where name like ?1");
        query.setParameter(1, "%"+name+"%");

        return getBankAccountsEntities(query, session, transaction);
    }

    private List<BankAccountsEntity> getBankAccountsEntities(Query<BankAccountsEntity> query, Session session, Transaction transaction) {
        try {
            List<BankAccountsEntity> results = query.getResultList();
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
    public boolean updateBankAccount(BankAccountsEntity entity){
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(entity);
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
    public boolean insertBankAccount(BankAccountsEntity entity){
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity);
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
    public boolean deleteBankAccount(BankAccountsEntity entity){
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(entity);
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
