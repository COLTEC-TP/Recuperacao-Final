package br.ufmg.coltec.tp.recuperacaofinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RepoListActivity extends Activity {

    private List<Repo> mRepos;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_repo_list);
        getActionBar().setTitle("Lista de repositórios");

        mRepos = (List<Repo>) getIntent().getSerializableExtra("ReposObj");
        populateRepoList();
    }

    private void populateRepoList () {


        listView = (ListView)findViewById(R.id.repoList);

//        textView = (TextView)findViewById(R.id.textView);
//        listItem = getResources().getStringArray(R.array.array_technology);

//        final ArrayAdapter<Repo> adapter = new ArrayAdapter<>(this,
//                R.layout.repo_list_view, R.id.nome, mRepos);

//        listView.setAdapter(adapter);


//        for (int i = 0; i < 1; i++) {
//            Repo repo = mRepos.get(0);
//            //Nome
//            TextView nomeText = findViewById(R.id.nome);
//            nomeText.setText(repo.getName());
//
//            //Login
//            TextView languageText = findViewById(R.id.language);
//            languageText.setText(repo.getLanguage());
//
//            //Empresa (se houver)
//            TextView updated_atText = findViewById(R.id.updated_at);
//            updated_atText.setText(repo.getUpdated_at());
//        }
    }
}
