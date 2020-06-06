package model.DAOs;
import model.entities.AdresyEntity;
import model.entities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdresyDAO {
    public static AdresyEntity createAdres(String miasto,
                                   String ulica, int numerDomu, String kodPocztowy, int numerLokalu) throws Exception {
        AdresyEntity adres = new AdresyEntity();
        adres.setMiasto(miasto);
        adres.setUlica(ulica);
        adres.setNumerDomu(numerDomu);
        adres.setNumerLokalu(numerLokalu);
        adres.setKodPocztowy(kodPocztowy);
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(adres);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Bledne dane");
        }
        return adres;
    }
    public List getServiceAll(){
        return HibernateUtil.getSessionFactory().openSession().createCriteria(this.getClass()).list();
    }

    public static AdresyEntity getAdresById(int id) throws Exception {
        Transaction transaction = null;
        AdresyEntity adres = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            adres = session.get(AdresyEntity.class, id);
            transaction.commit();
            return adres;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
//            throw new Exception("Bledne dane");
        }
        return adres;
    }
    public static void UpdateAdres(AdresyEntity adres) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(adres);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Bledne dane");
        }
    }
    public static void deleteAdres(int id) throws Exception { //TODO pododowaja blad usuwania do deletow w DAO
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            AdresyEntity adres = session.get(AdresyEntity.class, id);
            if (adres != null) {
                session.delete(adres);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("błąd usuwania");
        }
    }
}