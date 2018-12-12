package br.ufmg.coltec.tp.recuperacaofinal;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class RepoListAdapter extends CursorAdapter {

    private LayoutInflater cursorInflater;

    public RepoListAdapter(Context context, Cursor c) {
        super(context, c);
        cursorInflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return cursorInflater.inflate(R.layout.repo_list_view, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView nomeText = view.findViewById(R.id.nome);
        nomeText.setText(cursor.getString(0));

        TextView languageText = view.findViewById(R.id.language);
        languageText.setText(cursor.getString(1));

        TextView updated_atText = view.findViewById(R.id.updated_at);
        updated_atText.setText(cursor.getString(2));

    }
}
