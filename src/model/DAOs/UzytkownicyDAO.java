package model.DAOs;

import model.entities.HibernateUtil;
import model.entities.UzytkownicyEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UzytkownicyDAO {
    public static String generateHash(String input) {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    'a', 'b', 'c', 'd', 'e', 'f' };
            for (int idx = 0; idx < hashedBytes.length;   idx++) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
        }

        return hash.toString();
    }
    public static boolean contains(String test) {

        for (Uprawnienia c : Uprawnienia.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }

        return false;
    }
    public static void createUzytkownik(String haslo, Uprawnienia uprawnienia, String nazwa) {
        UzytkownicyEntity uzytkownik = new UzytkownicyEntity();
        uzytkownik.setHash(generateHash(haslo));
        uzytkownik.setNazwa(nazwa);
        uzytkownik.setUprawnienia(uprawnienia.uprawnienie);


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(uzytkownik);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public static UzytkownicyEntity getUzytkownikById(int id) {
        Transaction transaction = null;
        UzytkownicyEntity uzytkownik = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            uzytkownik = session.get(UzytkownicyEntity.class, id);
            transaction.commit();
            return uzytkownik;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return uzytkownik;
    }
    public static UzytkownicyEntity getUzytkownikByUsernameAndPassword(String username, String password) {
        Transaction transaction = null;
        UzytkownicyEntity uzytkownik = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           // transaction = session.beginTransaction();
            String hql = "FROM UzytkownicyEntity E WHERE E.nazwa = :username AND E.hash = :hash";
            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            query.setParameter("hash", generateHash(password));
            List results = query.list();
            //transaction.commit();
            if (!results.isEmpty()) {
                return (UzytkownicyEntity) results.get(0);
            }
            else
                {
                    return null;
                }
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            e.printStackTrace();
        }
        return uzytkownik;
    }
    public static void UpdateUzytkownik(UzytkownicyEntity uzytkownik) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(uzytkownik);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public static void deleteUzytkownik(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            UzytkownicyEntity uzytkownik = session.get(UzytkownicyEntity.class, id);
            if (uzytkownik != null) {
                session.delete(uzytkownik);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
