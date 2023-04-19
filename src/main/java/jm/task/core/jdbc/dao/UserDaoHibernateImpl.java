package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    private static final String sqlCommandDeleteUserTable =
            "DROP TABLE IF EXISTS users";
    private static final String sqlCommandCreateUserTable =
            "CREATE TABLE IF NOT EXISTS users (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), lastName VARCHAR(100), age INT(3))";
    public UserDaoHibernateImpl() {

    }
    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getConnectionHibernate().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(sqlCommandCreateUserTable).executeUpdate();
            transaction.commit();
        }   catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getConnectionHibernate().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(sqlCommandDeleteUserTable).executeUpdate();
            transaction.commit();
        }   catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = Util.getConnectionHibernate().openSession()) {
            transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
        }   catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = Util.getConnectionHibernate().openSession()) {
            transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getConnectionHibernate().openSession()) {
            return session.createQuery("from User", User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }   return null;
    }

    @Override
    public void cleanUsersTable() {
        dropUsersTable();
        createUsersTable();
    }
}

