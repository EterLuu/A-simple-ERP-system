package pdc.assignment.erp.dbo.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pdc.assignment.erp.dbo.Database;
import pdc.assignment.erp.dbo.entity.ItemsEntity;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.List;

public class ItemServiceImpl implements ItemService {

    @Override
    public ItemsEntity selectItem(int iid){
        Query<ItemsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ItemsEntity where iid = ?1");
        query.setParameter(1, iid);
        try {
            ItemsEntity result = query.getSingleResult();
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
    public ItemsEntity selectItem(String name){
        Query<ItemsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ItemsEntity where name like ?1");
        query.setParameter(1, name);
        try {
            ItemsEntity result = query.getSingleResult();
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
    public List<ItemsEntity> selectItems(){
        Query<ItemsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ItemsEntity");
        return getItemsEntities(query, session, transaction);
    }

    private List<ItemsEntity> getItemsEntities(Query<ItemsEntity> query, Session session, Transaction transaction) {
        try {
            List<ItemsEntity> results = query.getResultList();
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
    public List<ItemsEntity> selectItems(String name){
        Query<ItemsEntity> query;

        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        query = session.createQuery("from ItemsEntity where name like ?1");
        query.setParameter(1, "%"+name+"%");

        return getItemsEntities(query, session, transaction);
    }

    @Override
    public boolean updateItem(ItemsEntity item){
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(item);
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
    public boolean insertItem(ItemsEntity item){
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(item);
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
    public boolean deleteItem(ItemsEntity item){
        Session session = Database.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(item);
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
