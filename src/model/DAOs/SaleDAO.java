package model.DAOs;

import model.entities.HibernateUtil;
import model.entities.SaleEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SaleDAO {
    public static SaleEntity createSala(int idOddzialu, int idSali, String typ) throws Exception {
    SaleEntity sala = new SaleEntity();
    sala.setIdOddzialu(idOddzialu);
    sala.setNrSali(idSali);
    sala.setTypSali(typ);

    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.save(sala);
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
//        e.printStackTrace();
        throw new Exception("Bledne dane");

    }
        return sala;
}
    public static SaleEntity getSalaById(int id) {
        Transaction transaction = null;
        SaleEntity sala = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            sala = session.get(SaleEntity.class, id);
            transaction.commit();
            return sala;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sala;
    }
    public static void UpdateSala(SaleEntity sala) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sala);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("Bledne dane");
        }
    }
    public static void deleteSala(int id) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            SaleEntity sala = session.get(SaleEntity.class, id);
            if (sala != null) {
                session.delete(sala);
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
