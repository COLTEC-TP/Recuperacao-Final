package br.ufmg.coltec.tp.recuperacaofinal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

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

        RepoListAdapter adapter = new RepoListAdapter(this, mRepos);
        listView.setAdapter(adapter);
    }
}
