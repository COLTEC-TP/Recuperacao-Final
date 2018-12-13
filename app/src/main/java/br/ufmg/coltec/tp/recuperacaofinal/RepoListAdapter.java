package br.ufmg.coltec.tp.recuperacaofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class RepoListAdapter extends ArrayAdapter<Repo>{

    private final Context context;
    private final List<Repo> mRepos;

    public RepoListAdapter(Context context, List<Repo> repos) {
        super(context, R.layout.repo_list_view, repos);
        this.context = context;
        this.mRepos = repos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.repo_list_view, parent, false);

        TextView nomeText = rowView.findViewById(R.id.nome);
        nomeText.setText(mRepos.get(position).getName());

        TextView languageText = rowView.findViewById(R.id.language);
        languageText.setText(mRepos.get(position).getLanguage());

        TextView updated_atText = rowView.findViewById(R.id.updated_at);
        updated_atText.setText(mRepos.get(position).getUpdated_at());
        return rowView;
    }
}
