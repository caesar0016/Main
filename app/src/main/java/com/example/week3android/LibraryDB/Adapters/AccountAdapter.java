package com.example.week3android.LibraryDB.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week3android.LibraryDB.DaoLibrary;
import com.example.week3android.LibraryDB.RoomDB;
import com.example.week3android.LibraryDB.UserAccount_tbl;
import com.example.week3android.ListAccount;
import com.example.week3android.UpdateUser;
import com.example.week3android.databinding.AccountRowsBinding;

import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {
    private List<UserAccount_tbl> list;
    private DaoLibrary dao;
    private RoomDB db;

    ListAccount context;


    // Add a constructor to pass the list of UserAccount_tbl
    public AccountAdapter(List<UserAccount_tbl> list, Context context) {
        this.list = list;
        this.context = (ListAccount) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(AccountRowsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserAccount_tbl model = list.get(position);

        holder.binding.txtUsernameView.setText(model.getUsername());
        holder.binding.txtrequirements1.setText(model.getRequirements());
        holder.binding.txtUserType.setText(model.getUser_type());

        holder.binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, UpdateUser.class)
                        .putExtra("user_id", model.getUser_id())
                        .putExtra("username", model.getUsername())
                        .putExtra("password", model.getPassword())
                        .putExtra("user_type", model.getUser_type());

                context.startActivity(intent);

            }
        });


        holder.binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao = RoomDB.getInstance(context).daoLibrary();

                AsyncTask.execute(() ->{
                    dao.deleteUserAccount1(model.getUser_id());
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        AccountRowsBinding binding;

        public ViewHolder(AccountRowsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}






