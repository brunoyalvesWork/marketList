package com.sato.bruno.marketlist.utilities;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class VerificaConexao {

    public static boolean isConectado(ConnectivityManager connectivityManager) {
        NetworkInfo wifiCheck = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo redeMovelCheck = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return (wifiCheck.isConnected() || redeMovelCheck.isConnected());
    }

}
