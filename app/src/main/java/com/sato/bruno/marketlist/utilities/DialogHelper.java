package com.sato.bruno.marketlist.utilities;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.widget.ProgressBar;

import com.sato.bruno.marketlist.R;

public class DialogHelper {
    private static AlertDialog dialogLogin;

    public static void dialogLoading(Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        progressBar.getIndeterminateDrawable().setColorFilter(context.getResources().getColor(R.color.colorButtonPrimary), android.graphics.PorterDuff.Mode.MULTIPLY);
        builder.setView(progressBar);

        builder.setCancelable(true);

        dialogLogin = builder.create();
        dialogLogin.show();
    }
    public static void removeDialogLogin() {
        dialogLogin.dismiss();
    }
}
