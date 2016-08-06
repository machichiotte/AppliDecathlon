package com.android.applidecathlon;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Elias on 05/08/2016.
 */
public class LoginFragment extends Fragment {

    // Views
    // --------------------------------------------------------------------------------------------
    @BindView(R.id.edt_login_email)
    EditText edtLoginEmail;
    @BindView(R.id.edt_login_password)
    EditText edtLoginPassword;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    // Private fields
    // ---------------------------------------------------------------------------------------------
    private FirebaseAuth auth;

    // Life cycle
    // --------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoggedFragment()).addToBackStack(null).commit();
        }

    }


    // onClick listener
    // --------------------------------------------------------------------------------------------
    @OnClick(R.id.btn_login)
    void showLoggedFragment() {

        String email = edtLoginEmail.getText().toString();
        final String password = edtLoginPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getActivity().getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity().getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        //authenticate user
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                //edtLoginPassword.setError(getString(R.string.minimum_password));
                                Toast.makeText(getActivity().getApplicationContext(), R.string.password_short, Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(getActivity().getApplicationContext(), R.string.logpass_wrong, Toast.LENGTH_LONG).show();
                            }
                        } else {
                            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoggedFragment()).addToBackStack(null).commit();
                        }
                    }
                });

    }

    @OnClick(R.id.btn_create)
    void showSignUpNameFragment(View view) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SignUpNameFragment()).addToBackStack(null).commit();
    }
}
