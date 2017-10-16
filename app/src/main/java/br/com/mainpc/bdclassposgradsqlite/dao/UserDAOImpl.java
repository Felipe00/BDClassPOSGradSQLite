package br.com.mainpc.bdclassposgradsqlite.dao;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.mainpc.bdclassposgradsqlite.helpers.Database;
import br.com.mainpc.bdclassposgradsqlite.models.User;

/**
 * Created by javab0y on 15/10/17.
 */

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getUsers(Database database) {
        Cursor cursor = null;
        List<User> users = new ArrayList<>();
        database.open();
        try {
            cursor = database.get().rawQuery("select * from users;", null);
            cursor.moveToFirst();
        } catch (Exception e) {
            e.getCause();
        }

        if (cursor != null && !cursor.isClosed()) {
            do {
                users.add(new User(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getDouble(cursor.getColumnIndex("height"))));
            } while (cursor.moveToNext());
            cursor.close();
        }

        database.close();
        return users;
    }

    @Override
    public void insertUser(User user, Database database, Context ctx) {
        ContentValues cv = new ContentValues();
        database.open();
        try {
            cv.put("name", user.getName());
            cv.put("height", user.getHeight());
            database.get().insert("users", null, cv);
            Toast.makeText(ctx, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            ((Activity) ctx).finish();
        } catch (Exception e) {
            e.getCause();
            Toast.makeText(ctx, "Falha ao cadastrar", Toast.LENGTH_SHORT).show();
        } finally {
            database.close();
        }
    }
}
