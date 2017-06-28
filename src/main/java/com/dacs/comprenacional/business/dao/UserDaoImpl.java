package com.dacs.comprenacional.business.dao;

import com.dacs.comprenacional.model.User;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Jose on 26/6/2017.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        List<User> result = new ArrayList<User>();

        User cliente = new User();
        cliente.setEmail("jokerwin@live.com.ar");
        cliente.setFullName("jose");

        return result;
    }
}
