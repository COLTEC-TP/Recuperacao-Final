package br.ufmg.coltec.tp.recuperacaofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoActivity extends Activity {

    private static GitHubService service;
    private List<Repo> mRepos;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        service = RetrofitConfig.getRetrofit();

        setContentView(R.layout.activity_user_info);

        getActionBar().setTitle("Informações Detalhadas");

        mUser = (User) getIntent().getSerializableExtra("UserObj");

        //Nome
        TextView nomeText = findViewById(R.id.nome);
        nomeText.setText(mUser.getName());

        //Login
        TextView loginText = findViewById(R.id.login);
        loginText.setText(mUser.getLogin());

        //Empresa (se houver)
        TextView empresaText = findViewById(R.id.empresa);
        empresaText.setText(mUser.getCompany());

        //E-mail (se houver)
        TextView emailText = findViewById(R.id.email);
        emailText.setText((String)mUser.getEmail());

        //Biografia (se houver)
        TextView biografiaText = findViewById(R.id.biografia);
        biografiaText.setText(mUser.getBio());

        //Data de criação
        TextView createdText = findViewById(R.id.created);
        createdText.setText(mUser.getCreatedAt());

        //Número de Repositórios
        TextView numRepoText = findViewById(R.id.numRepos);
        numRepoText.setText(String.valueOf(mUser.getPublicRepos()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.repoList:
                getReposInfo(mUser.getLogin());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openRepoList () {
        Intent intent = new Intent(getBaseContext(), RepoListActivity.class);
        intent.putExtra("ReposObj", (Serializable) mRepos);
        startActivity(intent);
    }

    private void getReposInfo (String username) {
        Call<List<Repo>> call = service.listRepos(username);

        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                mRepos = response.body();
                openRepoList();
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}
