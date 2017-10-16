package br.com.mainpc.bdclassposgradsqlite.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        name = (EditText) findViewById(R.id.name);
        height = (EditText) findViewById(R.id.height);

        if (getIntent().hasExtra("USER")) {
            user = (User) getIntent().getSerializableExtra("USER");
            name.setText(user.getName());
            height.setText(user.getHeight() + "");
            ((Button) findViewById(R.id.btn_confirm)).setText("Alterar");
        }
    }

    public void registerUser(View v) {
        if (name.getText().toString().isEmpty() || height.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }
        BDSQLiteHelper helper = new BDSQLiteHelper(this);
        Database db = new Database(helper);
        UserDAO dao = new UserDAOImpl();
        if (user == null) {
            user = new User(name.getText().toString(), Double.parseDouble(height.getText().toString()));
            dao.insertUser(user, db, this);
        } else {
            user.setName(name.getText().toString());
            user.setHeight(Double.parseDouble(height.getText().toString()));
            dao.updateUser(user, db, this);
        }
    }
}
