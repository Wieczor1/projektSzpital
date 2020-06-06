package model.DAOs;

import model.entities.HibernateUtil;
import org.hibernate.usertype.ParameterizedType;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class GenericDAO {

    static public List getAll(Class type) {
        return HibernateUtil.getSessionFactory().openSession().createCriteria(type).list();
    }
}


