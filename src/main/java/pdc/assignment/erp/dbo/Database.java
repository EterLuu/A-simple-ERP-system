package pdc.assignment.erp.dbo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pdc.assignment.erp.Main;
import pdc.assignment.erp.dbo.entity.UsersEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static Database instance = null;

    private Configuration configuration = new Configuration().configure();

    private SessionFactory sessionFactory;

    private Database() {

        Query<UsersEntity> query;

        sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        query = session.createQuery("from UsersEntity");

        List<UsersEntity> results = query.getResultList();

        if (results.isEmpty()) {

            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Initialize the database...");

            UsersEntity admin = new UsersEntity();
            admin.setPassword("admin");
            admin.setRole(0);
            admin.setUsername("admin");
            admin.setRegisterTime(Timestamp.valueOf(LocalDateTime.now()));

            session.persist(admin);
        }

        transaction.commit();
        session.close();
    }

    public static Database getInstance() {
        synchronized (Database.class) {
            if (instance == null) {
                instance = new Database();
            }
        }
        return instance;

    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void close(){
        sessionFactory.close();
    }
}
