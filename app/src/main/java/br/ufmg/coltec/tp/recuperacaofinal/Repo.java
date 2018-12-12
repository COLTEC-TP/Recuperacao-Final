package br.ufmg.coltec.tp.recuperacaofinal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Repo implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("updated_at")
    @Expose
    private String updated_at;

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
