package com.sato.bruno.marketlist.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sato.bruno.marketlist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfiguracaoFragment extends Fragment {

    public ConfiguracaoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_configuracao, container, false);



        return view;
    }

}
