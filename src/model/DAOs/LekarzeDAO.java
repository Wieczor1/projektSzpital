package model.DAOs;

import model.entities.HibernateUtil;
import model.entities.LekarzeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.invoke.MethodHandles;
import java.util.List;
//TODO zmienic w dao creaty zeby zwracaly obiekt stworzony
public class LekarzeDAO extends GenericDAO {
    public static LekarzeEntity createLekarz(int idAdresu, String imie, String nazwisko, String specjalizacja) throws Exception {
        LekarzeEntity lekarz = new LekarzeEntity();
        lekarz.setIdAdresu(idAdresu);
        lekarz.setImie(imie);
        lekarz.setNazwisko(nazwisko);
        lekarz.setSpecjalizacja(specjalizacja);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(lekarz);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("Bledne dane");
        }
        return lekarz;
    }


    public static LekarzeEntity getLekarzById(int id) {
        Transaction transaction = null;
        LekarzeEntity lekarz = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            lekarz = session.get(LekarzeEntity.class, id);
            transaction.commit();
            return lekarz;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lekarz;
    }
    public static void UpdateLekarz(LekarzeEntity lekarz) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(lekarz);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Bledne dane");
        }
    }
    public static void deleteLekarz(int id) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            LekarzeEntity lekarz = session.get(LekarzeEntity.class, id);
            if (lekarz != null) {
                session.delete(lekarz);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
//            e.printStackTrace();
            throw new Exception("Bledne dane");
        }

    }
}
