package com.android.applidecathlon;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.firebase.client.Firebase;

import butterknife.ButterKnife;

/**
 * Created by Elias on 05/08/2016.
 */
public class MainActivity extends FragmentActivity {

    // Life cycle
    // --------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // Show "menu" view
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();

        Firebase.setAndroidContext(this);
    }
}
