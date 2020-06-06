package model.DAOs;

import model.entities.HibernateUtil;
import model.entities.LeczenieLekiEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LeczenieLekiDAO {
    public static LeczenieLekiEntity createLeczenieLeki(double dawkowanie, String uwagi, int idLeczenia, int idLeku) throws Exception {
        LeczenieLekiEntity leczenieLeki = new LeczenieLekiEntity();
        leczenieLeki.setDawkowanieMiligramy(dawkowanie);
        leczenieLeki.setUwagi(uwagi);
        leczenieLeki.setIdLeczenia(idLeczenia);
        leczenieLeki.setIdLeku(idLeku);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(leczenieLeki);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("");
        }
        return leczenieLeki;
    }
    public static List<LeczenieLekiEntity> getLeczenieLekiById(int id) {
        Transaction transaction = null;
        LeczenieLekiEntity leczenieLeki = null;
        List list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
            Query query = session.createQuery("from LeczenieLekiEntity u where u.idLeczenia = :idLeczenia ");
            query.setParameter("idLeczenia", id);
            list = query.list();
//            leczenieLeki = session.get(LeczenieLekiEntity.class, id);
//            transaction.commit();
//            return leczenieLeki;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

//    public static LeczenieLekiEntity getLeczenieLekiById(int idLeczenia) throws Exception {
//        Transaction transaction = null;
//        LeczenieLekiEntity leczenieLeki = null;
//        List list = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            leczenieLeki = session.get(LeczenieLekiEntity.class, idLeczenia);
//            transaction.commit();
//
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//            throw new Exception("");
//        }
//        return leczenieLeki;
//    }
    public static void UpdateLeczenieLeki(LeczenieLekiEntity leczenieLeki) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(leczenieLeki);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception();
        }
    }
    public static void deleteLeczenieLeki(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            LeczenieLekiEntity leczenieLeki = session.get(LeczenieLekiEntity.class, id);
            if (leczenieLeki != null) {
                session.delete(leczenieLeki);
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
