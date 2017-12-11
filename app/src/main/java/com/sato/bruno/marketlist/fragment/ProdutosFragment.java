package com.sato.bruno.marketlist.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sato.bruno.marketlist.R;
import com.sato.bruno.marketlist.adapter.ProdutoAdapter;
import com.sato.bruno.marketlist.model.dao.ProdutoDAO;
import com.sato.bruno.marketlist.model.om.Produto;

import java.util.List;

public class ProdutosFragment extends Fragment {

    private ArrayAdapter adapter;
    private List<Produto> produtos;

    public ProdutosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_produtos, container, false);
        ProdutoDAO produtoDAO = new ProdutoDAO(getActivity());

        produtos = produtoDAO.getProdutos();

        ListView lista = view.findViewById(R.id.lista_produto);
        adapter = new ProdutoAdapter(getActivity(), produtos);
        lista.setAdapter(adapter);

        return view;
    }

}
