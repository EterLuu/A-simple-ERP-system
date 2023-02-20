package pdc.assignment.erp.dbo.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pdc.assignment.erp.dbo.Database;
import pdc.assignment.erp.dbo.entity.ReceiptsEntity;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.List;

public class ReceiptServiceImpl implements ReceiptService {
    @Override
    public ReceiptsEntity selectRidReceipt(int rid) {
        Query<ReceiptsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ReceiptsEntity where rid = ?1");
        query.setParameter(1, rid);
        try {
            ReceiptsEntity result = query.getSingleResult();
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
    public ReceiptsEntity selectCidReceipt(int cid) {
        Query<ReceiptsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ReceiptsEntity where cid = ?1");
        query.setParameter(1, cid);
        try {
            ReceiptsEntity result = query.getSingleResult();
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
    public List<ReceiptsEntity> selectReceipts() {
        Query<ReceiptsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ReceiptsEntity");
        return getReceiptsEntities(query, session, transaction);
    }

    @Override
    public List<ReceiptsEntity> selectRidReceipts(int rid) {
        Query<ReceiptsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ReceiptsEntity where rid = ?1");
        query.setParameter(1, rid);
        return getReceiptsEntities(query, session, transaction);
    }

    @Override
    public List<ReceiptsEntity> selectCidReceipts(int cid) {
        Query<ReceiptsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ReceiptsEntity where cid = ?1");
        query.setParameter(1, cid);
        return getReceiptsEntities(query, session, transaction);
    }

    private List<ReceiptsEntity> getReceiptsEntities(Query<ReceiptsEntity> query, Session session, Transaction transaction) {
        try {
            List<ReceiptsEntity> results = query.getResultList();
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
    public boolean updateReceipt(ReceiptsEntity receipt) {
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(receipt);
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
    public int insertReceipt(ReceiptsEntity receipt) {
        int rid;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(receipt);
            rid = receipt.getRid();
            transaction.commit();
            session.close();
            return rid;
        } catch (NoResultException e) {
            transaction.commit();
            session.close();
            return -1;
        }
    }

    @Override
    public boolean deleteReceipt(ReceiptsEntity receipt) {
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(receipt);
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
