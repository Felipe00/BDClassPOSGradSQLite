package br.com.mainpc.bdclassposgradsqlite.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.mainpc.bdclassposgradsqlite.R;
import br.com.mainpc.bdclassposgradsqlite.models.User;

/**
 * Created by javab0y on 15/10/17.
 */

public class UserAdapter extends BaseAdapter {

    private List<User> users = new ArrayList<>();
    private LayoutInflater inflater;

    public UserAdapter(Context ctx, List<User> users) {
        inflater = LayoutInflater.from(ctx);
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return users.get(i).getId().intValue();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = inflater.inflate(R.layout.item_user_layout, viewGroup, false);
        TextView name, height;
        name = v.findViewById(R.id.item_name);
        height = v.findViewById(R.id.item_height);

        name.setText(users.get(i).getName());
        height.setText(users.get(i).getHeight() + "");
        return v;
    }

    public void update(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }
}
