package com.sato.bruno.marketlist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sato.bruno.marketlist.R;
import com.sato.bruno.marketlist.model.om.Produto;

import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produto> {

    private Context context;
    private List<Produto> produtos;


    public ProdutoAdapter(@NonNull Context context, @NonNull List<Produto> objects) {
        super(context, 0, objects);
        this.context = context;
        this.produtos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;

        if (this.produtos != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_produto, parent, false);

            TextView nome = view.findViewById(R.id.tx_nome_produto);
            ImageView icon = view.findViewById(R.id.im_icon_produto);

            Produto produto = produtos.get(position);

            nome.setText(produto.getNome());
            icon.setImageResource(Integer.parseInt(produto.getIcone()));
        }

        return view;
    }
}
