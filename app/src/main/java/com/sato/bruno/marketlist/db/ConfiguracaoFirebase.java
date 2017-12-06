package com.sato.bruno.marketlist.db;

import com.google.firebase.auth.FirebaseAuth;

public class ConfiguracaoFirebase {

    private static FirebaseAuth firebaseAuth;

    public static FirebaseAuth getFirebaseAuth() {

        if (firebaseAuth == null) {

            firebaseAuth = FirebaseAuth.getInstance();
        }
        return firebaseAuth;
    }
}
