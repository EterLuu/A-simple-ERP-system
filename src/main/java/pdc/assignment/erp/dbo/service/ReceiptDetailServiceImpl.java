package pdc.assignment.erp.dbo.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pdc.assignment.erp.dbo.Database;
import pdc.assignment.erp.dbo.entity.ReceiptDetailsEntity;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.List;

public class ReceiptDetailServiceImpl implements ReceiptDetailService {
    @Override
    public ReceiptDetailsEntity selectDidReceiptDetail(int did) {
        Query<ReceiptDetailsEntity> query;
        
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ReceiptDetailsEntity where did = ?1");
        query.setParameter(1, did);
        try {
            ReceiptDetailsEntity result = query.getSingleResult();
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
    public ReceiptDetailsEntity selectRidReceiptDetail(int rid) {
        Query<ReceiptDetailsEntity> query;
        
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ReceiptDetailsEntity where rid = ?1");
        query.setParameter(1, rid);
        try {
            ReceiptDetailsEntity result = query.getSingleResult();
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
    public List<ReceiptDetailsEntity> selectDidReceiptDetails(int did) {
        Query<ReceiptDetailsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ReceiptDetailsEntity where did = ?1");
        query.setParameter(1, did);
        return getReceiptDetailsEntities(query, session, transaction);
    }

    @Override
    public List<ReceiptDetailsEntity> selectRidReceiptDetails(int rid) {
        Query<ReceiptDetailsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ReceiptDetailsEntity where rid = ?1");
        query.setParameter(1, rid);
        return getReceiptDetailsEntities(query, session, transaction);
    }

    private List<ReceiptDetailsEntity> getReceiptDetailsEntities(Query<ReceiptDetailsEntity> query, Session session, Transaction transaction) {
        try {
            List<ReceiptDetailsEntity> results = query.getResultList();
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
    public boolean updateReceiptDetail(ReceiptDetailsEntity detailsEntity) {
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(detailsEntity);
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
    public boolean insertReceiptDetail(ReceiptDetailsEntity detailsEntity) {
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(detailsEntity);
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
    public boolean deleteReceiptDetail(ReceiptDetailsEntity detailsEntity) {
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(detailsEntity);
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
