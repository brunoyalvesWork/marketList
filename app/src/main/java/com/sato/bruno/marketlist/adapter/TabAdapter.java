package com.sato.bruno.marketlist.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sato.bruno.marketlist.fragment.ConfiguracaoFragment;
import com.sato.bruno.marketlist.fragment.ListaFragment;
import com.sato.bruno.marketlist.fragment.ProdutosFragment;

public class TabAdapter extends FragmentStatePagerAdapter{

    private String[] tituloAbas;

    public TabAdapter(FragmentManager fm, String[] labels) {
        super(fm);
        this.tituloAbas = labels;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ListaFragment();
                break;
            case 1:
                fragment = new ProdutosFragment();
                break;
            case 2:
                fragment = new ConfiguracaoFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tituloAbas.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tituloAbas[position];
    }
}
