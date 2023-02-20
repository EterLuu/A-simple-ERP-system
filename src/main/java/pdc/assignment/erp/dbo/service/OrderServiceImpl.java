package pdc.assignment.erp.dbo.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pdc.assignment.erp.dbo.Database;
import pdc.assignment.erp.dbo.entity.OrdersEntity;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public OrdersEntity selectOidOrder(int oid) {
        Query<OrdersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from OrdersEntity where oid = ?1");
        query.setParameter(1, oid);
        try {
            OrdersEntity result = query.getSingleResult();
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
    public OrdersEntity selectCidOrder(int cid) {
        Query<OrdersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from OrdersEntity where cid = ?1");
        query.setParameter(1, cid);
        try {
            OrdersEntity result = query.getSingleResult();
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
    public OrdersEntity selectUidOrder(int uid) {
        Query<OrdersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        query = session.createQuery("from OrdersEntity where uid = ?1");
        query.setParameter(1, uid);
        try {
            OrdersEntity result = query.getSingleResult();
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
    public List<OrdersEntity> selectOrders() {
        Query<OrdersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from OrdersEntity");
        return getOrdersEntities(query, session, transaction);
    }

    @Override
    public List<OrdersEntity> selectOidOrders(int oid) {
        Query<OrdersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from OrdersEntity where oid = ?1");
        query.setParameter(1, oid);
        return getOrdersEntities(query, session, transaction);
    }

    @Override
    public List<OrdersEntity> selectCidOrders(int cid) {
        Query<OrdersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from OrdersEntity where cid = ?1");
        query.setParameter(1, cid);
        return getOrdersEntities(query, session, transaction);
    }

    @Override
    public List<OrdersEntity> selectUidOrders(int uid) {
        Query<OrdersEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from OrdersEntity where uid = ?1");
        query.setParameter(1, uid);
        return getOrdersEntities(query, session, transaction);
    }

    private List<OrdersEntity> getOrdersEntities(Query<OrdersEntity> query, Session session, Transaction transaction) {
        try {
            List<OrdersEntity> results = query.getResultList();
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
    public boolean updateOrder(OrdersEntity order) {
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(order);
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
    public int insertOrder(OrdersEntity order) {
        int oid;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(order);
            oid = order.getOid();
            transaction.commit();
            session.close();
            return oid;
        } catch (NoResultException e) {
            transaction.commit();
            session.close();
            return -1;
        }
    }

    @Override
    public boolean deleteOrder(OrdersEntity order) {
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(order);
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
