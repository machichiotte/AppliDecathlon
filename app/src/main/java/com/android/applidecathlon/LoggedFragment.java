package com.android.applidecathlon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.applidecathlon.model.Store;
import com.android.applidecathlon.model.Stores;
import com.android.applidecathlon.model.Users;
import com.android.applidecathlon.provider.StoreProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Elias on 05/08/2016.
 */
public class LoggedFragment extends Fragment {

    // Views
    // --------------------------------------------------------------------------------------------
    @BindView(R.id.tv_log)
    TextView tvLog;
    @BindView(R.id.tv_store)
    TextView tvStore;
    @BindView(R.id.tv_id)
    TextView tvId;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_director)
    TextView tvDirector;
    @BindView(R.id.tv_director_title)
    TextView tvDirectorTitle;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_country)
    TextView tvCountry;

    // Private fields
    // ---------------------------------------------------------------------------------------------
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;
    private Stores mStores;

    // Life cycle
    // --------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_logged, container, false);
        ButterKnife.bind(this, v);

        mStores = StoreProvider.getStores(getActivity().getApplicationContext());

        // single_value_read]
        final String userId = auth.getCurrentUser().getUid();
        mDatabase.child("users").child(userId).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        Users user = dataSnapshot.getValue(Users.class);

                        if (user == null) {
                            // User is null, error out
                            Log.e("TAG", "User " + userId + " is unexpectedly null");
                        } else {
                            tvLog.setText(user.getFirstname() + " " + user.getLastname());
                            addStoreDetails(user);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w("TAG", "getUser:onCancelled", databaseError.toException());
                    }
                });

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void addStoreDetails(Users user) {

        mStores.getData().getStores().size();
        Store store;

        for (int i = 0; i < mStores.getData().getStores().size(); i++) {
            if (mStores.getData().getStores().get(i).getName().equals(user.getStore())) {
                store = mStores.getData().getStores().get(i);
                tvStore.setText(store.getName());
                tvAddress.setText(store.getAddress());
                tvId.setText(Integer.toString(store.getId()));
                tvName.setText(store.getName());

                if (store.getDirectorLastName() != null) {
                    tvDirector.setVisibility(View.VISIBLE);
                    tvDirectorTitle.setVisibility(View.VISIBLE);
                    tvDirector.setText(store.getDirectorLastName().toString());
                } else {
                    tvDirector.setVisibility(View.GONE);
                    tvDirectorTitle.setVisibility(View.GONE);
                }

                tvCountry.setText(store.getCountry());
            }
        }

    }

    // onClick listener
    // --------------------------------------------------------------------------------------------
    @OnClick(R.id.btn_change)
    void showStoreChangeFragment() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SignUpPreferedFragment()).addToBackStack(null).commit();
    }

    @OnClick(R.id.btn_logout)
    void showLoginFragment() {
        auth.signOut();
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).addToBackStack(null).commit();
    }
}


