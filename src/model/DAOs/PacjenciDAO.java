package model.DAOs;

import model.entities.HibernateUtil;
import model.entities.PacjenciEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;

public class PacjenciDAO {
    public static PacjenciEntity createPacjenci(String imie, String nazwisko, double wzrost, double masa, Integer idDiagnozy, Integer idLeczenia, Date data) throws Exception {
        PacjenciEntity pacjent = new PacjenciEntity();
        pacjent.setDataPrzyjecia(data);
        pacjent.setImie(imie);
//        Date data = new Date(2000,12,12);
        pacjent.setDataPrzyjecia(data);
        pacjent.setNazwisko(nazwisko);
        pacjent.setWzrost(wzrost);
        pacjent.setMasaCiala(masa);
        pacjent.setIdDiagnozy(idDiagnozy);
        pacjent.setIdLeczenia(idLeczenia);
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(pacjent);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("");
        }
        return pacjent;
    }
    public static PacjenciEntity getPacjentById(int id) {
        Transaction transaction = null;
        PacjenciEntity pacjent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            pacjent = session.get(PacjenciEntity.class, id);
            transaction.commit();
            return pacjent;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return pacjent;
    }
    public static void UpdatePacjent(PacjenciEntity pacjent) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(pacjent);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("");
        }
    }
    public static void deletePacjent(int id) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            PacjenciEntity pacjent = session.get(PacjenciEntity.class, id);
            if (pacjent != null) {
                session.delete(pacjent);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("");
        }
    }
}
