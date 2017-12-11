package com.sato.bruno.marketlist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sato.bruno.marketlist.R;

import java.util.List;

public class ConfigAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> configuracoes;

    public ConfigAdapter(@NonNull Context context, @NonNull List<String> objects) {

        super(context, 0, objects);
        this.context = context;
        this.configuracoes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = null;

        if (this.configuracoes != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_configuracoes, parent, false);

            TextView configuracao = view.findViewById(R.id.nome_config);

            configuracao.setText(configuracoes.get(position));
        }

        return view;
    }
}
