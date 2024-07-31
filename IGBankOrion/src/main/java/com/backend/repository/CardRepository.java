package com.backend.repository;

import com.backend.model.Account;
import com.backend.model.Card;
import com.backend.model.User;
import com.backend.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CardRepository implements CrudRepository<Card, Long> {

    @Override
    public boolean save(Card card) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(card);
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
    public void update(Card card) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(card);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Card card) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(card);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saves(List<Card> list) {
        for (Card card : list) {
            save(card);
        }
    }

    @Override
    public Card findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Card card = session.get(Card.class,id);
            transaction.commit();
            return card;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Card findByCardNumber(String cardNumber) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Card card = (Card) session.createQuery("from Card c where c.cardNumber = :cardNumber")
                    .setParameter("cardNumber", cardNumber).uniqueResult();
            transaction.commit();
            return card;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Card> findByAccount(Account account) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List card = session.createQuery("from Card c where c.account = :account")
                    .setParameter("account", account).list();
            transaction.commit();
            return card;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // TODO

    @Override
    public List<Card> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List <Card> cards = session.createQuery("from Card", Card.class).list();
            return cards;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
