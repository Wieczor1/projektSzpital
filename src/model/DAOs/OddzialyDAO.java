package model.DAOs;

import model.entities.HibernateUtil;
import model.entities.OddzialyEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OddzialyDAO {
    public static OddzialyEntity createOddzial(int idOrdynatora, String nazwa, String nrTelefonu) throws Exception {
        OddzialyEntity oddzial = new OddzialyEntity();
        oddzial.setIdOrdynatora(idOrdynatora);
        oddzial.setNazwa(nazwa);
        oddzial.setNrTelefonu(nrTelefonu);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(oddzial);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Bledne dane");
        }
        return oddzial;
    }
    public static OddzialyEntity getOddzialById(int id) {
        Transaction transaction = null;
        OddzialyEntity oddzial = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            oddzial = session.get(OddzialyEntity.class, id);
            transaction.commit();
            return oddzial;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return oddzial;
    }
    public static void UpdateOddzial(OddzialyEntity oddzial) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(oddzial);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
//            e.printStackTrace();
            throw new Exception("Bledne dane");
        }
    }
    public static void deleteOddzial(int id) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            OddzialyEntity oddzial = session.get(OddzialyEntity.class, id);
            if (oddzial != null) {
                session.delete(oddzial);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
//            e.printStackTrace();
            throw new Exception(" ");
        }
    }
}
