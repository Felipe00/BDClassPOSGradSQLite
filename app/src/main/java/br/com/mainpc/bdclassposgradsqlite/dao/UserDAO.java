package br.com.mainpc.bdclassposgradsqlite.dao;

import android.content.Context;

import java.util.List;

import br.com.mainpc.bdclassposgradsqlite.helpers.Database;
import br.com.mainpc.bdclassposgradsqlite.models.User;

/**
 * Created by javab0y on 15/10/17.
 */

public interface UserDAO {
    List<User> getUsers(Database database);

    void insertUser(User user, Database database, Context ctx);

    void deleteUser(Integer id, Database database, Context ctx);

    void updateUser(User user, Database database, Context ctx);
}
