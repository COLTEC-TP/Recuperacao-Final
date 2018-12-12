package br.ufmg.coltec.tp.recuperacaofinal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    EditText loginText = findViewById(R.id.login);


  }

    private void makeCall(final TextView mPriceTextView, final String currencyCode) {
        GitHubService service = new RetrofitConfig().getGitHubService();
        Call<User> userCall = service.getUser("username");

// fazendo a requisição de forma assíncrona
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

                // Manipulação do endereço recebido
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Tratamento de eventual erro de requisição
            }
        });

    }
}
