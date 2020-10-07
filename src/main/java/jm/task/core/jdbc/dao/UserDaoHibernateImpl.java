package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

        Transaction transaction;
        Session session = Util.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();

            session.createSQLQuery("create Table public.users" +
                    " ( id bigint," +
                    " name varchar(255)," +
                    " last_name varchar(255)," +
                    " age smallint," +
                    "PRIMARY KEY (id) );").executeUpdate();

            session.createSQLQuery("ALTER TABLE public.users\n" +
                    " ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY;").executeUpdate();

            transaction.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {

        Transaction transaction;
        Session session = Util.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();

            session.createSQLQuery("DROP TABLE IF EXISTS Users").executeUpdate();

            transaction.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        Transaction transaction;
        Session session = Util.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();

            User user = new User(name, lastName, age);

            session.save(user);

            transaction.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void removeUserById(long id) {

        Transaction transaction;
        Session session = Util.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();

            User user = (User) session.get(User.class, id);

            session.delete(user);

            transaction.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {

        Session session = Util.getSessionFactory().openSession();
        List<User> users;

        try {
            users = session.createSQLQuery("from User").list();
        } finally {
            session.close();
        }

        return users;
    }

    @Override
    public void cleanUsersTable() {

        Transaction transaction;
        Session session = Util.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();

            session.createQuery("delete from Users");

            transaction.commit();
        } finally {
            session.close();
        }
    }
}