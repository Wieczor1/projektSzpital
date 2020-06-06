package model.DAOs;

import model.entities.HibernateUtil;
import model.entities.LekiEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LekiDAO {
    public static LekiEntity createLeki(String nazwa, String opis, boolean refundacja) throws Exception {
        LekiEntity lek = new LekiEntity();
        lek.setNazwaLeku(nazwa);
        lek.setKodLeku(opis);
        lek.setRefundacja(refundacja);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(lek);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new Exception("Bledne dane");
        }
        return lek;
    }

    public static LekiEntity getLekById(int id) {
        Transaction transaction = null;
        LekiEntity lek = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            lek = session.get(LekiEntity.class, id);
            transaction.commit();
            return lek;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lek;
    }

    public static void UpdateLek(LekiEntity lek) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(lek);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("Bledne dane"); // TODO sprawdz czy update itd throwuja exception
        }
    }

    public static void deleteLek(int id) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            LekiEntity lek = session.get(LekiEntity.class, id);
            if (lek != null) {
                session.delete(lek);
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
