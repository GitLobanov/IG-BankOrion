package com.backend.repository;

import com.backend.model.Account;
import com.backend.model.User;
import com.backend.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountRepository implements CrudRepository<Account, Long> {

    @Override
    public boolean save(Account account) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(account);
            session.flush();
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void update(Account account) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(account);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Account account) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(account);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saves(List<Account> list) {
        for (Account account : list) {
            save(account);
        }
    }

    @Override
    public Account findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Account account = session.get(Account.class,id);
            transaction.commit();
            return account;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public Account findByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Account account = (Account) session.createQuery("from Account a where a.user = :user")
                    .setParameter("user", user)
                    .uniqueResult();
            transaction.commit();
            return account;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account findByNumber(String numberAccount) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Account account = (Account) session.createQuery("from Account a where a.numberAccount = :numberAccount")
                    .setParameter("numberAccount", numberAccount)
                    .uniqueResult();
            transaction.commit();
            return account;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Account> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List <Account> accounts = session.createQuery("from Account", Account.class).list();

            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
