package com.saphiro.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Saphiro on 5/15/2016.
 */
public class Fragment1 extends Fragment{


    @BindView(R.id.fragmentTitle)
    TextView fragmentTitle;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.btnnext)
    Button btnNext;

//    TextView fragmentTitle;
//    EditText editText;
//    Button btnNext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_fragment1, container, false);
        ButterKnife.bind(this, root);
//        fragmentTitle = (TextView) root.findViewById(R.id.fragmentTitle);
//        editText = (EditText) root.findViewById(R.id.editText);
//        btnNext = (Button) root.findViewById(R.id.btnnext);


        Bundle bundle = getArguments();
        fragmentTitle.setText(bundle.getString("title"));

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Fragment1 f2 = new Fragment1();
                Bundle bundle2 = new Bundle();
                bundle2.putString("title", editText.getText().toString());
                f2.setArguments(bundle2);

                ((MainActivity) getActivity()).addFragment(f2, true);
            }

        });

        return root;
    }

}


