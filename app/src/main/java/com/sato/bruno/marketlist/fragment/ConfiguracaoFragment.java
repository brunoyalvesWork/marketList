package com.sato.bruno.marketlist.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sato.bruno.marketlist.R;
import com.sato.bruno.marketlist.activity.PerfilActivity;
import com.sato.bruno.marketlist.adapter.ConfigAdapter;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracaoFragment extends Fragment {

    private ArrayAdapter adapter;
    private List<String> configuracoes;

    public ConfiguracaoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_configuracao, container, false);

        configuracoes = new ArrayList<>();
        configuracoes.add("Perfil");

        ListView listaConfig = view.findViewById(R.id.lista_config);
        adapter = new ConfigAdapter(getActivity(), configuracoes);
        listaConfig.setAdapter(adapter);

        listaConfig.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (configuracoes.get(i).equals("Perfil")){
                    startActivity(new Intent(getActivity(), PerfilActivity.class));
                }
            }
        });

        return view;
    }

}
