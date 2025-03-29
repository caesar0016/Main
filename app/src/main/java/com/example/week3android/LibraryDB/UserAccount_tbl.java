package com.example.week3android.LibraryDB;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class UserAccount_tbl {
    @PrimaryKey(autoGenerate = true)
    private int user_id;
    private String username;
    private String password;
    private String user_type;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public boolean isIs_archived() {
        return is_archived;
    }

    public void setIs_archived(boolean is_archived) {
        this.is_archived = is_archived;
    }

    public UserAccount_tbl(String username, String password, String user_type, String requirements, boolean is_archived) {
        this.username = username;
        this.password = password;
        this.user_type = user_type;
        this.requirements = requirements;
        this.is_archived = is_archived;
    }

    @Ignore
    public UserAccount_tbl(int user_id, String username, String password, String user_type, String requirements, boolean is_archived) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
        this.requirements = requirements;
        this.is_archived = is_archived;
    }

    private String requirements;
    private boolean is_archived;



}
