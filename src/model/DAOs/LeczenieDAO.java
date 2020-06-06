package model.DAOs;

import model.entities.LeczenieEntity;
import model.entities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LeczenieDAO {
    public static LeczenieEntity createLeczenie() throws Exception {
        LeczenieEntity leczenie = new LeczenieEntity();

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(leczenie);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception();
        }
        return leczenie;
    }
    public static LeczenieEntity getLeczenieById(int id) {
        Transaction transaction = null;
        LeczenieEntity leczenie = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            leczenie = session.get(LeczenieEntity.class, id);
            transaction.commit();
            return leczenie;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return leczenie;
    }
    public static void UpdateLeczenie(LeczenieEntity leczenie) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(leczenie);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("Bledne dane");
        }
    }
    public static void deleteLeczenie(int id) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            LeczenieEntity leczenie = session.get(LeczenieEntity.class, id);
            if (leczenie != null) {
                session.delete(leczenie);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("Bledne dane");
        }
    }
}
