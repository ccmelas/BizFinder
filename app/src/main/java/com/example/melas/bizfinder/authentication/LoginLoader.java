package com.example.melas.bizfinder.authentication;

import android.content.AsyncTaskLoader;
import android.content.Context;


public class LoginLoader extends AsyncTaskLoader<String> {

    public LoginLoader(Context context, String entered_email, String entered_password) {
        super(context);
    }

    @Override
    public String loadInBackground() {
        return null;
    }
}
