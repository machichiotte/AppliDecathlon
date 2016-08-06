package com.android.applidecathlon;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.applidecathlon.model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Elias on 05/08/2016.
 */
public class SignUpNameFragment extends Fragment {

    // Views
    // --------------------------------------------------------------------------------------------
    @BindView(R.id.edt_firstname)
    EditText edtFirstname;
    @BindView(R.id.edt_lastname)
    EditText edtLastname;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.edt_confirm_password)
    EditText edtConfirmPassword;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    // Private fields
    // ---------------------------------------------------------------------------------------------
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String confirmPassword;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;

    // Life cycle
    // --------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sign_up_name, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    // onClick listener
    // --------------------------------------------------------------------------------------------
    @OnClick(R.id.btn_next)
    void showSignUpPreferedFragment() {

        firstname = edtFirstname.getText().toString().trim();
        lastname = edtLastname.getText().toString().trim();
        email = edtEmail.getText().toString().trim();
        password = edtPassword.getText().toString().trim();
        confirmPassword = edtConfirmPassword.getText().toString().trim();

        if (TextUtils.isEmpty(firstname)) {
            Toast.makeText(getActivity().getApplicationContext(), R.string.firstname_str, Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(lastname)) {
            Toast.makeText(getActivity().getApplicationContext(), R.string.lastname_str, Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getActivity().getApplicationContext(), R.string.email_str, Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            Toast.makeText(getActivity().getApplicationContext(), R.string.password_str, Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity().getApplicationContext(), R.string.password_str, Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(getActivity().getApplicationContext(), R.string.password_short, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(getActivity().getApplicationContext(), R.string.password_wrong, Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        //create user
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);

                        writeNewUser(firstname, lastname, email, task.getResult().getUser().getUid());

                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SignUpPreferedFragment()).addToBackStack(null).commit();
                    }

                });

    }

    private void writeNewUser(String firstname, String lastname, String email, String uid) {
        Users user = new Users(firstname, lastname, email, "store_null");

        mDatabase.child("users").child(uid).setValue(user);
        Log.e("dbtest", mDatabase.child("users").child(uid).toString());
    }
}

