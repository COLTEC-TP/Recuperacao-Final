package br.ufmg.coltec.tp.recuperacaofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private static GitHubService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getActionBar().setTitle("Tela de login");

        final Button loginButton = findViewById(R.id.searchButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText loginText = findViewById(R.id.login);
                String username = loginText.getText().toString();
                if (!username.isEmpty()) {
                    getUserInfo(username);
                } else {
                    Toast.makeText(getApplicationContext(),"Insira um nome de usuário válido!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        service = RetrofitConfig.getRetrofit();

        String username = "jemaf";
        getUserInfo(username);
    }


    private void getUserInfo (String username) {
        Call<User> call = service.getUser(username);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                User user = response.body();

                if (user != null) {
                    Intent intent = new Intent(getBaseContext(), UserInfoActivity.class);
                    intent.putExtra("UserObj", user);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Usuário não encontrado!",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
