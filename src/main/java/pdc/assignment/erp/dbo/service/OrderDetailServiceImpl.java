package pdc.assignment.erp.dbo.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pdc.assignment.erp.dbo.Database;
import pdc.assignment.erp.dbo.entity.OrderDetailsEntity;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    @Override
    public OrderDetailsEntity selectOidOrderDetail(int oid) {
        Query<OrderDetailsEntity> query;
        
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from OrderDetailsEntity where oid = ?1");
        query.setParameter(1, oid);
        try {
            OrderDetailsEntity result = query.getSingleResult();
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
    public OrderDetailsEntity selectDidOrderDetail(int did) {
        Query<OrderDetailsEntity> query;
        
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from OrderDetailsEntity where did = ?1");
        query.setParameter(1, did);
        try {
            OrderDetailsEntity result = query.getSingleResult();
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
    public List<OrderDetailsEntity> selectOidOrderDetails(int oid) {
        Query<OrderDetailsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from OrderDetailsEntity ");
        return getOrderDetailsEntities(query, session, transaction);
    }

    @Override
    public List<OrderDetailsEntity> selectDidOrderDetails(int did) {
        Query<OrderDetailsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from OrderDetailsEntity where did = ?1");
        query.setParameter(1, did);
        return getOrderDetailsEntities(query, session, transaction);
    }

    private List<OrderDetailsEntity> getOrderDetailsEntities(Query<OrderDetailsEntity> query, Session session, Transaction transaction) {
        try {
            List<OrderDetailsEntity> results = query.getResultList();
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
    public boolean updateOrderDetail(OrderDetailsEntity orderDetail) {
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(orderDetail);
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
    public boolean insertOrderDetail(OrderDetailsEntity orderDetail) {
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(orderDetail);
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
    public boolean deleteOrderDetail(OrderDetailsEntity orderDetail) {
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(orderDetail);
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
