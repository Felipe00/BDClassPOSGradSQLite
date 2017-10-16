package br.com.mainpc.bdclassposgradsqlite.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import br.com.mainpc.bdclassposgradsqlite.R;
import br.com.mainpc.bdclassposgradsqlite.dao.UserDAO;
import br.com.mainpc.bdclassposgradsqlite.dao.UserDAOImpl;
import br.com.mainpc.bdclassposgradsqlite.helpers.BDSQLiteHelper;
import br.com.mainpc.bdclassposgradsqlite.helpers.Database;
import br.com.mainpc.bdclassposgradsqlite.models.User;

public class DetalheActivity extends AppCompatActivity {

    private TextView id, name, height;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        id = (TextView) findViewById(R.id.id_user);
        name = (TextView) findViewById(R.id.name_user);
        height = (TextView) findViewById(R.id.height_user);

        if (getIntent().hasExtra("USER")) {
            user = (User) getIntent().getSerializableExtra("USER");
            id.setText(user.getId() + "");
            name.setText(user.getName());
            height.setText(user.getHeight() + "");
        }
    }

    public void deleteUser(View v) {
        BDSQLiteHelper helper = new BDSQLiteHelper(this);
        Database db = new Database(helper);
        UserDAO dao = new UserDAOImpl();
        dao.deleteUser(user.getId(), db, DetalheActivity.this);
    }

    public void editUser(View view) {
        startActivity(new Intent(DetalheActivity.this, CadastroActivity.class).putExtra("USER", user));
        finish();
    }
}
