package com.example.kuliah.Model;

public class ModelUser {
    private String Username;
    private String Password;
    public ModelUser(){}
    public ModelUser(String Username, String Password){
        this.Username = Username;
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
