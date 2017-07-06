package com.dacs.comprenacional.business.dao;

import com.dacs.comprenacional.model.User;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Jose on 26/6/2017.
 */
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {

        TypedQuery<User> query = em.createQuery("SELECT p FROM User p", User.class);
        List<User> result = query.getResultList();

        return result;
    }
}
