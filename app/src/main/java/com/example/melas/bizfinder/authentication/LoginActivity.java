package com.example.melas.bizfinder.authentication;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.melas.bizfinder.R;

public class LoginActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private EditText email_address;
    private EditText password;
    private Button loginButton;
    private LoaderManager loaderManager;
    private static final int LOGIN_LOADER_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        email_address = (EditText) findViewById(R.id.email_address);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login_button);
        loaderManager = getLoaderManager();

        loginButton.setOnClickListener(loginButtonClicked);
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        String entered_email = email_address.getText().toString();
        String entered_password = password.getText().toString();
        return new LoginLoader(this, entered_email, entered_password);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {

    }


    @Override
    public void onLoaderReset(Loader<String> loader) {

    }

    private View.OnClickListener loginButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loaderManager.initLoader(LOGIN_LOADER_ID, null, LoginActivity.this);
        }
    };
}
