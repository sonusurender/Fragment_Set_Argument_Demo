package com.fragmentsetargument_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static Button defaultFragment, argumentFragment;
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();//Get Fragment Manager

        //Find Ids
        defaultFragment = (Button) findViewById(R.id.setDefaultFragment);
        argumentFragment = (Button) findViewById(R.id.setArgumentFragment);

        //Implement Click Listener
        defaultFragment.setOnClickListener(this);
        argumentFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setDefaultFragment:

                //Replace default fragment
                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new DefaultFragment()).commit();
                break;
            case R.id.setArgumentFragment:

                Fragment argumentFragment = new ArgumentFragment();//Get Fragment Instance
                Bundle data = new Bundle();//Use bundle to pass data
                data.putString("data", "This is Argument Fragment");//put string, int, etc in bundle with a key value
                argumentFragment.setArguments(data);//Finally set argument bundle to fragment

                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, argumentFragment).commit();//now replace the argument fragment

                /**  Note: If you are passing argument in fragment then don't use below code always replace fragment instance where we had set bundle as argument as we had done above else it will give exception  **/
                //   fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new ArgumentFragment()).commit();
                break;
        }

    }
}
