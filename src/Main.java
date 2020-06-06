import model.DAOs.*;
import model.entities.AdresyEntity;
import model.entities.LekarzeEntity;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.List;
import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            UzytkownicyDAO.createUzytkownik("pielegniarka", Uprawnienia.PIELEGNIARKA,"pielegniarka");
//            AdresyDAO.createAdres("Ostróda","Gizewiusza", 22, "14-100", 12);
//            LekarzeDAO.createLekarz(2,"Adam", "Mickiewicz", "kardiolog");
//            List<AdresyEntity> lista = GenericDAO.getAll(AdresyEntity.class);
//            for (AdresyEntity l:lista
//                 ) {
//                System.out.println(l);
////            }
//            List list = LeczenieLekiDAO.getLeczenieLekiById(8);
//            System.out.println(list.get(0));
            session.close();
        }// TODO popraw w pacjencie, dodaj diagnoze i leczenie
//TODO rejestracja
    }
}