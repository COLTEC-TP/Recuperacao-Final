package br.ufmg.coltec.tp.recuperacaofinal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class User implements Serializable {

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("company")
    @Expose
    private String company;

    @SerializedName("email")
    @Expose
    private Object email;

    @SerializedName("bio")
    @Expose
    private String bio;

    @SerializedName("public_repos")
    @Expose
    private int publicRepos;

    @SerializedName("created_at")
    @Expose
    private String createdAt;


    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public Object getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public String getCreatedAt() {
        return createdAt;
    }

}
