package br.ufmg.coltec.tp.recuperacaofinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubService {

    @GET("users/{username}/json")
    public Call<User> getUser(@Path("username") String username);

    @GET("group/{id}/json")
    public  Call<List<User>> groupList(@Path("id") int groupId);

}
