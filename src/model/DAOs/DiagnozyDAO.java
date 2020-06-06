package model.DAOs;

import model.entities.DiagnozyEntity;
import model.entities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DiagnozyDAO {
    public static DiagnozyEntity createDiagnoza(String kod, String opis) throws Exception {
        DiagnozyEntity diagnoza = new DiagnozyEntity();
        diagnoza.setKodDiagnozy(kod);
        diagnoza.setOpis(opis);
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(diagnoza);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("Bledne dane");
        }
        return diagnoza;

    }
    public static DiagnozyEntity getDiagnozaById(int id) {
        Transaction transaction = null;
        DiagnozyEntity diagnoza = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            diagnoza = session.get(DiagnozyEntity.class, id);
            transaction.commit();
            return diagnoza;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return diagnoza;
    }
    public static void UpdateDiagnoza(DiagnozyEntity diagnoza) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(diagnoza);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("Bledne dane");
        }
    }
    public static void deleteDiagnoza(int id) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            DiagnozyEntity diagnoza = session.get(DiagnozyEntity.class, id);
            if (diagnoza != null) {
                session.delete(diagnoza);
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
