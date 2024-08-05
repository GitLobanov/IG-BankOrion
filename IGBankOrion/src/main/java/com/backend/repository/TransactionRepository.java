package com.backend.repository;

import com.backend.model.Card;
import com.backend.model.CardTransaction;
import com.backend.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TransactionRepository implements CrudRepository<CardTransaction,Long> {

    @Override
    public boolean save(CardTransaction cardTransactionModel) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();
            session.persist(cardTransactionModel);
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
    public void update(CardTransaction cardTransactionModel) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();
            session.merge(cardTransactionModel);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(CardTransaction cardTransactionModel) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();
            session.remove(cardTransactionModel);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saves(List<CardTransaction> list) {
        for (CardTransaction cardTransaction : list) {
            save(cardTransaction);
        }
    }

    @Override
    public CardTransaction findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();
            CardTransaction cardTransactionModel = session.get(CardTransaction.class,id);
            transaction.commit();
            return cardTransactionModel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<CardTransaction> findByTransferFrom(Card cardFrom) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();
            List transactions = session.createQuery("from CardTransaction t where t.cardFrom = :cardFrom")
                    .setParameter("cardFrom", cardFrom)
                    .getResultList();
            transaction.commit();
            return transactions;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<CardTransaction> findByTransferToFrom(Card cardTo, Card cardFrom) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();
            List transactions = session.createQuery("from CardTransaction t where t.cardTo = :cardTo and t.cardFrom = :cardFrom")
                    .setParameter("cardTo", cardTo)
                    .setParameter("cardFrom", cardFrom)
                    .getResultList();
            transaction.commit();
            return transactions;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CardTransaction> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List <CardTransaction> cardTransactions = session.createQuery("from CardTransaction", CardTransaction.class).list();
            return cardTransactions;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
