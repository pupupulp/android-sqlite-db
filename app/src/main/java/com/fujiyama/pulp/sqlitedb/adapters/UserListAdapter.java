package com.fujiyama.pulp.sqlitedb.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.tables.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    class UserViewHolder extends RecyclerView.ViewHolder {
        private UserViewHolder(View view) {
            super(view);
        }
    }

    private final LayoutInflater mInflater;
    private List<User> mUsers;

    UserListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if(mUsers != null) {
            User current = mUsers.get(position);
        } else {
            //
        }
    }

    @Override
    public int getItemCount() {
        if(mUsers != null) return mUsers.size();
        return 0;
    }
}
