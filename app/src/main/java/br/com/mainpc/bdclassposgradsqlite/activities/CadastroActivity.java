package br.com.mainpc.bdclassposgradsqlite.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.mainpc.bdclassposgradsqlite.R;
import br.com.mainpc.bdclassposgradsqlite.dao.UserDAO;
import br.com.mainpc.bdclassposgradsqlite.dao.UserDAOImpl;
import br.com.mainpc.bdclassposgradsqlite.helpers.BDSQLiteHelper;
import br.com.mainpc.bdclassposgradsqlite.helpers.Database;
import br.com.mainpc.bdclassposgradsqlite.models.User;

public class CadastroActivity extends AppCompatActivity {

    private EditText name, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        name = (EditText) findViewById(R.id.name);
        height = (EditText) findViewById(R.id.height);
    }

    public void registerUser(View v) {
        if (name.getText().toString().isEmpty() || height.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }
        User user = new User(name.getText().toString(), Double.parseDouble(height.getText().toString()));
        BDSQLiteHelper helper = new BDSQLiteHelper(this);
        Database db = new Database(helper);
        UserDAO dao = new UserDAOImpl();
        dao.insertUser(user, db, this);
    }
}
