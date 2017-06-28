package com.dacs.comprenacional.business.dao;

import com.dacs.comprenacional.model.User;
import java.util.List;

/**
 * Created by Jose on 26/6/2017.
 */
public interface UserDao {
    public List<User> findAll();
}
