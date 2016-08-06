package com.android.applidecathlon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.applidecathlon.model.Stores;
import com.android.applidecathlon.provider.StoreProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Elias on 05/08/2016.
 */
public class SignUpPreferedFragment extends Fragment {

    // Views
    // --------------------------------------------------------------------------------------------
    @BindView(R.id.radiogroup)
    RadioGroup radioGroup;

    // Private fields
    // ---------------------------------------------------------------------------------------------
    private Stores mStores;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;
    private String selectedButton = "";

    // Life cycle
    // --------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sign_up_prefered, container, false);
        ButterKnife.bind(this, v);

        mStores = StoreProvider.getStores(getActivity().getApplicationContext());

        addRadioButtons(mStores.getData().getStores().size());

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void addRadioButtons(int number) {

        for (int row = 0; row < 1; row++) {
            final RadioGroup ll = new RadioGroup(getActivity());
            ll.setOrientation(LinearLayout.VERTICAL);

            for (int i = 0; i <= number - 1; i++) {
                RadioButton rdbtn = new RadioButton(getActivity());
                rdbtn.setText(mStores.getData().getStores().get(i).getName());
                ll.addView(rdbtn);

                rdbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // get selected radio button from radioGroup
                        int selectedId = ll.getCheckedRadioButtonId();
                        // find the radio button by returned id
                        RadioButton radioButton = (RadioButton) getActivity().findViewById(selectedId);

                        selectedButton = radioButton.getText().toString();
                    }
                });

            }

            radioGroup.addView(ll);
        }

    }

    // onClick listener
    // --------------------------------------------------------------------------------------------
    @OnClick(R.id.btn_create_my)
    void showLoggedFragment() {

        if (!selectedButton.equals("")) {

            Map<String, Object> store = new HashMap<String, Object>();
            store.put("store", selectedButton);
            mDatabase.child("users").child(auth.getCurrentUser().getUid()).updateChildren(store);

            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoggedFragment()).addToBackStack(null).commit();
        }
    }

}
