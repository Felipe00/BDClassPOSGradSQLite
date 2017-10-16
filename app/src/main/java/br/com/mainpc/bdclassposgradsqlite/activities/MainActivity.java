package br.com.mainpc.bdclassposgradsqlite.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import br.com.mainpc.bdclassposgradsqlite.R;
import br.com.mainpc.bdclassposgradsqlite.adapters.UserAdapter;
import br.com.mainpc.bdclassposgradsqlite.dao.UserDAO;
import br.com.mainpc.bdclassposgradsqlite.dao.UserDAOImpl;
import br.com.mainpc.bdclassposgradsqlite.helpers.BDSQLiteHelper;
import br.com.mainpc.bdclassposgradsqlite.helpers.Database;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.user_listview);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CadastroActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        listAllUsers();
    }

    private void listAllUsers() {
        BDSQLiteHelper helper = new BDSQLiteHelper(this);
        Database db = new Database(helper);
        UserDAO dao = new UserDAOImpl();
        adapter = new UserAdapter(this, dao.getUsers(db));
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
