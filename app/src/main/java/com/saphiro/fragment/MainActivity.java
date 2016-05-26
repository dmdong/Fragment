package com.saphiro.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();
        if(count > 1)
            getFragmentManager().popBackStack();
        else
            super.onBackPressed();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment1 f1 = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putString("title", "1st Fragment");
        f1.setArguments(bundle);

        addFragment(f1, true);
    }

    public void addFragment(Fragment fragment, boolean addedToBackStack) {

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);

        if (addedToBackStack)
            transaction.addToBackStack(fragment.getTag());

        transaction.commit();

    }
}
